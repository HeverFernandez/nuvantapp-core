package com.aitamh.nuvantapp.application.ports.output;

import com.aitamh.nuvantapp.domain.model.UnitMeasure;

import java.util.Optional;

public interface UnitMeasureRepository {

    Optional<UnitMeasure> findById(Long id);
}
