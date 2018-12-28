package library.client.handlers;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import library.shared.FieldVerifier;

public class AuthorHandler implements KeyUpHandler {
    Checker checker;
    Label errorLabel;
    TextBox textAuthor;

    public AuthorHandler(Checker checker, Label errorLabel, TextBox textAuthor) {
        this.checker = checker;
        this.errorLabel = errorLabel;
        this.textAuthor = textAuthor;
    }

    public void onKeyUp(KeyUpEvent event) {
        errorLabel.setText("");
        valid();

    }

    private void valid() {
        checker.setCheck1(true);
        if (!FieldVerifier.authValid(textAuthor.getText())) {
            errorLabel.setText("При вводе имени автора допускаются только буквы. Для отправления заполните всю форму и нажмите кнопку отправки");
            checker.setCheck1(false);
        }
    }
}
