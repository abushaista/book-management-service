package com.arif.bookmanagementservice.controller;

import com.arif.bookmanagementservice.dto.BookView;
import com.arif.bookmanagementservice.dto.CreateBookRequest;
import com.arif.bookmanagementservice.dto.UpdateBookRequest;
import com.arif.bookmanagementservice.entity.BookEntity;
import com.arif.bookmanagementservice.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void CreateBook(@Valid @RequestBody CreateBookRequest request) {
        this.bookService.CreateBook(request);
    }

    @GetMapping
    public List<BookView> getAllBooks(@RequestParam(required = false) String search) {
        return this.bookService.getAllBooks(search);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookView getBookById(@PathVariable UUID id) {
        return this.bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable UUID id, @Valid @RequestBody UpdateBookRequest request) {
        this.bookService.UpdateBook(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable UUID id) {
        this.bookService.DeleteBook(id);
    }
}
