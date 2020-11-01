package model;

import org.springframework.stereotype.Component;

public class Book {


    private String id;
    private String title;
    private String author;
    private Integer copiesAvailable;
    public Book()
    {
    }
    public Book(String id, String title,String author,Integer copiesAvailable) {
        this.id = id;
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
    public void setCopiesAvailable(Integer copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public Integer getCopiesAvailable() {
        return copiesAvailable;
    }

}
