package com.aitamh.nuvantapp.application.ports.input;

import com.aitamh.nuvantapp.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Page<Product> listProduct(Pageable pageable);

    List<Product> checkLowStock();

    Product productById(Long id);

}
