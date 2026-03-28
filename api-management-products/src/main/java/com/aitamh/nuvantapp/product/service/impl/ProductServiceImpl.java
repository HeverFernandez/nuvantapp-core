package com.aitamh.nuvantapp.product.service.impl;

import com.aitamh.nuvantapp.product.entity.ProductEntity;
import com.aitamh.nuvantapp.product.entity.UnitMeasureEntity;
import com.aitamh.nuvantapp.product.entity.enums.Status;
import com.aitamh.nuvantapp.product.mapper.ProductMapper;
import com.aitamh.nuvantapp.product.service.ProductService;
import com.aitamh.nuvantapp.product.repository.CategoryRepository;
import com.aitamh.nuvantapp.product.repository.ProductRepository;
import com.aitamh.nuvantapp.product.repository.UnitMeasureRepository;
import com.aitamh.nuvantapp.product.entity.CategoryEntity;
import com.aitamh.nuvantapp.product.dto.request.ProductRequest;
import com.aitamh.nuvantapp.product.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UnitMeasureRepository unitMeasureRepository;

    @Override
    public ProductResponse save(ProductRequest productRequest) {
        CategoryEntity category = categoryRepository.findById(productRequest.category())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + productRequest.category()));

        UnitMeasureEntity unitMeasure = unitMeasureRepository.findById(productRequest.unitMeasurement())
                .orElseThrow(() -> new IllegalArgumentException("Unit measure not found with id: " + productRequest.unitMeasurement()));

        ProductEntity product = ProductMapper.toEntityFromRequest(productRequest);

        product.setCategory(category);
        product.setUnitMeasure(unitMeasure);

        log.info("Service:: Creating product: {}", product.getName());

        ProductEntity productCreated = productRepository.save(product);

        return ProductMapper.toResponseFromEntity(productCreated);
    }

    @Override
    public ProductResponse update(Long id, ProductRequest productRequest) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + id));

        productEntity.setCode(productRequest.code());
        productEntity.setName(productRequest.name());
        productEntity.setDescription(productRequest.description());
        productEntity.setPurchasePrice(productRequest.purchasePrice());
        productEntity.setSalePrice(productRequest.salePrice());
        productEntity.setStock(productRequest.stock());
        productEntity.setMinStock(productRequest.minStock());
        productEntity.setBarcode(productRequest.barcode());
        productEntity.setExpirationDate(productRequest.expirationDate());
        productEntity.setIgvAffection(productRequest.igvAffection());
        productEntity.setBrand(productRequest.brand());
        productEntity.setSupplier(productRequest.supplier());

        CategoryEntity category = categoryRepository.findById(productRequest.category())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada con id: " + productRequest.category()));
        productEntity.setCategory(category);

        UnitMeasureEntity unitMeasure = unitMeasureRepository.findById(productRequest.unitMeasurement())
                .orElseThrow(() -> new IllegalArgumentException("Unidad de medida no encontrada con id: " + productRequest.unitMeasurement()));
        productEntity.setUnitMeasure(unitMeasure);

        ProductEntity updatedProduct = productRepository.save(productEntity);

        return ProductMapper.toResponseFromEntity(updatedProduct);
    }

    @Override
    public void delete(Long id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + id));
        productEntity.setStatus(Status.INACTIVO);
        productRepository.save(productEntity);
    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable) {
        Page<ProductEntity> productEntities = productRepository.findAll(pageable);

        log.info("Service:: Listing products, total elements: {}", productEntities.stream().toList());
        return productEntities.map(ProductMapper::toResponseFromEntity);
    }

    @Override
    public List<ProductResponse> checkLowStock() {
        List<ProductEntity> productEntities = productRepository.findByStockLessThan(10);
        return ProductMapper.toResponseFromEntity(productEntities);
    }

    @Override
    public Optional<ProductResponse> findById(Long id) {
        log.info("Starting Service product:: Finding product by id: {}", id);
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con id: " + id));
        log.info("End Service product:: Finding product by id: {}", id);
        return Optional.of(ProductMapper.toResponseFromEntity(productEntity));
    }
}
