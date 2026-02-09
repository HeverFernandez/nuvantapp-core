package com.aitamh.nuvantapp.infraestructure.adapters.persistence;

import com.aitamh.nuvantapp.application.ports.output.CategoryRepository;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


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
    public Page<CategoryEntity> findAll(Pageable pageable) {
        return categoryJpaRepository.findAll(pageable);
    }

}
