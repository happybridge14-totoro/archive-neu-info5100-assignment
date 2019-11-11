package q1.controller;

import javafx.scene.control.Label;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class LabelController implements ChangeListener<String> {
  private Label text;
  public LabelController(Label text) {
    super();
    this.text = text;
  }
  @Override
  public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
    if (newValue != null) {
      text.setText(newValue);
    }
  }
}
