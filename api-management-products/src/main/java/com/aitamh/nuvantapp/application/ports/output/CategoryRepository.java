package com.aitamh.nuvantapp.application.ports.output;

import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryRepository {

    CategoryEntity save(CategoryEntity categoryEntity);

    CategoryEntity findById(Long id);

    void deleteById(Long id);

    Page<CategoryEntity> findAll(Pageable pageable);

}
