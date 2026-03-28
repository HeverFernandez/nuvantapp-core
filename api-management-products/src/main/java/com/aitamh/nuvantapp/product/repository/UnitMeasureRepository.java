package com.aitamh.nuvantapp.product.repository;

import com.aitamh.nuvantapp.product.entity.UnitMeasureEntity;

import java.util.Optional;

public interface UnitMeasureRepository {

    Optional<UnitMeasureEntity> findById(Long id);
}
