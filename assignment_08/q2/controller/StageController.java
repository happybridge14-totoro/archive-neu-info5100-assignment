package q2.controller;

import q2.dataproto.ScreenType;
import q2.model.StageData;
import q2.view.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class StageController implements ChangeListener<Number> {
  private Stage stage;
  private StageData data;
  private final String MENU = "Menu";
  private final String LIST = "List";
  private final String DETAIL = "Detail";
  private void refresh() {
    stage.close();
    GridPane gridPane = null;
    switch (this.data.getTypeValue()) {
      case ScreenType.MENU:
        stage.setTitle(MENU);
        gridPane = new MenuPage();
        break;
      case ScreenType.DETAIL:
        break;
      case ScreenType.LIST:
        break;
      default:
        break;
    }
    Scene scene = new Scene(gridPane);
    String urlString = "q2/css/style.css";
    try {
      urlString = getClass().getResource("../css/style.css").toExternalForm();
    } catch(Exception e) {
      System.out.println(e);
    }
    scene.getStylesheets().add(urlString);
    // Adding scene to the stage
    stage.setResizable(false);
    stage.setScene(scene);
    //Displaying the contents of the stage
    stage.show();
  }
  public StageController(Stage stage, StageData data) {
    super();
    this.stage = stage;
    this.data = data;
    this.refresh();
  }
  @Override
  public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
    if (newValue != null && newValue != oldValue) {
      this.refresh();
    }
  }
}
