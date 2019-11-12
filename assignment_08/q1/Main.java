package q1;

import q1.model.*;
import q1.controller.*;
import q1.view.*;
import q1.types.ButtonType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

// import javafx.beans.property.StringProperty;
// import javafx.beans.property.SimpleStringProperty;
// import javafx.beans.value.ChangeListener;

public class Main extends Application {
   @Override
   public void start(Stage stage) {
      //Creating a Grid Pane
      GridPane gridPane = new GridPane();
      Result result = new Result();
      ButtonController btnController = new ButtonController(result);
      //Creating buttons
      final ButtonType[] NUMBER_BUTTON_TEXT = new ButtonType[]{ButtonType.ZERO,
                                                        ButtonType.ONE,
                                                        ButtonType.TWO,
                                                        ButtonType.THREE,
                                                        ButtonType.FOUR,
                                                        ButtonType.FIVE,
                                                        ButtonType.SIX,
                                                        ButtonType.SEVEN,
                                                        ButtonType.EIGHT,
                                                        ButtonType.NINE,
                                                        ButtonType.DOT};
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
          numberButtton.setOnAction(btnController);
      }
      final ButtonType[] OPERATOR_BUTTON_TEXT = new ButtonType[]{ButtonType.DIVIDE,
                                                        ButtonType.MULTIPLY,
                                                        ButtonType.MINUS,
                                                        ButtonType.PLUS,
                                                        ButtonType.EQUAL};
      final int OPERATOR_BUTTON_POS_X = 3;
      final int[] OPERATOR_BUTTON_POS_Y = new int[]{2, 3, 4, 5, 6};
      for (int i = 0; i < OPERATOR_BUTTON_TEXT.length; i++) {
          Button operatorButtton = new OperatorButton(OPERATOR_BUTTON_TEXT[i]);
          gridPane.add(operatorButtton, OPERATOR_BUTTON_POS_X, OPERATOR_BUTTON_POS_Y[i]);
          operatorButtton.setOnAction(btnController);
      }
      final ButtonType[] FUNCTION_BUTTON_TEXT = new ButtonType[]{ButtonType.CLEAR,
                                                        ButtonType.SIGN,
                                                        ButtonType.PERCENT};
      final int[] FUNCTION_BUTTON_POS_X = new int[]{0, 1, 2};
      final int FUNCTION_BUTTON_POS_Y = 2;
      for (int i = 0; i < FUNCTION_BUTTON_TEXT.length; i++) {
          Button functionButtton = new FunctionButton(FUNCTION_BUTTON_TEXT[i]);
          gridPane.add(functionButtton, FUNCTION_BUTTON_POS_X[i], FUNCTION_BUTTON_POS_Y);
          functionButtton.setOnAction(btnController);
      }
      //creating label
      Label text1 = new Label("0");
      gridPane.add(text1, 0, 0, 5, 1);
      text1.getStyleClass().add("display");

      //bind model to controller
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
      scene.getStylesheets().add(urlString);
      // Setting title to the Stage
      final String TITLE = "Calculator";
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
