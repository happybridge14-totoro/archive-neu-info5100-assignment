package q1.view;

import q1.types.ButtonType;

public class WideNumberButton extends NumberButton {
  private final String LARGE_CLASS = "large";
  public WideNumberButton(ButtonType type) {
    super(type);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.LARGE_CLASS);
  }
}
