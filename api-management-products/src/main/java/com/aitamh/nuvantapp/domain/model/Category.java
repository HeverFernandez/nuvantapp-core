package com.aitamh.nuvantapp.domain.model;

import com.aitamh.nuvantapp.domain.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Long id;

    private String name;

    private String description;

    private Status status;

}