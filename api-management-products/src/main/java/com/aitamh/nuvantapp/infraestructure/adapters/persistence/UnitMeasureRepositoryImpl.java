package com.aitamh.nuvantapp.infraestructure.adapters.persistence;

import com.aitamh.nuvantapp.application.ports.output.UnitMeasureRepository;
import com.aitamh.nuvantapp.domain.model.UnitMeasure;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitMeasureRepositoryImpl implements UnitMeasureRepository {

    private final UnitMeasureJpaRepository unitMeasureJpaRepository;

    public UnitMeasureRepositoryImpl(UnitMeasureJpaRepository unitMeasureJpaRepository) {
        this.unitMeasureJpaRepository = unitMeasureJpaRepository;
    }

    @Override
    public Optional<UnitMeasure> findById(Long id) {
        return unitMeasureJpaRepository.findById(id)
                .map(unitMeasureEntity -> new UnitMeasure(
                        unitMeasureEntity.getId(),
                        unitMeasureEntity.getName(),
                        unitMeasureEntity.getAbbreviation(),
                        unitMeasureEntity.getType()
                ));
    }
}
