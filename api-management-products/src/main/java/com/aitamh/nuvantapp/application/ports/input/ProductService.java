package com.aitamh.nuvantapp.application.ports.input;

import com.aitamh.nuvantapp.domain.model.Product;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.request.ProductRequest;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Page<ProductResponse> listProduct(Pageable pageable);

    List<Product> checkLowStock();

    Product productById(Long id);

}
