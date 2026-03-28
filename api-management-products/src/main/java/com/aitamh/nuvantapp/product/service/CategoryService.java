package com.aitamh.nuvantapp.product.service;

import com.aitamh.nuvantapp.product.entity.CategoryEntity;
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
