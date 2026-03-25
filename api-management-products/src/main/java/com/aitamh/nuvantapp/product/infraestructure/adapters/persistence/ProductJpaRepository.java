package com.aitamh.nuvantapp.product.infraestructure.adapters.persistence;

import com.aitamh.nuvantapp.product.infraestructure.adapters.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByStockLessThan(Integer stockMinimo);
}
