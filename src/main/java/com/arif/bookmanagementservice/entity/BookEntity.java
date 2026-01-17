package com.arif.bookmanagementservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    private Integer publicationYear;

    @Column(nullable = false)
    private UUID categoryId;

    private String description;
}
