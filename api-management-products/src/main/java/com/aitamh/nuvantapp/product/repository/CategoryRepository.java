package com.aitamh.nuvantapp.product.repository;

import com.aitamh.nuvantapp.product.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryRepository {

    CategoryEntity save(CategoryEntity categoryEntity);

    Optional<CategoryEntity> findById(Long id);

    void deleteById(Long id);

    Page<CategoryEntity> findAll(Pageable pageable);

}
