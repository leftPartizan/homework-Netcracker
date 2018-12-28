package library.shared;

import java.util.List;

public class BookList {
    private List<Book> bookList;

    public BookList() {
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "bookList=" + bookList +
                '}';
    }
}

