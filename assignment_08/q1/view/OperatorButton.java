package q1.view;

import q1.types.ButtonType;

public class OperatorButton extends BasicButton {
  private final String OPERATOR_CLASS = "operator";
  public OperatorButton(ButtonType type) {
    super(type);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.OPERATOR_CLASS);
  }
}
