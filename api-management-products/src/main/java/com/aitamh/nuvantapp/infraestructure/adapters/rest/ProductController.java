package com.aitamh.nuvantapp.infraestructure.adapters.rest;

import com.aitamh.nuvantapp.application.mapper.ProductMapper;
import com.aitamh.nuvantapp.domain.model.Product;
import com.aitamh.nuvantapp.application.ports.input.ProductService;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.request.ProductRequest;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.response.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        Product product = ProductMapper.toModelFromRequest(productRequest);
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(ProductMapper.toResponseFromModel(createdProduct));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id,
                                                         @RequestBody ProductRequest productRequest) {
        Product product = ProductMapper.toModelFromRequest(productRequest);
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(ProductMapper.toResponseFromModel(updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = productService.listProduct();

        log.info("Retrieved {} products", products.toString());

        var productResponses = ProductMapper.toResponseFromModel(products);
        log.info("Retrieved {} productResponses", productResponses.toString());

        return ResponseEntity.ok(products);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductResponse>> getLowStockProducts() {
        List<Product> lowStockProductEntities = productService.checkLowStock();
        return ResponseEntity.ok(ProductMapper.toResponseFromModel(lowStockProductEntities));
    }
}
