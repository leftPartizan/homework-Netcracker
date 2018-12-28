package library.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gwt.core.client.GWT;
import library.shared.BookList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


@Path("book")
public class BookServiceImpl {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public BookList greetServer() throws IllegalArgumentException {
        BookList bookList = null;
        ObjectMapper mapper = new ObjectMapper();

//        URL url = Thread.currentThread().getContextClassLoader().getResource("books.json");
//        URL url = GWT.getModuleBaseForStaticFiles();
        try {
//            bookList = mapper.readValue(new FileInputStream(url.getPath()), BookList.class);
            InputStream s = BookServiceImpl.class.getResourceAsStream("book.json");
            String s2 = "a";
            bookList = mapper.readValue(s, BookList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }
}