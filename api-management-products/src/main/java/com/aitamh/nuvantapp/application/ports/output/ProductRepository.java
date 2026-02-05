package com.aitamh.nuvantapp.application.ports.output;

import com.aitamh.nuvantapp.domain.model.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product producto);

    Product findById(Long id);

    void deleteById(Long id);

    List<Product> findAll();

    List<Product> findByStockLessThan(Integer stockMinimo);

}
