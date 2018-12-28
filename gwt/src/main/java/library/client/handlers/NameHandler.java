package library.client.handlers;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import library.shared.FieldVerifier;

public class NameHandler implements KeyUpHandler {
    private Label errorLabel;
    private Checker checker;
    private TextBox textName;

    public NameHandler(Label errorLabel, Checker checker, TextBox textName) {
        this.errorLabel = errorLabel;
        this.checker = checker;
        this.textName = textName;
    }

    public void onKeyUp(KeyUpEvent event) {
        errorLabel.setText("");
        valid();
    }

    private void valid() {
        checker.setCheck2(true);
        if (!FieldVerifier.nameValid(textName.getText())) {
            errorLabel.setText("Неверный ввод названия. Не допускается пустое поле. Для отправления заполните всю форму и нажмите кнопку отправки");
            checker.setCheck2(false);
        }
    }
}
