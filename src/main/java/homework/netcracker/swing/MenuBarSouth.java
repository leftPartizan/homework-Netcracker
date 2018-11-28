package homework.netcracker.swing;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MenuBarSouth extends JMenuBar {
    private JMenu Menu = new JMenu("New");
    private BookModel bookModel;

    private JButton saveChanges = new JButton("Save changes");
    private JMenuItem newBook = new JMenuItem("new Book");
    private JMenuItem delete = new JMenuItem("delete");
    private JMenuItem changeDataBook = new JMenuItem("changeDataBook");

    public JButton getSaveChanges() {
        return saveChanges;
    }

    public JMenuItem getDelete() {
        return delete;
    }

    public MenuBarSouth(JTable table) {
        Menu.add(newBook);
        Menu.add(delete);
        Menu.add(changeDataBook);
        add(Menu);

        bookModel = (BookModel) table.getModel();
        add(new menuView("View", table , bookModel));

        add(saveChanges);
        saveChanges.setEnabled(false);
    }

    public JMenuItem getChangeDataBook() {
        return changeDataBook;
    }

    public JMenuItem getNewBook() {
        return newBook;
    }

    class menuView extends JMenu{
        JMenuItem[] menuItemView;

        public menuView(String s, JTable table, BookModel bookModel) {
            super(s);
            String[] tableNameColumns = bookModel.getFieldsName();
            this.menuItemView = new JMenuItem[tableNameColumns.length];
            for (int i = 0; i < tableNameColumns.length; i++) {
                JMenuItem item = new JMenuItem(tableNameColumns[i]);
                add(item, i);
                menuItemView[i] = item;
                item.setBackground(Color.WHITE);
            }
            addMenuViewListeners(menuItemView, table, bookModel);
        }

    }

    class menuRefactor extends JMenu {
        private JMenuItem deleteItem = new JMenuItem("delete book...");

        public menuRefactor(String s, BookModel bookModel) {
            super(s);
        }

        public void addListeners(BookModel bookModel) {
            deleteItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

    }

    private void addMenuViewListeners(JMenuItem[] menuItemsView, JTable table, BookModel bookModel) {
        for (int index = 0; index < menuItemsView.length; index++) {
            menuItemsView[index].addActionListener(new ActionView(menuItemsView, table, bookModel, index));
        }
    }
    // добавляем к кнопкам реакцию на нажатие
    // кнопки скрывают/показывают соотвествующие колонки таблицы
    class ActionView implements ActionListener {
        private JMenuItem[] menuItemsView;
        private JTable table;
        private BookModel bookModel;
        private int index;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (menuItemsView[index].isSelected()) {
                showColumn(index);
            } else {
                hideColumn(index);
            }

        }

        public ActionView(JMenuItem[] menuItemsView, JTable table, BookModel bookModel, int index) {
            this.menuItemsView = menuItemsView;
            this.table = table;
            this.bookModel = bookModel;
            this.index = index;
            if (menuItemsView[index].getText() == "Gender Author" ||
                    menuItemsView[index].getText() == "Email Author"  ) {
                hideColumn(index);
            }
        }

        private void hideColumn(int index){
            int columnIndex = table.getColumnModel().getColumnIndex(menuItemsView[index].getText());
            TableColumn column = table.getColumnModel().getColumn(columnIndex);
            bookModel.addHiddenColum(menuItemsView[index].getText(), column);
            table.removeColumn(column);
            menuItemsView[index].setSelected(true);
            menuItemsView[index].setBackground(Color.GRAY);
        }

        private void showColumn(int index){
            Object o = bookModel.removeHiddenColum(menuItemsView[index].getText());
            if (o == null) {
                System.out.println("null");
                return;
            }
            table.addColumn((TableColumn) o);
            menuItemsView[index].setSelected(false);
            if (index < table.getColumnCount() - 1) {
                table.getColumnModel().moveColumn(table.getColumnCount() - 1, index);
            }
            menuItemsView[index].setBackground(Color.WHITE);
        }
    }

}
