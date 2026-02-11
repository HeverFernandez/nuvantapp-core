package com.aitamh.nuvantapp.application.mapper;

import com.aitamh.nuvantapp.domain.model.Product;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.ProductEntity;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.request.ProductRequest;
import com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

//    ProductEntity toEntity(Product product);

    public static ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }

        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setCode(product.getCode());
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setCategory(CategoryMapper.toEntity(product.getCategory()));
        entity.setPurchasePrice(product.getPurchasePrice());
        entity.setSalePrice(product.getSalePrice());
        entity.setStock(product.getStock());
        entity.setMinStock(product.getMinStock());
        entity.setBarcode(product.getBarcode());
        entity.setStatus(product.getStatus());
        entity.setUnitMeasure(UnitMeasureMapper.toEntity(product.getUnitMeasure()));
        entity.setExpirationDate(product.getExpirationDate());
        entity.setIgvAffection(product.getIgvAffection());
        entity.setBrand(product.getBrand());
        entity.setSupplier(product.getSupplier());
        entity.setCreationDate(product.getCreationDate());
        entity.setUpdateDate(product.getUpdateDate());
        return entity;
    }

//    Product toModel(ProductEntity entity);

    public static Product toModel(ProductEntity entity) {
        if (entity == null) {
            return null;
        }

        Product product = new Product();
        product.setId(entity.getId());
        product.setCode(entity.getCode());
        product.setName(entity.getName());
        product.setDescription(entity.getDescription());
        product.setCategory(CategoryMapper.toModel(entity.getCategory()));
        product.setPurchasePrice(entity.getPurchasePrice());
        product.setSalePrice(entity.getSalePrice());
        product.setStock(entity.getStock());
        product.setMinStock(entity.getMinStock());
        product.setBarcode(entity.getBarcode());
        product.setStatus(entity.getStatus());
        product.setUnitMeasure(UnitMeasureMapper.toDomain(entity.getUnitMeasure()));
        product.setExpirationDate(entity.getExpirationDate());
        product.setIgvAffection(entity.getIgvAffection());
        product.setBrand(entity.getBrand());
        product.setSupplier(entity.getSupplier());
        product.setCreationDate(entity.getCreationDate());
        product.setUpdateDate(entity.getUpdateDate());
        return product;
    }

//    List<Product> toModel(List<ProductEntity> entities);

    public static List<Product> toModel(List<ProductEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }

        return entities.stream()
                .map(ProductMapper::toModel)
                .collect(Collectors.toList());
    }

//    Product toModelFromRequest(ProductRequest productRequest);

    public static Product toModelFromRequest(ProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }

        Product product = new Product();
        product.setCode(productRequest.code());
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPurchasePrice(productRequest.purchasePrice());
        product.setSalePrice(productRequest.salePrice());
        product.setStock(productRequest.stock());
        product.setMinStock(productRequest.minStock());
        product.setBarcode(productRequest.barcode());
        product.setExpirationDate(productRequest.expirationDate());
        product.setIgvAffection(productRequest.igvAffection());
        product.setBrand(productRequest.brand());
        product.setSupplier(productRequest.supplier());
        return product;
    }

//    ProductResponse toResponseFromModel(Product product);

    public static ProductResponse toResponseFromModel(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductResponse(
                product.getId(),
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getPurchasePrice(),
                product.getSalePrice(),
                product.getStock(),
                product.getMinStock(),
                product.getExpirationDate(),
                product.getIgvAffection(),
                product.getBrand(),
                product.getSupplier()
        );
    }

//    List<ProductResponse> toResponseFromModel(List<Product> products);

    public static List<ProductResponse> toResponseFromModel(List<Product> products) {
        if (products == null || products.isEmpty()) {
            return List.of();
        }

        return products.stream()
                .map(ProductMapper::toResponseFromModel)
                .collect(Collectors.toList());
    }
}
