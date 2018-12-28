package library.client.handlers;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import library.shared.FieldVerifier;

public class DateHandler implements KeyUpHandler {
    private Label errorLabel;
    private Checker checker;
    private TextBox textDate;

    public DateHandler(Label errorLabel, Checker checker, TextBox textDte) {
        this.errorLabel = errorLabel;
        this.checker = checker;
        this.textDate = textDate;
    }

    public void onKeyUp(KeyUpEvent event) {
        errorLabel.setText("");
        valid();
    }

    private void valid() {
        checker.setCheck5(true);
        if (!FieldVerifier.dateValid(textDate.getText())) {
            errorLabel.setText("Неверный ввод даты. Для отправления заполните всю форму и нажмите кнопку отправки");
            checker.setCheck5(false);
        }
    }
}
