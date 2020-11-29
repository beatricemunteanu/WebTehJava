package com.example.library.model;
import java.util.Optional;
import java.util.UUID;

public class Book {


    private String id;
    private String title;
    private String author;
    private Integer copiesAvailable;
    public Book()
    { }
    public Book(String title,String author,Integer copiesAvailable) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCopiesAvailable(Integer copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Integer getCopiesAvailable() {
        return copiesAvailable;
    }



}
