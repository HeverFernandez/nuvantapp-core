package com.aitamh.nuvantapp.application.ports.input;

import com.aitamh.nuvantapp.domain.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    List<Product> listProduct();

    List<Product> checkLowStock();
}
