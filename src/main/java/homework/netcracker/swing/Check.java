package homework.netcracker.swing;

public class Check {
    public static boolean isName(String s) {
        if (s.isEmpty() || s.contains("@") ) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isEmail(String s) {
        if (s != "" && s.contains("@") ) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
