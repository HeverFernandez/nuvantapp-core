package com.aitamh.nuvantapp.application.mapper;

import com.aitamh.nuvantapp.domain.model.UnitMeasure;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.UnitMeasureEntity;

public class UnitMeasureMapper {

    public static UnitMeasure toDomain(UnitMeasureEntity entity) {
        if (entity == null) {
            return null;
        }
        UnitMeasure domain = new UnitMeasure();

        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setAbbreviation(entity.getAbbreviation());
        domain.setType(entity.getType());
        return domain;
    }

    public static UnitMeasureEntity toEntity(UnitMeasure domain) {
        if (domain == null) {
            return null;
        }
        UnitMeasureEntity entity = new UnitMeasureEntity();

        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setAbbreviation(domain.getAbbreviation());
        entity.setType(domain.getType());
        return entity;
    }
}
