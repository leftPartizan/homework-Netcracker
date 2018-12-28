package library.client.handlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import library.client.SortService;
import library.shared.Book;
import library.shared.BookList;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class SortHandler implements ChangeHandler {
    Label errorLabel;
    List<Book> list;
    ListBox listBox;

    public SortHandler(Label errorLabel, List<Book> list, ListBox listBox) {
        this.errorLabel = errorLabel;
        this.list = list;
        this.listBox = listBox;
    }

    @Override
    public void onChange(ChangeEvent event) {
        Book book = new Book();
        book.setId(listBox.getSelectedIndex());
        SortService service = GWT.create(SortService.class);
        service.sortBook(book, new MethodCallback<BookList>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                errorLabel.setText("Ошибка при работе сервера");
            }

            @Override
            public void onSuccess(Method method, BookList response) {
                errorLabel.setText("");
                list.clear();
                List<Book> bookList = response.getBookList();
                list.addAll(bookList);
            }
        });
    }
}

