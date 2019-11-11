package q1.view;

public class OperatorButton extends BasicButton {
  private final String OPERATOR_CLASS = "operator";
  public OperatorButton(String label) {
    super(label);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.OPERATOR_CLASS);
  }
}
