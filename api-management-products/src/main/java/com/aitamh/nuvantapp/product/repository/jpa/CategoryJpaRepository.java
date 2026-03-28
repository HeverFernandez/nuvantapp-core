package com.aitamh.nuvantapp.product.repository.jpa;

import com.aitamh.nuvantapp.product.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

}
