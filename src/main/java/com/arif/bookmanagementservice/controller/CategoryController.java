package com.arif.bookmanagementservice.controller;

import com.arif.bookmanagementservice.dto.CreateCategoryRequest;
import com.arif.bookmanagementservice.dto.UpdateCategoryRequest;
import com.arif.bookmanagementservice.entity.CategoryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    public CategoryController() {}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateCategory(@RequestBody CreateCategoryRequest request) {

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryEntity> getAllCategories() {
        return List.of();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryEntity getCategoryById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryRequest request) {

    }
}
