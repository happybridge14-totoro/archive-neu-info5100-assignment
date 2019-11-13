package q2.view;

import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class MenuPage extends GridPane {
  public MenuPage() {
    this.getStyleClass().add("menu");
    Button b1 = new BasicButton("Add Student Data");
    Button b2 = new BasicButton("Browse Students");
    this.add(b1, 1, 1);
    this.add(b2, 1, 2);
  }
}
