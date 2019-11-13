package q2.view;

import javafx.scene.control.Button;

public class BasicButton extends Button{
  private final String BUTTON_CLASS = "btn";
  public BasicButton(String label) {
    super(label);
    this.getStyleClass().add(this.BUTTON_CLASS);
  }
}
