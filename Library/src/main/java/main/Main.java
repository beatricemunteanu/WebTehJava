package main;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.BookService;

import java.util.logging.Handler;

public class Main {
    public static void main(String[] args) throws Exception{
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        BookService service = context.getBean(BookService.class);
        service.addBook("A1234", "Portretul lui Dorian Gray", "Oscar Wilde", 3);
        service.addBook("A1254", "Enigma Otiliei", "George Calinescu", 1);

        service.borrowBook("Portretul lui Dorian Gray");
        //service.borrowBook("x");
        service.returnBook("Portretul lui Dorian Gray");

    }
}
