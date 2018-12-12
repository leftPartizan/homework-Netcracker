import java.util.regex.Pattern;
public class PasswordValidator {
    private final String CORRECT_PASSWORD = "^(?=.*?[A-Z])(?=.*?[0-9]).{8,}$";

    public boolean isValidPassword(String password) {
        return Pattern.matches(CORRECT_PASSWORD, password);
    }

}
