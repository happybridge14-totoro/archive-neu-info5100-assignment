package q1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
   private void createButtons(Button[] retAry, int count, String[] textAry, int[] posXAry, int[] posYAry) {

   }
   @Override
   public void start(Stage stage) {
      //creating label email
      Label text1 = new Label("0");
      //Creating a Grid Pane
      GridPane gridPane = new GridPane();
      final int NUMBER_BUTTON_COUNT = 11;
      Button[] numButtons = new Button[NUMBER_BUTTON_COUNT];
      final String[] NUMBER_BUTTON_TEXT = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "."};
      final int[] NUMBER_BUTTON_POS_X = new int[]{0, 0, 1, 2, 0, 1, 2, 0, 1, 2, 2};
      final int[] NUMBER_BUTTON_POS_Y = new int[]{6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 6};
      for (int i = 0; i < NUMBER_BUTTON_COUNT; i++) {
          Button numberButtton = new Button(NUMBER_BUTTON_TEXT[i]);
          numberButtton.getStyleClass().add("btn");
          numberButtton.getStyleClass().add("number");
          if (i == 0) {
              numberButtton.getStyleClass().add("large");
              gridPane.add(numberButtton, NUMBER_BUTTON_POS_X[i], NUMBER_BUTTON_POS_Y[i], 2, 1);
          } else {
              gridPane.add(numberButtton, NUMBER_BUTTON_POS_X[i], NUMBER_BUTTON_POS_Y[i]);
          }
          numButtons[i] = numberButtton;
      }

      Button operatorButton0 = new Button("÷");
      Button operatorButton1 = new Button("×");
      Button operatorButton2 = new Button("-");
      Button operatorButton3 = new Button("+");
      Button operatorButton4 = new Button("=");

      Button functionButton0 = new Button("AC");
      Button functionButton1 = new Button("+/-");
      Button functionButton2 = new Button("%");


      //Arranging all the nodes in the grid

      gridPane.add(operatorButton0, 4, 2);
      gridPane.add(operatorButton1, 4, 3);
      gridPane.add(operatorButton2, 4, 4);
      gridPane.add(operatorButton3, 4, 5);
      gridPane.add(operatorButton4, 4, 6);

      gridPane.add(functionButton0, 0, 2);
      gridPane.add(functionButton1, 1, 2);
      gridPane.add(functionButton2, 2, 2);

      gridPane.add(text1, 0, 0, 5, 1);

      //Styling nodes

      operatorButton0.getStyleClass().add("btn");
      operatorButton0.getStyleClass().add("operator");
      operatorButton1.getStyleClass().add("btn");
      operatorButton1.getStyleClass().add("operator");
      operatorButton2.getStyleClass().add("btn");
      operatorButton2.getStyleClass().add("operator");
      operatorButton3.getStyleClass().add("btn");
      operatorButton3.getStyleClass().add("operator");
      operatorButton4.getStyleClass().add("btn");
      operatorButton4.getStyleClass().add("operator");

      functionButton0.getStyleClass().add("btn");
      functionButton0.getStyleClass().add("function");
      functionButton1.getStyleClass().add("btn");
      functionButton1.getStyleClass().add("function");
      functionButton2.getStyleClass().add("btn");
      functionButton2.getStyleClass().add("function");

      text1.getStyleClass().add("display");

      gridPane.getStyleClass().add("panel");

      // Creating a scene object
      Scene scene = new Scene(gridPane);
      scene.getStylesheets().add("q1/css/test.css");

      // Setting title to the Stage
      stage.setTitle("Caculator");

      // Adding scene to the stage
      stage.setScene(scene);

      //Displaying the contents of the stage
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
