package com.arif.bookmanagementservice.controller;

import com.arif.bookmanagementservice.dto.CreateBookRequest;
import com.arif.bookmanagementservice.dto.UpdateBookRequest;
import com.arif.bookmanagementservice.entity.BookEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    public BookController() {}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void CreateBook(@RequestBody CreateBookRequest request) {

    }

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return List.of();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookEntity getBookById(@PathVariable Long id) {
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@PathVariable Long id, @RequestBody UpdateBookRequest request) {

    }
}
