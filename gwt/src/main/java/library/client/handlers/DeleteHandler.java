package library.client.handlers;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import library.client.DeleteService;
import library.shared.Book;
import library.shared.BookList;
import library.shared.FieldVerifier;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

public class DeleteHandler implements ClickHandler, KeyUpHandler {
    private List<Book> list;
    private Label errorLabel;
    private TextBox idDelete;
    private Button delButton;
    private DeleteService service = GWT.create(DeleteService.class);

    public DeleteHandler(List<Book> list, Label errorLabel, TextBox idDelete, Button delButton) {
        this.list = list;
        this.errorLabel = errorLabel;
        this.idDelete = idDelete;
        this.delButton = delButton;
    }

    public void onClick(ClickEvent event) {
        helper();
    }

    public void onKeyUp(KeyUpEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
            helper();
        }
    }

    private boolean idValid() {

        errorLabel.setText("");
        String id = idDelete.getText();
        if (!FieldVerifier.isValidId(id, list.size())) {
            errorLabel.setText("введённый id в таблице не существет. ");
            return false;
        }
        return true;
    }

    private void helper() {
        if (idValid()) {
            int id = Integer.parseInt(idDelete.getText());
            Book book = new Book();
            book.setId(id);
            service.deleteBook(book, new MethodCallback<BookList>() {
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
                    if (list.size() == 0 || list.size() == 1) {
                        delButton.setEnabled(false);
                        idDelete.setEnabled(false);
                    }
                    idDelete.setText("");
                }
            });
        }
    }
}

