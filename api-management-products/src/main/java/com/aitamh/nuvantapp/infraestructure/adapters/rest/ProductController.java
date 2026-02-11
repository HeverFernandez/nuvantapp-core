package com.aitamh.nuvantapp.infraestructure.adapters.rest;

import com.aitamh.nuvantapp.application.mapper.ProductMapper;
import com.aitamh.nuvantapp.application.ports.input.CategoryService;
import com.aitamh.nuvantapp.domain.model.Category;
import com.aitamh.nuvantapp.domain.model.Product;
import com.aitamh.nuvantapp.application.ports.input.ProductService;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.ProductEntity;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.request.ProductRequest;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.response.ProductResponse;
import com.aitamh.nuvantapp.shared.pagination.PaginationResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse createdProduct = productService.createProduct(productRequest);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id,
                                                         @RequestBody ProductRequest productRequest) {
        Product product = ProductMapper.toModelFromRequest(productRequest);
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(ProductMapper.toEntity(updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<PaginationResponse<ProductResponse>> listProducts(Pageable pagination) {
        Page<ProductResponse> products = productService.listProduct(pagination);
        log.info("Controller:: Listing products with pagination: {}", products.stream().toList());
        return ResponseEntity.ok(PaginationResponse.fromPage(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(ProductMapper.toEntity(productService.productById(id)));
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductResponse>> getLowStockProducts() {
        List<Product> lowStockProductEntities = productService.checkLowStock();
        return ResponseEntity.ok(ProductMapper.toResponseFromModel(lowStockProductEntities));
    }
}
