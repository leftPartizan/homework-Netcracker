package library.client;

import com.google.gwt.i18n.client.LocalizableResource.Generate;

@Generate(format = "com.google.gwt.i18n.server.PropertyCatalogFactory")
public interface Messages extends com.google.gwt.i18n.client.Messages {

  @DefaultMessage("Удаление записи")
  String delButton();

  @DefaultMessage("Получить список книг")
  String getButton();

  @DefaultMessage("Создать запись")
  String createButton();
}
