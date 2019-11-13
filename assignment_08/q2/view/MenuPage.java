package q2.view;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MenuPage extends GridPane {
  public MenuPage(EventHandler<ActionEvent> addEvent, EventHandler<ActionEvent> browseEvent) {
    super();
    this.getStyleClass().add("menu");
    Button add = new BasicButton("Add Student Data");
    Button browse = new BasicButton("Browse Students");
    add.setOnAction(addEvent);
    browse.setOnAction(browseEvent);
    this.add(add, 1, 1);
    this.add(browse, 1, 2);
  }
}
