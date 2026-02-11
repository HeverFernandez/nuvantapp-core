package com.aitamh.nuvantapp.application.ports.input;

import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface CategoryService {

    CategoryEntity createCategory(CategoryEntity categoryEntity);

    CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity);

    void deleteCategory(Long id);

    Page<CategoryEntity> listCategories(Pageable pageable);

    Optional<CategoryEntity> getCategoryById(Long id);
}
