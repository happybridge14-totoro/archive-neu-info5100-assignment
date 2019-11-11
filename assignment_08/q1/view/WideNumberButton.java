package q1.view;

public class WideNumberButton extends NumberButton {
  private final String LARGE_CLASS = "large";
  public WideNumberButton(String label) {
    super(label);
  }
  void addClass() {
    super.addClass();
    this.getStyleClass().add(this.LARGE_CLASS);
  }
}
