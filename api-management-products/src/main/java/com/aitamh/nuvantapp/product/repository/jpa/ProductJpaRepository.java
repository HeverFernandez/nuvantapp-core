package com.aitamh.nuvantapp.product.repository.jpa;

import com.aitamh.nuvantapp.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByStockLessThan(Integer stockMinimo);
}
