package com.aitamh.nuvantapp.application.services;

import com.aitamh.nuvantapp.application.ports.input.ProductService;
import com.aitamh.nuvantapp.application.ports.output.ProductRepository;
import com.aitamh.nuvantapp.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productoRepository) {
        this.productRepository = productoRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product producto) {
        Product existente = productRepository.findById(id);
        if (existente == null) {
            throw new IllegalArgumentException("Producto no encontrado");
        }
        producto.setId(id);
        return productRepository.save(producto);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> listProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> checkLowStock() {
        return productRepository.findByStockLessThan(10);
    }
}
