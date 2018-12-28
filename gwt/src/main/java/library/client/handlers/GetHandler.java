package library.client.handlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import library.client.BookService;
import library.shared.Book;
import library.shared.BookList;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class GetHandler implements ClickHandler {
    private Label errorLabel;
    private List<Book> list;
    private Button delButton;
    private TextBox idDelete;
    private TextBox textAuthor;
    private TextBox textName;
    private TextBox textPages;
    private TextBox textPub;
    private TextBox textDate;
    private Button createButton;
    private ListBox listBox;

    public GetHandler(Label errorLabel, List<Book> list, Button delButton, TextBox idDelete,
                         TextBox textAuthor, TextBox textName, TextBox textPages, TextBox textPub, TextBox textDate
                        , Button createButton, ListBox listBox) {
        this.errorLabel = errorLabel;
        this.list = list;
        this.delButton = delButton;
        this.idDelete = idDelete;
        this.textAuthor = textAuthor;
        this.textName = textName;
        this.textPages = textPages;
        this.textPub = textPub;
        this.textDate = textDate;
        this.createButton = createButton;
        this.listBox = listBox;

    }

    public void onClick(ClickEvent event) {
        BookService service = GWT.create(BookService.class);
        service.call(new MethodCallback<BookList>() {
            @Override
            public void onSuccess(Method method, BookList response) {
                list.clear();
                List<Book> bookList = response.getBookList();
                list.addAll(bookList);
                errorLabel.setText("");

                idDelete.setEnabled(true);
                delButton.setEnabled(true);
                createButton.setEnabled(true);
                textAuthor.setEnabled(true);
                textName.setEnabled(true);
                textPages.setEnabled(true);
                textPub.setEnabled(true);
                textDate.setEnabled(true);
                listBox.setEnabled(true);
            }

            public void onFailure(Method method, Throwable exception) {
                errorLabel.setText("Ошибка получения данных с сервера");
            }
        });
    }
}
