package com.aitamh.nuvantapp.infraestructure.adapters.persistence;

import com.aitamh.nuvantapp.application.mapper.ProductMapper;
import com.aitamh.nuvantapp.domain.model.Product;
import com.aitamh.nuvantapp.application.ports.output.ProductRepository;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    ProductRepositoryImpl( ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product save(Product producto) {
        ProductEntity productEntity = ProductMapper.toEntity(producto);

        final ProductEntity product = productJpaRepository.save(productEntity);

        return ProductMapper.toModel(product);
    }

    @Override
    public Product findById(Long id) {
        final ProductEntity productEntity = productJpaRepository.findById(id).orElse(null);
        return ProductMapper.toModel(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        Page<ProductEntity> productEntity = productJpaRepository.findAll(pageable);
        return productEntity.map(ProductMapper::toModel);
    }

    @Override
    public List<Product> findByStockLessThan(Integer stockMinimo) {
        List<ProductEntity> productEntities = productJpaRepository.findByStockLessThan(stockMinimo);

        return ProductMapper.toModel(productEntities);
    }
}
