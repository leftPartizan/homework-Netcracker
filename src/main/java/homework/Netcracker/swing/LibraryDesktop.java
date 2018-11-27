package homework.Netcracker.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;


public class LibraryDesktop extends JFrame {

    Book bookNew = new Book("name", new Author("name", "1@mail.ru", "m"),
            "a", "rus", 100, 1);


    private DialogBook dialog;
    private BookModel bookModel;
    private JTable table ;
    private MenuBarSouth bar;
    private InputNameBookDialog deleteBookDialog;
    private InputNameBookDialog changBookDialog;

    public LibraryDesktop() {
        super("library");
        this.setSize(450, 250);
        this.setLocation(250, 100);

        bookModel = new BookModel();
        table = new JTable(bookModel);
        dialog = new DialogBook(this);
        bar = new MenuBarSouth(table);
        deleteBookDialog = new InputNameBookDialog();
        changBookDialog = new InputNameBookDialog();
        addAllListeners();

        add(bar, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(3);
        JScrollPane jScrollPane = new JScrollPane(table);
        this.add(jScrollPane);
        this.setVisible(true);
    }

    private void addAllListeners(){
//        dialog.getPanelSouth().getButtonOk().addActionListener(this::buttonOKTest); // добавить книгу
        dialog.getPanelSouth().getButtonOk().addActionListener(this::buttonOK);
        deleteBookDialog.getPanelSouth().getButtonOk().addActionListener(this::deleteBookPressOk);
        changBookDialog.getPanelSouth().getButtonOk().addActionListener(this::changeDataBook);
        setdefultStateFieldsDialog(); // при наводке на поле - сброс цвета на белое
        bar.getNewBook().addActionListener(this::setVisibleDialog); // окно для ввода новой книги
        bar.getSaveChanges().addActionListener(this::saveToStorageTable); // save to disk
        bar.getDelete().addActionListener(this::deleteBookOpenWindow);
        bar.getChangeDataBook().addActionListener(this::changeBookOpenWindow);

    }

    public BookModel getBookModel() {
        return bookModel;
    }

    private void buttonOKTest(ActionEvent e) {
        JButton trigger = dialog.getPanelCenter().getTriggerNewBook();
        trigger.setSelected(!trigger.isSelected());
        getBookModel().addBook(dialog.getPanelCenter().bookNew2);
        bar.getSaveChanges().setEnabled(true);
        dialog.dispose();
    }

    private void setVisibleDialog(ActionEvent e) {
        dialog.setVisible(true);
    }

    private void saveToStorageTable(ActionEvent e) {
        StorageLibraryDesktop storage = new StorageLibraryDesktop();
        storage.saveStorage2(bookModel.getBooks());
        bar.getSaveChanges().setEnabled(false);
    }

    private void buttonOK(ActionEvent e) {

        DialogBook.PanelCenter panelCenter = dialog.getPanelCenter();
        String nameBook = panelCenter.getFieldName().getText();
        String genre = panelCenter.getFieldGenre().getText();
        String language = panelCenter.getComboBoxLanguage().getSelectedItem().toString();
        String numberOfpages = panelCenter.getFieldNumberOfPages().getText();
        String count = panelCenter.getFieldCount().getText();

        String nameAuthor = panelCenter.getFieldAuthorName().getText();
        String emailAuthor = panelCenter.getFieldAuthorEmail().getText();
        String genderAuthor = panelCenter.getGroupGender().getSelection().getActionCommand();
        ArrayList<JTextField> fieldsArray = panelCenter.fieldsArray(new ArrayList<>());

//        проверка на пустое поле
        boolean testDone = true;
        for (JTextField x : fieldsArray) {
            if (x.getText().isEmpty()) {
                x.setBackground(Color.RED);
                x.setToolTipText("field is Empty");
                testDone = false;
            }
        };
//         проверка на корректность данных
        boolean testDone2 = panelCenter.checkIncorrectData(nameBook, genre, numberOfpages, count, nameAuthor, emailAuthor);
        if (testDone && testDone2) {
            dialog.getPanelCenter().getTriggerNewBook().setSelected(true);
            bookModel.addBook(new Book(nameAuthor, new Author(nameAuthor, emailAuthor, genderAuthor),
                    genre, language, Integer.valueOf(numberOfpages), Integer.valueOf(count)));
            dialog.dispose();
            bar.getSaveChanges().setEnabled(true);
        }
    }

    private void setdefultStateFieldsDialog() {
        ArrayList<JTextField> fieldArray = dialog.getPanelCenter().fieldsArray(new ArrayList<>());
        for (JTextField x : fieldArray) {
            x.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    x.setBackground(Color.WHITE);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    x.setToolTipText("");
                }
            });
        }
    }

    private void deleteBookOpenWindow(ActionEvent e) {
        deleteBookDialog.setVisible(true);
    }

    private void changeBookOpenWindow(ActionEvent e) {
        changBookDialog.setVisible(true);
    }

    private void deleteBookPressOk(ActionEvent e) {
        String text = deleteBookDialog.getPanelCenter().getTextField().getText();
        JLabel warnings = deleteBookDialog.getPanelCenter().getWarnings();
        List<Book> books = bookModel.getBooks();
        if (text.isEmpty()) {
            warnings.setText("field is empty!");
        }
        else {
            Book bookFound = new Book();
            for (Book book: books){
                if (book.getName().equals(text)) {
                    bookFound = book;
                }
            }
            if (books.contains(bookFound)) {
                bookModel.deleteBook(bookFound);
                deleteBookDialog.dispose();
                bar.getSaveChanges().setEnabled(true);
            }
            else {
                warnings.setText("not found");
            }
        }
    }

    private void changeDataBook(ActionEvent e) {
        String text = changBookDialog.getPanelCenter().getTextField().getText();
        JLabel warnings = changBookDialog.getPanelCenter().getWarnings();
        List<Book> books = bookModel.getBooks();

        if (text.isEmpty()) {
            warnings.setText("field is empty!");
        }
        else {
            int bookFoundIndex = -1;
            for (int i=0; i < books.size(); ++i){
                if (books.get(i).getName().equals(text)) {
                    bookFoundIndex = i;
                }
            }
            if (bookFoundIndex != -1) {
                String[] bookData = new String[bookModel.getColumnCount()];
                for (int i=0; i < bookModel.getColumnCount(); i++){
                    bookData[i] = String.valueOf(bookModel.getValueAt(bookFoundIndex, i));
                }
                dialog.getPanelCenter().setPanelCenterFields(bookData);
                books.remove(bookFoundIndex);
                changBookDialog.dispose();
                dialog.setVisible(true);
                bar.getSaveChanges().setEnabled(true);
            }
            else {
                warnings.setText("not found");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryDesktop();
            }
        });
    }

}
