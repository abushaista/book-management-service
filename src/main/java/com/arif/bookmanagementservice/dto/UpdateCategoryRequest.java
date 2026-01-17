package com.arif.bookmanagementservice.dto;

import lombok.Data;

@Data
public class UpdateCategoryRequest {
    private String categoryName;
    private String categoryDescription;
}
