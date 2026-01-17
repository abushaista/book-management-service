package com.arif.bookmanagementservice.service;

import com.arif.bookmanagementservice.controller.exception.ResourceNotFoundException;
import com.arif.bookmanagementservice.dto.CreateCategoryRequest;
import com.arif.bookmanagementservice.dto.UpdateCategoryRequest;
import com.arif.bookmanagementservice.entity.CategoryEntity;
import com.arif.bookmanagementservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
    public void save(CreateCategoryRequest request) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        this.repository.save(entity);
    }
    public List<CategoryEntity> getAll() {
        return this.repository.findAll();
    }
    public void Update(UUID id, UpdateCategoryRequest request) {
        CategoryEntity entity = getById(id);
        entity.setName(request.getCategoryName());
        entity.setDescription(request.getCategoryDescription());
        this.repository.save(entity);
    }
    public CategoryEntity getById(UUID id) {
        return this.repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Category does not exist"));
    }
    public void deleteById(UUID id) {
        this.repository.deleteById(id);
    }
}
