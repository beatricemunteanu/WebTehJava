package repository;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private List<Book> library = new ArrayList<Book>();

    public void addBook(Book book)
    {
        library.add(book);
    }

    public Book findBook(String title)
    {

        for (Book book : library)
        {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase()))
                return book;
        }
        return new Book();
    }
}
