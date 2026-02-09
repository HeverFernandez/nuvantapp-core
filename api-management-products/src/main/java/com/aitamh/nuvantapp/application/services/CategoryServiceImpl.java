package com.aitamh.nuvantapp.application.services;

import com.aitamh.nuvantapp.application.ports.input.CategoryService;
import com.aitamh.nuvantapp.application.ports.output.CategoryRepository;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public List<CategoryEntity> listCategories() {
        return categoryRepository.findAll();
    }
}
