package com.aitamh.nuvantapp.domain.model;

import com.aitamh.nuvantapp.domain.model.enums.Status;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private Long id;

    private String code;

    private String name;

    private String description;

    private Category category;

    private UnitMeasure unitMeasure;

    private BigDecimal purchasePrice;

    private BigDecimal salePrice;

    private Integer stock;

    private Integer minStock;

    private String barcode;

    private Status status;

    private LocalDate expirationDate;

    private Boolean igvAffection;

    private String brand;

    private String supplier;

    private LocalDate creationDate;

    private LocalDate updateDate;

}
