package com.aitamh.nuvantapp.application.mapper;

import com.aitamh.nuvantapp.domain.model.Category;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;

public class CategoryMapper {

    public static CategoryEntity toEntity(Category category) {
        if (category == null) {
            return null;
        }

        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());
        entity.setDescription(category.getDescription());
        entity.setStatus(category.getStatus());
        return entity;
    }

    public static Category toModel(CategoryEntity entity) {
        if (entity == null) {
            return null;
        }

        Category category = new Category();
        category.setId(entity.getId());
        category.setName(entity.getName());
        category.setDescription(entity.getDescription());
        category.setStatus(entity.getStatus());
        return category;
    }
}
