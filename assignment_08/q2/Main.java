package q2;

import q2.model.*;
import q2.controller.*;
import q2.view.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
   @Override
   public void start(Stage stage) {
      StageData stgData = new StageData();
      StudentData studentData = new StudentData();
      stgData.getTypeProperty().addListener(new StageController(stage, stgData, studentData));
      //Creating a Grid Pane
      // GridPane gridPane = new GridPane();
      // Result result = new Result();
      // ButtonController btnController = new ButtonController(result);
      // //Creating buttons
      // Label text1 = new Label("0");
      // gridPane.add(text1, 0, 0, 5, 1);
      // text1.getStyleClass().add("display");
      //
      // //bind model to controller
      // result.getStringProperty().addListener(new LabelController(text1));
      //
      // gridPane.getStyleClass().add("panel");
      // // Creating a scene object
      // Scene scene = new Scene(gridPane);
      // String urlString = "q2/css/style.css";
      // try {
      //   urlString = getClass().getResource("css/style.css").toExternalForm();
      // } catch(Exception e) {
      //   System.out.println(e);
      // }
      // scene.getStylesheets().add(urlString);
      // // Setting title to the Stage
      // final String TITLE = "Calculator";
      // stage.setTitle(TITLE);
      // // Adding scene to the stage
      // stage.setScene(scene);
      // //Displaying the contents of the stage
      // stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
