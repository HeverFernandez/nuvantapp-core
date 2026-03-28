package com.aitamh.nuvantapp.product.service;

import com.aitamh.nuvantapp.product.dto.request.ProductRequest;
import com.aitamh.nuvantapp.product.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductResponse save(ProductRequest productRequest);

    ProductResponse update(Long id, ProductRequest product);

    void delete(Long id);

    Page<ProductResponse> findAll(Pageable pageable);

    List<ProductResponse> checkLowStock();

    Optional<ProductResponse> findById(Long id);

}
