package com.aitamh.nuvantapp.application.ports.output;

import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.ProductEntity;

import java.util.List;

public interface CategoryRepository {

    ProductEntity save(ProductEntity producto);

    ProductEntity findById(Long id);

    void deleteById(Long id);

    List<ProductEntity> findAll();

    List<ProductEntity> findByStockLessThan(Integer stockMinimo);

}
