package library.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import library.shared.Book;
import library.shared.BookList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;

@Path("delete")
public class DeleteServiceImpl {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BookList greetServer(Book book) throws IllegalArgumentException {
        BookList bookList;
        ObjectMapper mapper = new ObjectMapper();
        String filename = Thread.currentThread().getContextClassLoader().getResource("books.json").getPath();

        try {
            bookList = mapper.readValue(new FileInputStream(filename), BookList.class);
        } catch (IOException e) {
            return null;
        }
        try {
            for (int i = 0; i < bookList.getBookList().size(); i++) {
                if (bookList.getBookList().get(i).getId() == book.getId()) {
                    bookList.getBookList().remove(i);
                }
                if (book.getId() != (bookList.getBookList().size())) {
                    bookList.getBookList().get(i).setId(i);
                }

            }
            mapper.writeValue(new FileOutputStream(filename), bookList);
            return bookList;
        } catch (NullPointerException | IOException e) {
            return null;
        }
    }
}

