package com.aitamh.nuvantapp.infraestructure.adapters.persistence;

import com.aitamh.nuvantapp.application.ports.output.CategoryRepository;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryJpaRepository categoryJpaRepository;

    public CategoryRepositoryImpl(CategoryJpaRepository categoryJpaRepository) {
      this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public CategoryEntity save(CategoryEntity categoryEntity) {
        return categoryJpaRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity findById(Long id) {
        return categoryJpaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        categoryJpaRepository.deleteById(id);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryJpaRepository.findAll();
    }

}
