package com.arif.bookmanagementservice.service;

import com.arif.bookmanagementservice.controller.exception.ResourceNotFoundException;
import com.arif.bookmanagementservice.dto.BookView;
import com.arif.bookmanagementservice.dto.UpdateBookRequest;
import com.arif.bookmanagementservice.entity.CategoryEntity;
import com.arif.bookmanagementservice.repository.BookRepository;
import com.arif.bookmanagementservice.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void Should_return_book_when_find_by_id() {
        UUID bookId = UUID.randomUUID();
        BookView book = new BookView(
                bookId,
                "A Brief History of Time",
                "Stephen Hawking",
                "9780553380163",
                1988,
                UUID.randomUUID(),
                "history",
                "A landmark volume in science history explaining cosmology for the general public."
        );
        when(bookRepository.findByIdWithCategoryName(bookId))
                .thenReturn(Optional.of(book));
        BookView response = bookService.getBookById(bookId);

        assertThat(response).isNotNull();
        assertThat(response).isEqualTo(book);
        assertEquals(response.id(), bookId);
    }

    @Test
    void should_throw_exception_when_find_by_id_not_found() {
        UUID bookId = UUID.randomUUID();
        when(bookRepository.findByIdWithCategoryName(bookId))
                .thenReturn(Optional.empty());

        assertThatThrownBy(() -> bookService.getBookById(bookId));
        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class,
                () -> bookService.getBookById(bookId));
        assertThat(ex.getMessage()).isEqualTo("Book not found");
    }

    @Test
    void should_throw_exception_when_update_by_id_not_found() {
        UUID bookId = UUID.randomUUID();
        UUID CategoryId = UUID.randomUUID();
        UpdateBookRequest request = new UpdateBookRequest();
        request.setAuthor("Stephen Hawking");
        request.setTitle("A Brief History of Time");
        request.setDescription("A landmark volume in science history explaining cosmology for the general public.");
        request.setCategoryId(CategoryId);
        request.setIsbn("9780553380163");

        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(CategoryId);
        categoryEntity.setName("History");
        categoryEntity.setDescription("The History of Time");
        when(categoryRepository.existsById(CategoryId)).thenReturn(true);

        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());
        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class,
                () -> bookService.UpdateBook(bookId, request));
        assertThat(ex.getMessage()).isEqualTo("Book not found");
        verify(bookRepository, never()).save(any());
    }


    @Test
    void should_throw_exception_when_delete_by_id_not_found() {
        UUID bookId = UUID.randomUUID();
        when(bookRepository.existsById(bookId)).thenReturn(false);
        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class,
                () -> bookService.DeleteBook(bookId));
        assertThat(ex.getMessage()).isEqualTo("Book not found");
    }
}
