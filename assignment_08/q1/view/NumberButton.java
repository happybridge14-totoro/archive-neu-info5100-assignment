package q1.view;

import q1.types.ButtonType;

public class NumberButton extends BasicButton {
  private final String NUMBER_CLASS = "number";
  public NumberButton(ButtonType type) {
    super(type);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.NUMBER_CLASS);
  }
}
