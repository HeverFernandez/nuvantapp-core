package com.aitamh.nuvantapp.product.mapper;

import com.aitamh.nuvantapp.product.entity.ProductEntity;
import com.aitamh.nuvantapp.product.dto.request.ProductRequest;
import com.aitamh.nuvantapp.product.dto.response.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductEntity toEntityFromRequest(ProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }

        ProductEntity product = new ProductEntity();
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


    public static ProductResponse toResponseFromEntity(ProductEntity product) {
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
                product.getSupplier(),
                product.getCategory()
        );
    }

    public static List<ProductResponse> toResponseFromEntity(List<ProductEntity> products) {
        if (products == null || products.isEmpty()) {
            return List.of();
        }

        return products.stream()
                .map(ProductMapper::toResponseFromEntity)
                .collect(Collectors.toList());
    }
}