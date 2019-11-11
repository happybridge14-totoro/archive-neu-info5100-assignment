package q1.model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import java.text.DecimalFormat;

public class Result {
  private StringProperty displayString;

  private void setValue(double value) {
    String s = null;
    if (value > 999999 || value < -999999) {
      s = String.format("%g", value);
    } else {
      DecimalFormat format = new DecimalFormat("0.######");
      s = format.format(value);
    }
    // value = Double.valueOf(s);
    // this.doubleProperty.setValue(value);
    this.displayString.setValue(s);
  }
  public void setInputValue(String s) {
    this.displayString.setValue(s);
  }
  public StringProperty getStringProperty() {
    return this.displayString;
  }
  public Result() {
     displayString = new SimpleStringProperty("0");
  }
}
