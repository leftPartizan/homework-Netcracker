package library.client.handlers;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import library.shared.FieldVerifier;

public class PagesHandler implements KeyUpHandler {
    private Label errorLabel;
    private Checker checker;
    private TextBox textPages;

    public PagesHandler(Label errorLabel, Checker checker, TextBox textPages) {
        this.errorLabel = errorLabel;
        this.checker = checker;
        this.textPages = textPages;
    }

    public void onKeyUp(KeyUpEvent event) {
        errorLabel.setText("");
        valid();
    }

    private void valid() {
        checker.setCheck3(true);
        if (!FieldVerifier.intValid(textPages.getText(), 1, 10000)) {
            errorLabel.setText("Неверный ввод количества страниц. Допускаются только цифры в указанном диапазоне. Для отправления заполните всю форму и нажмите кнопку отправки");
            checker.setCheck3(false);
        }
    }
}
