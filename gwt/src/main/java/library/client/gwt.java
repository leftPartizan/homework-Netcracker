package library.client;

import library.client.handlers.*;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import library.shared.Book;
import library.shared.BookList;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;
import java.util.List;

public class gwt implements EntryPoint {

  private final Messages messages = GWT.create(Messages.class);
  private ListDataProvider<Book> dataProvider = new ListDataProvider<>();
  private List<Book> list = dataProvider.getList();

  public void onModuleLoad() {
      String root = Defaults.getServiceRoot();
      root = root.replace("gwt/", "");
      Defaults.setServiceRoot(root);

      //создание элементов
      final Button getButton = new Button(messages.getButton());
      final Button delButton = new Button(messages.delButton());
      final Button createButton = new Button(messages.createButton());
      final TextBox textAuthor = new TextBox();
      final TextBox textName = new TextBox();
      final TextBox textPages = new TextBox();
      final TextBox textPub = new TextBox();
      final TextBox textDate = new TextBox();
      final Label errorLabel = new Label("");
      final Label idLabel = new Label("id удаляемой записи: ");
      final ListBox listBox = new ListBox();
      final TextBox idDelete = new TextBox();
      final Label mark1 = new Label("Введите автора(только буквы)");
      final Label mark2 = new Label("Введите название книги");
      final Label mark3 = new Label("Введите кол. страниц (цифры 1-10000)");
      final Label mark4 = new Label("Введите дату публикации (цифры 1500-2018)");
      final Label mark5 = new Label("Введите дату внесения в базу (дд-мм-гггг)");

      textAuthor.setEnabled(false);
      textName.setEnabled(false);
      textPages.setEnabled(false);
      textPub.setEnabled(false);
      textDate.setEnabled(false);
      createButton.setEnabled(false);
      delButton.setEnabled(false);
      idDelete.setEnabled(false);

      idDelete.setMaxLength(5);

      listBox.addItem("id");
      listBox.addItem("Автор");
      listBox.addItem("Название");
      listBox.addItem("Кол. стр.");
      listBox.addItem("Год изд.");

      listBox.setItemSelected(0, true);
      listBox.setEnabled(false);
      //таблица
      CellTable<Book> table = new Table(list).getTable();
      //Ввыод таблицы на экран
      dataProvider.addDataDisplay(table);
      SimplePager pager = new SimplePager();
      pager.setPageSize(10);
      pager.setPageStart(0);
      pager.setDisplay(table);
      //Добавление элементов на страницу

      VerticalPanel panelSort = new VerticalPanel();
      VerticalPanel panelNewBook = new VerticalPanel();
      TabPanel tabLayoutPanel = new TabPanel();

      panelSort.add(new Label("Сортировака по:"));
      panelSort.add(listBox);
      panelSort.add(idLabel);
      panelSort.add(idDelete);
      panelSort.add(delButton);

      panelNewBook.add(mark1);
      panelNewBook.add(textAuthor);
      panelNewBook.add(mark2);
      panelNewBook.add(textName);
      panelNewBook.add(mark3);
      panelNewBook.add(textPages);
      panelNewBook.add(mark4);
      panelNewBook.add(textPub);
      panelNewBook.add(mark5);
      panelNewBook.add(textDate);
      panelNewBook.add(createButton);

      tabLayoutPanel.add(panelSort, "Сортировка по столбцу");
      tabLayoutPanel.add(panelNewBook, "Новая запись");

      RootPanel.get("block-left").add(table);
      RootPanel.get("block-left").add(pager);
      RootPanel.get("block-left").add(getButton);
      RootPanel.get("block-right").add(tabLayoutPanel);
      RootPanel.get("block-right").add(errorLabel);


      GetHandler getHandler = new GetHandler(errorLabel, list, delButton, idDelete,
              textAuthor, textName, textPages, textPub, textDate, createButton, listBox);
      getButton.addClickHandler(getHandler);

      DeleteHandler deleteHandler = new DeleteHandler(list, errorLabel, idDelete, delButton);
      delButton.addClickHandler(deleteHandler);
      idDelete.addKeyUpHandler(deleteHandler);

      Checker checker = new Checker();
      textAuthor.addKeyUpHandler(new AuthorHandler(checker, errorLabel, textAuthor));
      textName.addKeyUpHandler(new NameHandler(errorLabel, checker, textName));
      textPages.addKeyUpHandler(new PagesHandler(errorLabel, checker, textPages));
      textPub.addKeyUpHandler(new PublishHandler(errorLabel, checker, textPub));
      textDate.addKeyUpHandler(new DateHandler(errorLabel, checker, textDate));
      createButton.addClickHandler(new CreateHandler(errorLabel, checker, list, delButton, idDelete,
              textAuthor, textName, textPages, textPub, textDate));
      listBox.addChangeHandler(new SortHandler(errorLabel,list,listBox));

  }
}
