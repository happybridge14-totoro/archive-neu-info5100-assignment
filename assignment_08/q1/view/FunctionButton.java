package q1.view;

public class FunctionButton extends BasicButton {
  private final String FUNCTION_CLASS = "function";
  public FunctionButton(String label) {
    super(label);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.FUNCTION_CLASS);
  }
}
