package q2.view;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;


public class StudentInfoPage extends GridPane {
  private Label idStr;
  private Label nameStr;
  private Label genderStr;
  private TextField idInput;
  private TextField nameInput;
  private ComboBox<String> gender;
  private Label errStr;
  public void displayError() {
    errStr.setText("Error! Please check your input");
    errStr.getStyleClass().clear();
    errStr.getStyleClass().add("error");
  }
  public void displayDuplicatedError() {
    errStr.setText("Error! ID already exists!");
    errStr.getStyleClass().clear();
    errStr.getStyleClass().add("error");
  }

  public void displaySuccess() {
    errStr.setText("Success!");
    errStr.getStyleClass().clear();
    errStr.getStyleClass().add("success");
  }

  public StudentInfoPage(EventHandler<ActionEvent> addEvent, EventHandler<ActionEvent> backEvent) {
    super();
    this.getStyleClass().add("detail");
    Button add = new BasicButton("Add");
    Button back = new BasicButton("Back To Menu");
    add.setOnAction(addEvent);
    back.setOnAction(backEvent);
    this.add(add, 1, 6, 4, 1);
    this.add(back, 1, 7, 4, 1);

    idStr = new Label("ID: ");
    idStr.getStyleClass().add("label");
    nameStr = new Label("Name: ");
    nameStr.getStyleClass().add("label");
    genderStr = new Label("Gender: ");
    genderStr.getStyleClass().add("label");
    idInput = new TextField();
    idInput.getStyleClass().add("input");
    nameInput = new TextField();
    nameInput.getStyleClass().add("input");
    gender = new ComboBox<String>();
    gender.getItems().addAll("Male", "Female", "Other");
    this.add(idStr, 1, 2);
    this.add(idInput, 3, 2);
    this.add(nameStr, 1, 3);
    this.add(nameInput, 3, 3);
    this.add(genderStr, 1, 4);
    this.add(gender, 3, 4);
    errStr = new Label("");
    this.add(errStr, 1, 1, 4, 1);
  }
  public String[] getData() {
    String[] ret = new String[3];
    try {
      String valueText = idInput.getText();
      if (valueText.length() == 0) {
        displayError();
        return null;
      }
      ret[0] = valueText;
      valueText = nameInput.getText();
      if (valueText.length() == 0) {
        displayError();
        return null;
      }
      ret[1] = valueText;
      valueText = gender.getValue();
      if (valueText.length() == 0) {
        displayError();
        return null;
      }
      ret[2] = valueText;
    } catch(Exception e) {
      displayError();
      return null;
    }
    return ret;
  }
}
