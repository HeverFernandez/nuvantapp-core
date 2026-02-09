package com.aitamh.nuvantapp.infraestructure.adapters.rest;

import com.aitamh.nuvantapp.application.ports.input.CategoryService;
import com.aitamh.nuvantapp.infraestructure.adapters.persistence.entities.CategoryEntity;
import com.aitamh.nuvantapp.shared.pagination.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity categoryEntity) {
        CategoryEntity createdCategoryEntity = categoryService.createCategory(categoryEntity);
        return ResponseEntity.ok(createdCategoryEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity) {
        CategoryEntity updatedCategoryEntity = categoryService.updateCategory(id, categoryEntity);
        return ResponseEntity.ok(updatedCategoryEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<PaginationResponse<CategoryEntity>> listCategories(Pageable pagination) {
        Page<CategoryEntity> categories = categoryService.listCategories(pagination);
        return ResponseEntity.ok(PaginationResponse.fromPage(categories));
    }
}
