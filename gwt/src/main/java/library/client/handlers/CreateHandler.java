package library.client.handlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import library.client.CreateService;
import library.shared.Book;
import library.shared.BookList;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class CreateHandler implements ClickHandler {

    private Label errorLabel;
    private Checker checker;
    private List<Book> list;
    private Button delButton;
    private TextBox idDelete;
    private TextBox textAuthor;
    private TextBox textName;
    private TextBox textPages;
    private TextBox textPub;
    private TextBox textDate;

    public CreateHandler(Label errorLabel, Checker checker, List<Book> list, Button delButton, TextBox idDelete,
                         TextBox textAuthor, TextBox textName, TextBox textPages, TextBox textPub, TextBox textDate) {
        this.errorLabel = errorLabel;
        this.checker = checker;
        this.list = list;
        this.delButton = delButton;
        this.idDelete = idDelete;
        this.textAuthor = textAuthor;
        this.textName = textName;
        this.textPages = textPages;
        this.textPub = textPub;
        this.textDate = textDate;
    }

    @Override
    public void onClick(ClickEvent event) {
        CreateService service = GWT.create(CreateService.class);
        if (checker.isCheck1() && checker.isCheck2() && checker.isCheck3() && checker.isCheck4() && checker.isCheck5()) {
            Book book = new Book();
            book.setAuthor(textAuthor.getText());
            book.setName(textName.getText());
            book.setPages(Integer.parseInt(textPages.getText()));
            book.setYear(Integer.parseInt(textPub.getText()));
            book.setDate(textDate.getText());
            service.createBook(book, new MethodCallback<BookList>() {
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
                    if (list.size() > 1) {
                        delButton.setEnabled(true);
                        idDelete.setEnabled(true);

                    }
                    textAuthor.setText("");
                    textName.setText("");
                    textPages.setText("");
                    textPub.setText("");
                    textDate.setText("");
                }
            });
        } else errorLabel.setText("Незаполены, либо неверно заполнены поля");
    }
}
