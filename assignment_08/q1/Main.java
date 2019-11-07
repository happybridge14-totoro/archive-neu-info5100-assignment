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
   @Override
   public void start(Stage stage) {
      //creating label email
      Label text1 = new Label("0");

      //Creating Buttons
      Button numButton0 = new Button("0");
      Button numButton1 = new Button("1");
      Button numButton2 = new Button("2");
      Button numButton3 = new Button("3");
      Button numButton4 = new Button("4");
      Button numButton5 = new Button("5");
      Button numButton6 = new Button("6");
      Button numButton7 = new Button("7");
      Button numButton8 = new Button("8");
      Button numButton9 = new Button("9");
      Button numButton10 = new Button(".");

      Button operatorButton0 = new Button("÷");
      Button operatorButton1 = new Button("×");
      Button operatorButton2 = new Button("-");
      Button operatorButton3 = new Button("+");
      Button operatorButton4 = new Button("=");

      Button functionButton0 = new Button("AC");
      Button functionButton1 = new Button("+/-");
      Button functionButton2 = new Button("%");

      //Creating a Grid Pane
      GridPane gridPane = new GridPane();

      //Arranging all the nodes in the grid
      gridPane.add(numButton0, 0, 6, 2, 1);
      gridPane.add(numButton1, 0, 5);
      gridPane.add(numButton2, 1, 5);
      gridPane.add(numButton3, 2, 5);
      gridPane.add(numButton4, 0, 4);
      gridPane.add(numButton5, 1, 4);
      gridPane.add(numButton6, 2, 4);
      gridPane.add(numButton7, 0, 3);
      gridPane.add(numButton8, 1, 3);
      gridPane.add(numButton9, 2, 3);
      gridPane.add(numButton10, 2, 6);

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
      numButton0.getStyleClass().add("btn");
      numButton0.getStyleClass().add("number");
      numButton0.getStyleClass().add("large");
      numButton1.getStyleClass().add("btn");
      numButton1.getStyleClass().add("number");
      numButton2.getStyleClass().add("btn");
      numButton2.getStyleClass().add("number");
      numButton3.getStyleClass().add("btn");
      numButton3.getStyleClass().add("number");
      numButton4.getStyleClass().add("btn");
      numButton4.getStyleClass().add("number");
      numButton5.getStyleClass().add("btn");
      numButton5.getStyleClass().add("number");
      numButton6.getStyleClass().add("btn");
      numButton6.getStyleClass().add("number");
      numButton7.getStyleClass().add("btn");
      numButton7.getStyleClass().add("number");
      numButton8.getStyleClass().add("btn");
      numButton8.getStyleClass().add("number");
      numButton9.getStyleClass().add("btn");
      numButton9.getStyleClass().add("number");
      numButton10.getStyleClass().add("btn");
      numButton10.getStyleClass().add("number");

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
      stage.setResizable(false);

      // Adding scene to the stage
      stage.setScene(scene);

      //Displaying the contents of the stage
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
