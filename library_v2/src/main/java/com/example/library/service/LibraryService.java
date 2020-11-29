package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean addBook(Book book) {

        Book newBook = new Book(book.getTitle(), book.getAuthor(), book.getCopiesAvailable());
        bookRepository.addBook(newBook);
        return true;
    }

    public List<Book> getAll() {
        return bookRepository.getAll();
    }

}
