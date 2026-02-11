package com.aitamh.nuvantapp.infraestructure.adapters.persistence;

import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.UnitMeasureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitMeasureJpaRepository extends JpaRepository<UnitMeasureEntity, Long> {
}
