package q1.view;

import q1.types.ButtonType;
import javafx.scene.control.Button;

public class BasicButton extends Button{
  private final String BUTTON_CLASS = "btn";
  private final ButtonType type;
  public BasicButton(ButtonType type) {
    super(type.toString());
    this.type = type;
    this.addClass();
  }
  void addClass() {
    this.getStyleClass().add(this.BUTTON_CLASS);
  }
  public ButtonType getType() {
    return this.type;
  }
}
