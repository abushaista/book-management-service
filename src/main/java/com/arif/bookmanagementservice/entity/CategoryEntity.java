package com.arif.bookmanagementservice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;
}
