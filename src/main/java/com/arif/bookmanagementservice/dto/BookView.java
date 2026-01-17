package com.arif.bookmanagementservice.dto;

import java.util.UUID;

public record BookView(
        UUID id,
        String title,
        String author,
        String isbn,
        Integer publicationYear,
        UUID categoryId,
        String categoryName,
        String description

) {
}
