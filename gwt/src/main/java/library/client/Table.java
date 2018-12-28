package library.client;

import com.google.gwt.user.cellview.client.*;
import library.shared.Book;

import java.util.Comparator;
import java.util.List;

public class Table {
    private CellTable<Book> table;
    TextColumn<Book> idColumn = new TextColumn<Book>() {
        @Override
        public String getValue(Book book) {
            return "" + book.getId();
        }
    };
    TextColumn<Book> authorColumn = new TextColumn<Book>() {
        @Override
        public String getValue(Book book) {
            return "" + book.getAuthor();
        }
    };
    TextColumn<Book> nameColumn = new TextColumn<Book>() {
        @Override
        public String getValue(Book book) {
            return "" + book.getName();
        }
    };
    TextColumn<Book> pagesColumn = new TextColumn<Book>() {
        @Override
        public String getValue(Book book) {
            return "" + book.getPages();
        }
    };
    TextColumn<Book> yearColumn = new TextColumn<Book>() {
        @Override
        public String getValue(Book book) {
            return "" + book.getYear();
        }
    };
    TextColumn<Book> dateColumn = new TextColumn<Book>() {
        @Override
        public String getValue(Book book) {
            return "" + book.getDate();
        }
    };


    public Table(List<Book> list) {
        table = new CellTable<>(10);

        table.addColumn(idColumn, "id");
        table.addColumn(authorColumn, "Автор");
        table.addColumn(nameColumn, "Название");
        table.addColumn(pagesColumn, "Кол. стр.");
        table.addColumn(yearColumn, "Год изд.");
        table.addColumn(dateColumn, "Дата добав.");



        authorColumn.setSortable(true);
        nameColumn.setSortable(true);
        idColumn.setSortable(true);
        pagesColumn.setSortable(true);
        yearColumn.setSortable(true);
        dateColumn.setSortable(true);

        ColumnSortEvent.ListHandler<Book> columnSortHandler = new ColumnSortEvent.ListHandler<>(
                list);
        columnSortHandler.setComparator(authorColumn,
                new Comparator<Book>() {
                    public int compare(Book o1, Book o2) {
                        if (o1 == o2) {
                            return 0;
                        }

                        // Compare the name columns.
                        if (o1 != null) {
                            return (o2 != null) ? o1.getAuthor().compareTo(o2.getAuthor()) : 1;
                        }
                        return -1;
                    }
                });
        columnSortHandler.setComparator(dateColumn,
                new Comparator<Book>() {
                    public int compare(Book o1, Book o2) {
                        if (o1 == o2) {
                            return 0;
                        }

                        // Compare the name columns.
                        if (o1 != null) {
                            return (o2 != null) ? o1.getDate().compareTo(o2.getDate()) : 1;
                        }
                        return -1;
                    }
                });
        columnSortHandler.setComparator(nameColumn,
                new Comparator<Book>() {
                    public int compare(Book o1, Book o2) {
                        if (o1 == o2) {
                            return 0;
                        }

                        // Compare the name columns.
                        if (o1 != null) {
                            return (o2 != null) ? o1.getName().compareTo(o2.getName()) : 1;
                        }
                        return -1;
                    }
                });
        columnSortHandler.setComparator(idColumn,
                new Comparator<Book>() {
                    public int compare(Book o1, Book o2) {
                        int cmp = o1.getId() > o2.getId() ? + 1 : o1.getId() < o2.getId() ? -1 : 0;
                        return cmp;
                    }
                });
        columnSortHandler.setComparator(pagesColumn,
                new Comparator<Book>() {
                    public int compare(Book o1, Book o2) {
                        int cmp = o1.getPages() > o2.getPages() ? + 1 : o1.getPages() < o2.getPages() ? -1 : 0;
                        return cmp;
                    }
                });
        columnSortHandler.setComparator(yearColumn,
                new Comparator<Book>() {
                    public int compare(Book o1, Book o2) {
                        int cmp = o1.getYear() > o2.getYear() ? + 1 : o1.getYear() < o2.getYear() ? -1 : 0;
                        return cmp;
                    }
                });
        table.addColumnSortHandler(columnSortHandler);
    }

    public CellTable<Book> getTable() {
        return table;
    }


}
