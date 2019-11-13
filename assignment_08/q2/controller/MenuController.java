package q2.controller;

import q2.view.MenuPage;
import q2.model.StageData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import q2.dataproto.ScreenType;


public class MenuController {
  private MenuPage page;
  private StageData data;

  public MenuController(StageData data) {
    this.data = data;
    EventHandler<ActionEvent> addEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            data.setValue(ScreenType.DETAIL);
        }
    };
    EventHandler<ActionEvent> browseEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            data.setValue(ScreenType.LIST);
        }
    };
    this.page = new MenuPage(addEvent, browseEvent);
  }
  public MenuPage getView() {
    return this.page;
  }
}
