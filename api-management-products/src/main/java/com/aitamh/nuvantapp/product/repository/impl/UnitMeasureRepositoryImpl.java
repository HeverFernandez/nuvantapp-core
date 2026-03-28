package com.aitamh.nuvantapp.product.repository.impl;

import com.aitamh.nuvantapp.product.entity.UnitMeasureEntity;
import com.aitamh.nuvantapp.product.repository.jpa.UnitMeasureJpaRepository;
import com.aitamh.nuvantapp.product.repository.UnitMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitMeasureRepositoryImpl implements UnitMeasureRepository {

    private final UnitMeasureJpaRepository unitMeasureJpaRepository;

    public UnitMeasureRepositoryImpl(UnitMeasureJpaRepository unitMeasureJpaRepository) {
        this.unitMeasureJpaRepository = unitMeasureJpaRepository;
    }

    @Override
    public Optional<UnitMeasureEntity> findById(Long id) {
        return unitMeasureJpaRepository.findById(id)
                .map(unitMeasureEntity -> new UnitMeasureEntity(
                        unitMeasureEntity.getId(),
                        unitMeasureEntity.getName(),
                        unitMeasureEntity.getAbbreviation(),
                        unitMeasureEntity.getType()
                ));
    }
}
