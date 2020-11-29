package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.Borrowing;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BorrowingRepository {
    private final List<Borrowing> borrowing = new ArrayList<>();
    public BorrowingRepository() {
    }

}
