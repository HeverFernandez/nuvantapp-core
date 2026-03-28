package com.aitamh.nuvantapp.product.repository.impl;

import com.aitamh.nuvantapp.product.repository.jpa.ProductJpaRepository;
import com.aitamh.nuvantapp.product.mapper.ProductMapper;
import com.aitamh.nuvantapp.product.repository.ProductRepository;
import com.aitamh.nuvantapp.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return productJpaRepository.save(productEntity);
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productJpaRepository.findById(id);

    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return productJpaRepository.findAll(pageable);
    }

    @Override
    public List<ProductEntity> findByStockLessThan(Integer stockMinimo) {
        return productJpaRepository.findByStockLessThan(stockMinimo);
    }
}
