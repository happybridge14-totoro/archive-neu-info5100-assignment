package q1;

import q1.model.*;
import q1.controller.*;
import q1.view.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;

public class Main extends Application {
   @Override
   public void start(Stage stage) {
      //creating label email
      Label text1 = new Label("0");
      //Creating a Grid Pane
      GridPane gridPane = new GridPane();
      // final String BUTTON_CLASS = "btn";
      // final String BUTTON_NUMBER_CLASS = "number";
      // final int NUMBER_BUTTON_COUNT = 11;
      // Button[] numButtons = new Button[NUMBER_BUTTON_COUNT];
      final String[] NUMBER_BUTTON_TEXT = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
      final int[] NUMBER_BUTTON_POS_X = new int[]{0, 0, 1, 2, 0, 1, 2, 0, 1, 2, 2};
      final int[] NUMBER_BUTTON_POS_Y = new int[]{6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 6};
      for (int i = 0; i < NUMBER_BUTTON_TEXT.length; i++) {
          Button numberButtton = null;
          if (i == 0) {
              numberButtton = new WideNumberButton(NUMBER_BUTTON_TEXT[i]);
              gridPane.add(numberButtton, NUMBER_BUTTON_POS_X[i], NUMBER_BUTTON_POS_Y[i], 2, 1);
          } else {
              numberButtton = new NumberButton(NUMBER_BUTTON_TEXT[i]);
              gridPane.add(numberButtton, NUMBER_BUTTON_POS_X[i], NUMBER_BUTTON_POS_Y[i]);
          }
      }
      final String[] OPERATOR_BUTTON_TEXT = new String[]{"÷", "×", "-", "+", "="};
      final int OPERATOR_BUTTON_POS_X = 4;
      final int[] OPERATOR_BUTTON_POS_Y = new int[]{2, 3, 4, 5, 6};
      final int OPERATOR_BUTTON_COUNT = 5;
      final String BUTTON_OPERATOR_CLASS = "operator";
      for (int i = 0; i < OPERATOR_BUTTON_TEXT.length; i++) {
          Button operatorButtton = new OperatorButton(OPERATOR_BUTTON_TEXT[i]);
          gridPane.add(operatorButtton, OPERATOR_BUTTON_POS_X, OPERATOR_BUTTON_POS_Y[i]);
      }
      final String[] FUNCTION_BUTTON_TEXT = new String[]{"AC", "+/-", "%"};
      final int[] FUNCTION_BUTTON_POS_X = new int[]{0, 1, 2};
      final int FUNCTION_BUTTON_POS_Y = 2;
      for (int i = 0; i < FUNCTION_BUTTON_TEXT.length; i++) {
          Button functionButtton = new FunctionButton(FUNCTION_BUTTON_TEXT[i]);
          gridPane.add(functionButtton, FUNCTION_BUTTON_POS_X[i], FUNCTION_BUTTON_POS_Y);
      }
      //Arranging all the nodes in the grid
      gridPane.add(text1, 0, 0, 5, 1);
      text1.getStyleClass().add("display");

      Result result = new Result();
      result.getStringProperty().addListener(new LabelController(text1));

      gridPane.getStyleClass().add("panel");

      // Creating a scene object
      Scene scene = new Scene(gridPane);
      String urlString = "q1/css/test.css";
      try {
        urlString = getClass().getResource("css/test.css").toExternalForm();
      } catch(Exception e) {
        System.out.println(e);
      }
      // scene.getStylesheets().add(getClass().getResource("q1/css/test.css").toExternalForm());
      scene.getStylesheets().add(urlString);

      // Setting title to the Stage
      final String TITLE = "Calculator1";
      stage.setTitle(TITLE);

      // Adding scene to the stage
      stage.setScene(scene);

      //Displaying the contents of the stage
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
