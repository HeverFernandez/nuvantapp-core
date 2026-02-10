package com.aitamh.nuvantapp.application.ports.output;

import com.aitamh.nuvantapp.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductRepository {

    Product save(Product producto);

    Product findById(Long id);

    void deleteById(Long id);

    Page<Product> findAll(Pageable pageable);

    List<Product> findByStockLessThan(Integer stockMinimo);

}
