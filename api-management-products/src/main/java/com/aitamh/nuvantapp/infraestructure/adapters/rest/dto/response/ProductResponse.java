package com.aitamh.nuvantapp.infraestructure.adapters.rest.dto.response;

import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@ToString
public class ProductResponse{
    private String code;
    private String name;
    private String description;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private Integer stock;
    private Integer minStock;
    private LocalDate expirationDate;
    private Boolean igvAffection;
    private String brand;
    private String supplier;

}
