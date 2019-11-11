package q1.view;

import q1.types.ButtonType;

public class FunctionButton extends BasicButton {
  private final String FUNCTION_CLASS = "function";
  public FunctionButton(ButtonType type) {
    super(type);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.FUNCTION_CLASS);
  }
}
