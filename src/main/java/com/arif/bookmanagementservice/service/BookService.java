package com.arif.bookmanagementservice.service;

import com.arif.bookmanagementservice.controller.exception.ResourceNotFoundException;
import com.arif.bookmanagementservice.dto.BookView;
import com.arif.bookmanagementservice.dto.CreateBookRequest;
import com.arif.bookmanagementservice.dto.UpdateBookRequest;
import com.arif.bookmanagementservice.entity.BookEntity;
import com.arif.bookmanagementservice.entity.CategoryEntity;
import com.arif.bookmanagementservice.repository.BookRepository;
import com.arif.bookmanagementservice.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<BookView> getAllBooks(String param){
        return this.bookRepository.findAllWithCategoryName(param);
    }

    public BookView getBookById(UUID id){
        return this.bookRepository.findByIdWithCategoryName(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Book not found")
                );
    }

    public void CreateBook(CreateBookRequest request){
        if(!this.categoryRepository.existsById(request.getCategoryId())){
            throw new ResourceNotFoundException("Category not found");
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setCategoryId(request.getCategoryId());
        bookEntity.setAuthor(request.getAuthor());
        bookEntity.setTitle(request.getTitle());
        bookEntity.setDescription(request.getDescription());
        bookEntity.setCategoryId(request.getCategoryId());
        bookEntity.setIsbn(request.getIsbn());
        bookEntity.setPublicationYear(request.getPublicationYear());
        this.bookRepository.save(bookEntity);
    }

    public void UpdateBook(UUID id, UpdateBookRequest request){
        if(!this.categoryRepository.existsById(request.getCategoryId())){
            throw new ResourceNotFoundException("Category not found");
        }
        BookEntity bookEntity = this.bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book not found")
        );
        bookEntity.setTitle(request.getTitle());
        bookEntity.setDescription(request.getDescription());
        bookEntity.setIsbn(request.getIsbn());
        bookEntity.setPublicationYear(request.getPublicationYear());
        bookEntity.setCategoryId(request.getCategoryId());
        this.bookRepository.save(bookEntity);
    }

    public void DeleteBook(UUID id){
        if(!this.categoryRepository.existsById(id)){
            throw new ResourceNotFoundException("Category not found");
        }
        this.bookRepository.deleteById(id);
    }
}
