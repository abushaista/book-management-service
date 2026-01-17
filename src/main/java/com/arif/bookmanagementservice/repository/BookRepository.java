package com.arif.bookmanagementservice.repository;

import com.arif.bookmanagementservice.dto.BookView;
import com.arif.bookmanagementservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
    @Query("""
        SELECT new com.arif.bookmanagementservice.dto.BookView(
            b.id,
            b.title,
            b.author,
            b.isbn,
            b.publicationYear,
            b.categoryId,
            c.name,
            b.description
        )
        FROM BookEntity b
        JOIN CategoryEntity c ON c.id = b.categoryId
        WHERE (:q IS NULL
           OR LOWER(b.title) LIKE LOWER(CONCAT('%', :q, '%'))
           OR LOWER(b.author) LIKE LOWER(CONCAT('%', :q, '%')))
    """)
    List<BookView> findAllWithCategoryName(
            @Param("q") String q
    );

    @Query("""
        SELECT new com.arif.bookmanagementservice.dto.BookView(
            b.id,
            b.title,
            b.author,
            b.isbn,
            b.publicationYear,
            b.categoryId,
            c.name,
            b.description
        )
        FROM BookEntity b
        JOIN CategoryEntity c ON c.id = b.categoryId
        WHERE b.id = :id
    """)
    Optional<BookView> findByIdWithCategoryName(
            @Param("id") UUID id
    );
}
