package q2.model;

import q2.dataproto.ScreenType;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
public class StageData {
  private SimpleIntegerProperty type;

  public StageData() {
     this.type = new SimpleIntegerProperty(ScreenType.DEFAULT);
  }
  public SimpleIntegerProperty getTypeProperty() {
    return this.type;
  }
  public int getTypeValue() {
    return this.type.get();
  }
  public void setValue(int value) {
    this.type.setValue(value);
  }
}
