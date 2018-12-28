package library.client.handlers;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import library.shared.FieldVerifier;

public class PublishHandler implements KeyUpHandler {
    private Label errorLabel;
    Checker checker;
    TextBox textPub;

    public PublishHandler(Label errorLabel, Checker checker, TextBox textPub) {
        this.errorLabel = errorLabel;
        this.checker = checker;
        this.textPub = textPub;
    }

    public void onKeyUp(KeyUpEvent event) {
        errorLabel.setText("");
        valid();
    }

    private void valid() {
        checker.setCheck4(true);
        if (!FieldVerifier.intValid(textPub.getText(), 1500, 2018)) {
            errorLabel.setText("Допускаются только цифры в указанном диапазоне. Для отправления заполните всю форму и нажмите кнопку отправки");
            checker.setCheck4(false);
        }
    }
}
