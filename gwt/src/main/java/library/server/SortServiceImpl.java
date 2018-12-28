package library.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import library.shared.Book;
import library.shared.BookList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

@Path("sort")
public class SortServiceImpl {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BookList greetServer(Book book) throws IllegalArgumentException {
        BookList bookList = null;
        ObjectMapper mapper = new ObjectMapper();
        String filename = Thread.currentThread().getContextClassLoader().getResource("books.json").getPath();
        try {
            bookList = mapper.readValue(new FileInputStream(filename), BookList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (book.getId()) {
            case 0:
                Collections.sort(bookList.getBookList(), new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getId() - o2.getId();
                    }
                });
                break;
            case 1:
                Collections.sort(bookList.getBookList(), new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getAuthor().compareTo(o2.getAuthor());
                    }
                });
                break;
            case 2:
                Collections.sort(bookList.getBookList(), new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;
            case 3:
                Collections.sort(bookList.getBookList(), new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getPages() - o2.getPages();
                    }
                });
                break;
            case 4:
                Collections.sort(bookList.getBookList(), new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getYear() - o2.getYear();
                    }
                });
                break;
        }

        return bookList;
    }
}