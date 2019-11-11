package q1.view;

import javafx.scene.control.Button;

public class BasicButton extends Button{
  private final String BUTTON_CLASS = "btn";
  public BasicButton(String label) {
    super(label);
    this.addClass();
  }
  void addClass() {
    this.getStyleClass().add(this.BUTTON_CLASS);
  }
}
