package homework.Netcracker.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class mainSwing {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        List<Book> books = new ArrayList();
//        Book b = new Book("1984", new Author("lol", "q@mail.ru","m"),
//                "fantasy", "eng", 10, 2);
//        Book c = new Book("red", new Author("kek", "q@mail.ru","m"),
//                "horror", "rus", 100, 1);
//
////        b = new Book();
////        c = new Book();
//        books.add(b);
//        books.add(c);
//        storageLibraryDesktop desktop = new storageLibraryDesktop();
//        desktop.saveStorage2(books);
        storageLibraryDesktop desktop = new storageLibraryDesktop();
        System.out.println(desktop.getPath());
    }
}
