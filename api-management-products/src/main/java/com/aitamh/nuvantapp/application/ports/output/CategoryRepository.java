package com.aitamh.nuvantapp.application.ports.output;

import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.ProductEntity;

import java.util.List;

public interface CategoryRepository {

    CategoryEntity save(CategoryEntity categoryEntity);

    CategoryEntity findById(Long id);

    void deleteById(Long id);

    List<CategoryEntity> findAll();

}
