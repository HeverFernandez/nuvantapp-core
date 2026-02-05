package com.aitamh.nuvantapp.application.mapper;

import com.aitamh.nuvantapp.domain.model.Product;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.ProductEntity;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.request.ProductRequest;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }

        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setCode(product.getCode());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setCategoryEntity(CategoryMapper.toEntity(product.getCategory()));
        entity.setPurchasePrice(product.getPurchasePrice());
        entity.setSalePrice(product.getSalePrice());
        entity.setStock(product.getStock());
        entity.setMinStock(product.getMinStock());
        entity.setBarcode(product.getBarcode());
        entity.setStatus(product.getStatus());
        entity.setUnitMeasurement(product.getUnitMeasurement());
        entity.setExpirationDate(product.getExpirationDate());
        entity.setIgvAffection(product.getIgvAffection());
        entity.setBrand(product.getBrand());
        entity.setSupplier(product.getSupplier());
        entity.setCreationDate(product.getCreationDate());
        entity.setUpdateDate(product.getUpdateDate());
        return entity;
    }

    public static Product toModel(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        Product product = new Product();
        product.setId(entity.getId());
        product.setCode(entity.getCode());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setCategory(CategoryMapper.toModel(entity.getCategoryEntity()));
        product.setPurchasePrice(entity.getPurchasePrice());
        product.setSalePrice(entity.getSalePrice());
        product.setStock(entity.getStock());
        product.setMinStock(entity.getMinStock());
        product.setBarcode(entity.getBarcode());
        product.setStatus(entity.getStatus());
        product.setUnitMeasurement(entity.getUnitMeasurement());
        product.setExpirationDate(entity.getExpirationDate());
        product.setIgvAffection(entity.getIgvAffection());
        product.setBrand(entity.getBrand());
        product.setSupplier(entity.getSupplier());
        product.setCreationDate(entity.getCreationDate());
        product.setUpdateDate(entity.getUpdateDate());
        return product;
    }

    public static List<Product> toModel(List<ProductEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }

        return entities.stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());
    }

    public static Product toModelFromRequest(ProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }

        Product product = new Product();
        product.setCode(productRequest.code());
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setCategory(productRequest.categoryId());
        product.setPurchasePrice(productRequest.purchasePrice());
        product.setSalePrice(productRequest.salePrice());
        product.setStock(productRequest.stock());
        product.setMinStock(productRequest.minStock());
        product.setBarcode(productRequest.barcode());
        product.setStatus(productRequest.status());
        product.setUnitMeasurement(productRequest.unitMeasurement());
        product.setExpirationDate(productRequest.expirationDate());
        product.setIgvAffection(productRequest.igvAffection());
        product.setBrand(productRequest.brand());
        product.setSupplier(productRequest.supplier());
        return product;
    }

    public static ProductResponse toResponseFromModel(Product product) {
        if (product == null) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();
        productResponse.setCode(product.getCode());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPurchasePrice(product.getPurchasePrice());
        productResponse.setSalePrice(product.getSalePrice());
        productResponse.setStock(product.getStock());
        productResponse.setMinStock(product.getMinStock());
        productResponse.setUnitMeasurement(product.getUnitMeasurement());
        productResponse.setExpirationDate(product.getExpirationDate());
        productResponse.setIgvAffection(product.getIgvAffection());
        productResponse.setBrand(product.getBrand());
        productResponse.setSupplier(product.getSupplier());

        return productResponse;
    }

    public static List<ProductResponse> toResponseFromModel(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return List.of();
        }

        return products.stream()
                .map(ProductMapper::toResponseFromModel)
                .collect(Collectors.toList());
    }
}
