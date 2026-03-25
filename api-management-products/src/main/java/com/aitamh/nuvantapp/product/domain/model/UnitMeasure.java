package com.aitamh.nuvantapp.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UnitMeasure {

    private Long id;

    private String name;

    private String abbreviation;

    private String type;

}
