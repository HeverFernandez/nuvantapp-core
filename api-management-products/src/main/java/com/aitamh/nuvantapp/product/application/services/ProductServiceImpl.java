package com.aitamh.nuvantapp.product.application.services;

import com.aitamh.nuvantapp.product.application.mapper.CategoryMapper;
import com.aitamh.nuvantapp.product.application.mapper.ProductMapper;
import com.aitamh.nuvantapp.product.application.ports.input.ProductService;
import com.aitamh.nuvantapp.product.application.ports.output.CategoryRepository;
import com.aitamh.nuvantapp.product.application.ports.output.ProductRepository;
import com.aitamh.nuvantapp.product.application.ports.output.UnitMeasureRepository;
import com.aitamh.nuvantapp.product.domain.model.Product;
import com.aitamh.nuvantapp.product.domain.model.UnitMeasure;
import com.aitamh.nuvantapp.product.infraestructure.adapters.persistence.entities.CategoryEntity;
import com.aitamh.nuvantapp.product.infraestructure.adapters.rest.dto.request.ProductRequest;
import com.aitamh.nuvantapp.product.infraestructure.adapters.rest.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UnitMeasureRepository unitMeasureRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        CategoryEntity category = categoryRepository.findById(productRequest.category())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + productRequest.category()));

        UnitMeasure unitMeasure = unitMeasureRepository.findById(productRequest.unitMeasurement())
                .orElseThrow(() -> new IllegalArgumentException("Unit measure not found with id: " + productRequest.unitMeasurement()));

        Product product = ProductMapper.toModelFromRequest(productRequest);

        product.setCategory(CategoryMapper.toModel(category));
        product.setUnitMeasure(unitMeasure);

        log.info("Service:: Creating product: {}", product.getName());

        Product productCreated = productRepository.save(product);

        return ProductMapper.toResponseFromModel(productCreated);
    }

    @Override
    public Product updateProduct(Long id, Product producto) {
        Product existente = productRepository.findById(id);
        if (existente == null) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        producto.setId(id);
        return productRepository.save(producto);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProductResponse> listProduct(Pageable pageable) {
        Page<Product> product = productRepository.findAll(pageable);

        log.info("Service:: Listing products, total elements: {}", product.stream().toList());
        return product.map(ProductMapper::toResponseFromModel);
    }

    @Override
    public List<Product> checkLowStock() {
        return productRepository.findByStockLessThan(10);
    }

    @Override
    public Product productById(Long id) {
        return productRepository.findById(id);
    }
}
