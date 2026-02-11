package com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.response;


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
        String supplier
  ) {
}
