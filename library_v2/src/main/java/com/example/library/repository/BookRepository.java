package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private final List<Book> library = new ArrayList<>();

    public BookRepository() {
    }

    public void addBook(Book book)
    {
        library.add(book);
    }

    public List<Book> getAll() {
        return library;
    }

    public Optional<Book> findBook(String title)
    {
        return library.stream().filter(book -> book.getTitle().equals(title)).findFirst();
    }

}