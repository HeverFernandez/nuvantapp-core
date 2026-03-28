package com.aitamh.nuvantapp.product.repository;

import com.aitamh.nuvantapp.product.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    ProductEntity save(ProductEntity producto);

    Optional<ProductEntity> findById(Long id);

    void deleteById(Long id);

    Page<ProductEntity> findAll(Pageable pageable);

    List<ProductEntity> findByStockLessThan(Integer stockMinimo);

}
