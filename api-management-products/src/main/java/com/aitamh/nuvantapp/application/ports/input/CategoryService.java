package com.aitamh.nuvantapp.application.ports.input;

import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity createCategory(CategoryEntity categoryEntity);

    CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity);

    void deleteCategory(Long id);

    List<CategoryEntity> listCategories();

}
