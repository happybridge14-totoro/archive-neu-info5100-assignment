package q1.view;

public class NumberButton extends BasicButton {
  private final String NUMBER_CLASS = "number";
  public NumberButton(String label) {
    super(label);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.NUMBER_CLASS);
  }
}
