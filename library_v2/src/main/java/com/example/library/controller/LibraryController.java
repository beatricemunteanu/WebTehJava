package com.example.library.controller;

import com.example.library.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.library.service.LibraryService;

import java.util.List;

@RestController
@RequestMapping({"/library"})
public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping({"/all"})
    public List<Book> getAllBooks() {
        return libraryService.getAll();
    }

    @PostMapping({"/add"})
    public ResponseEntity<List<Void>> addBook(@RequestBody Book book) {
        boolean addedBook = libraryService.addBook(book);
        return addedBook ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
