package com.example.library.controller;


import com.example.library.model.Book;
import com.example.library.model.Borrowing;
import com.example.library.service.BorrowingService;
import com.example.library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowingController {
    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @PostMapping({"/borrow/{username}/{title}"})
    public void borrowBook(@PathVariable String username, @PathVariable String title) throws Exception {
        borrowingService.borrowBook(username, title);
        //return borrowedBook ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping({"/return/{username}/{title}"})
    public void returnBook(@PathVariable String username, @PathVariable String title) throws Exception {
        borrowingService.returnBook(username, title);
        //return borrowedBook ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

