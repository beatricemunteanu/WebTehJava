package com.example.library.model;

import java.util.UUID;

public class Borrowing {
    private String id;
    private Member member;

    private Book book;

    public Borrowing(Member member, Book book) {
        this.id = UUID.randomUUID().toString();
        this.member = member;
        this.book = book;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getId() {
        return id;
    }

    public String getMember() {
        return member.getUsername();
    }

    public String getBookTitle(){
        return book.getTitle();
    }

}
