package service;
import aspects.ErrorBook;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import javax.swing.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(String id, String title, String author,Integer copies)
    {
        Book newBook = new Book(id,title,author,copies);

        bookRepository.addBook(newBook);
    }
    @ErrorBook
    public void borrowBook(String title) throws Exception
    {

        Book foundbook = bookRepository.findBook(title);
        System.out.println(foundbook.getId());
        if (foundbook.getId() == null)
            throw new Exception("Book " + title + " unavailable");
        else if(foundbook.getCopiesAvailable() > 0) {
            System.out.println("Book " + foundbook.getTitle() + " borrowed");
            foundbook.setCopiesAvailable(foundbook.getCopiesAvailable() - 1);
        }
        else
            throw new Exception("Book " + foundbook.getTitle() + " unavailable");

    }

    public void returnBook(String title)
    {
        Book foundbook = bookRepository.findBook(title);
        if (foundbook == null)
            System.out.println("Book " + foundbook.getTitle() + " not found");

        else
            System.out.println("Book " + foundbook.getTitle() + " returned");
            foundbook.setCopiesAvailable(foundbook.getCopiesAvailable() + 1);

    }
}
