package library.shared;

public class FieldVerifier {

  public static boolean isValidId(String id, int size) {
    if (id.equals("")) {
      return false;
    }
    try {
      int temp = Integer.parseInt(id);
      return (temp < size && temp >= 0);
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean authValid(String auth) {
    if (auth.equals("")) {
      return false;
    }
    char[] temp = auth.toCharArray();
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] != ' ' && (temp[i] > 'Z' || temp[i] < 'A') &&
              (temp[i] > 'z' || temp[i] < 'a') &&
              (temp[i] > 'я' || temp[i] < 'А')) {
        return false;
      }
    }
    return true;
  }

  public static boolean nameValid(String name) {
    if (name.equals("")) {
      return false;
    } else return true;
  }

  public static boolean intValid(String pages, int start, int stop) {
    if (pages.equals("")) {
      return false;
    }
    int temp;
    try {
      temp = Integer.parseInt(pages);
      return (temp >= start && temp <= stop);
    } catch (NumberFormatException exc) {
      return false;
    }
  }

  public static boolean dateValid(String date) {
    if (date.equals("")) {
      return false;
    }
    char[] temp = date.toCharArray();
    if (temp.length != 10) {
      return false;
    }
    String day = "" + temp[0] + temp[1];
    String month = "" + temp[3] + temp[4];
    String year = "" + temp[6] + temp[7] + temp[8] + temp[9];
    if (temp[2] != '-' || temp[5] != '-') {
      return false;
    }
    int iDay, iMonth, iYear;
    try {
      iDay = Integer.parseInt(day);
      iMonth = Integer.parseInt(month);
      iYear = Integer.parseInt(year);
      return ((iDay >= 1 && iDay <= 31 && iMonth == 1 && iYear == 2018) ||
              (iDay >= 1 && iDay <= 31 && iMonth >= 1 && iMonth <= 12 && iYear == 2018) ||
              (iDay >= 1 && iDay <= 31 && iMonth >= 1 && iMonth <= 12 && iYear >= 1 && iYear <= 2017));
    } catch (NumberFormatException exc) {
      return false;
    }
  }

}
