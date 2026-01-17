package com.arif.bookmanagementservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCategoryRequest {
    @NotBlank(message = "name required")
    private String categoryName;
    private String categoryDescription;
}
