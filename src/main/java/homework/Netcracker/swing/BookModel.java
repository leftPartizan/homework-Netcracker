package homework.Netcracker.swing;

import java.lang.reflect.Field;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class BookModel extends AbstractTableModel {
    private List<Book> books;
    private HashMap hiddenColumns = new HashMap();
    private String[] fieldsName = new String[] {"Name", "Author", "Email Author",
            "Gender Author", "Genre", "Language", "Number of pages", "Count"};

    public String[] getFieldsName() {
        return fieldsName;
    }

    public BookModel() {
        StorageLibraryDesktop storage = new StorageLibraryDesktop();
        books = storage.loadStorage2();
    }

    public void addBook(Book b) {
        this.books.add(b);
        this.fireTableDataChanged();
    }

    public void deleteBook(Book b) {
        books.remove(b);
        this.fireTableDataChanged();
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getRowCount() {
        return this.books.size();
    }

    public int getColumnCount() {
        return Book.class.getDeclaredFields().length - 1 + Author.class.getDeclaredFields().length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur = (Book) this.books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cur.getName();
            case 1:
                return cur.getAuthor().getName();
            case 2:
                return cur.getAuthor().getEmail();
            case 3:
                return cur.getAuthor().getGender();
            case 4:
                return cur.getGenre();
            case 5:
                return cur.getInLanguage();
            case 6:
                return cur.getNumberOfPages();
            case 7:
                return cur.getCount();
            default:
                return null;
        }
    }

    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Name";
            case 1:
                return "Author";
            case 2:
                return "Email Author";
            case 3:
                return "Gender Author";
            case 4:
                return "Genre";
            case 5:
                return "Language";
            case 6:
                return "Number of pages";
            case 7:
                return "Count";
            default:
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return int.class;
            case 7:
                return int.class;
            default:
                return null;
        }
    }

    public void addHiddenColum(Object key, Object value) {
        hiddenColumns.put(key, value);
//        hiddenColumn
    }

    public Object removeHiddenColum(Object o) {
        return hiddenColumns.remove(o);
    }

}
