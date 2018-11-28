package homework.netcracker.swing;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopupMenuTable extends JPopupMenu {

    JMenuItem deleteItemBook;
    JTable table;

    public PopupMenuTable(JTable table) {
        this.table = table;
        deleteItemBook = new JMenuItem("delete selected book");
        add(deleteItemBook);
    }

    public void addListenersPopupMenu(JButton button) {
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    JTable source = (JTable)e.getSource();
                    int row = source.rowAtPoint( e.getPoint() );
                    int column = source.columnAtPoint( e.getPoint() );

                    if (! source.isRowSelected(row))
                        source.changeSelection(row, column, false, false);
                }

            }
        });

        deleteItemBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                BookModel bookModel = (BookModel) table.getModel();
                bookModel.deleteBook(row);
                button.setEnabled(true);
            }
        });
    }
}
