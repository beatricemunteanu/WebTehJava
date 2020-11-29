package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {
    private String id;
    private String firstName;
    private String lastName;
    private String username;

    private List<Borrowing> borrowings;
    public Member(){}

    public Member(String firstName, String lastName, String username) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.borrowings = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getBorrowedBooks() {
        List<String> borrowedBooks = new ArrayList<>();
        borrowings.forEach(borrowedBook -> borrowedBooks.add(borrowedBook.getBookTitle()));

        return borrowedBooks;
    }

    public void addBorrowings(Borrowing borrowing) {
        borrowings.add(borrowing);
    }

    public void removeBorrowings(String title) {
        borrowings.removeIf(book ->book.getBookTitle().equals(title));
    }

}
