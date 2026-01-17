package com.arif.bookmanagementservice.controller;

import com.arif.bookmanagementservice.dto.CreateCategoryRequest;
import com.arif.bookmanagementservice.dto.UpdateCategoryRequest;
import com.arif.bookmanagementservice.entity.CategoryEntity;
import com.arif.bookmanagementservice.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateCategory(@Valid @RequestBody CreateCategoryRequest request) {
        this.categoryService.save(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryEntity> getAllCategories() {
        return this.categoryService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryEntity getCategoryById(@PathVariable UUID id) {
        return this.categoryService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCategory(@PathVariable UUID id, @Valid @RequestBody UpdateCategoryRequest request) {
        this.categoryService.Update(id,request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable UUID id) {
        this.categoryService.deleteById(id);
    }
}
