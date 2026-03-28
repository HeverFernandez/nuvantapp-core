package com.aitamh.nuvantapp.product.dto.response;


import com.aitamh.nuvantapp.product.entity.CategoryEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductResponse(
        Long id,
        String code,
        String name,
        String description,
        BigDecimal purchasePrice,
        BigDecimal salePrice,
        Integer stock,
        Integer minStock,
        LocalDate expirationDate,
        Boolean igvAffection,
        String brand,
        String supplier,
        CategoryEntity category
  ) {
}
