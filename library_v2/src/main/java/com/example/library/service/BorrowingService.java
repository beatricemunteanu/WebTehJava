package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.Borrowing;
import com.example.library.model.Member;
import org.springframework.stereotype.Service;
import com.example.library.repository.BookRepository;
import com.example.library.repository.MemberRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BorrowingService {
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public BorrowingService(MemberRepository memberRepository, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public void borrowBook(String username, String bookTitle) throws Exception {
        Member member = memberRepository.findByUsername(username).orElseThrow(NoSuchElementException::new);
        Book foundBook = bookRepository.findBook(bookTitle).orElseThrow(NoSuchElementException::new);

        if (foundBook.getCopiesAvailable() > 0) {
            foundBook.setCopiesAvailable(foundBook.getCopiesAvailable() - 1);
            Borrowing borrowedBook = new Borrowing(member, foundBook);
            member.addBorrowings(borrowedBook);
        }
        else
            throw new Exception("Book " + foundBook.getTitle() + " unavailable");
    }

    public void returnBook(String username, String bookTitle) throws Exception {
        Member member = memberRepository.findByUsername(username).orElseThrow(NoSuchElementException::new);
        Book foundBook = bookRepository.findBook(bookTitle).orElseThrow(NoSuchElementException::new);

        if (foundBook.getId() != null){
            foundBook.setCopiesAvailable(foundBook.getCopiesAvailable() + 1);
            member.removeBorrowings(bookTitle);
        }
        else
            throw new Exception("Book " + foundBook.getTitle() + " unavailable");
    }

}
