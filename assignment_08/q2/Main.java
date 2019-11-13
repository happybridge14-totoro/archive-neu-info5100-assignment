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
   }
   public static void main(String args[]){
      launch(args);
   }
}
