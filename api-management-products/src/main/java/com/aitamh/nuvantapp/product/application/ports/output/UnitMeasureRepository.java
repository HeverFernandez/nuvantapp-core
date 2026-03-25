package com.aitamh.nuvantapp.product.application.ports.output;

import com.aitamh.nuvantapp.product.domain.model.UnitMeasure;

import java.util.Optional;

public interface UnitMeasureRepository {

    Optional<UnitMeasure> findById(Long id);
}
