package com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.request;

import com.aitamh.nuvantapp.domain.model.Category;
import com.aitamh.nuvantapp.domain.model.UnitMeasure;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductRequest(
        String code,
        String name,
        String description,
        Category categoryId,
        BigDecimal purchasePrice,
        BigDecimal salePrice,
        Integer stock,
        Integer minStock,
        String barcode,
        UnitMeasure unitMeasurement,
        LocalDate expirationDate,
        Boolean igvAffection,
        String brand,
        String supplier
) {
}
