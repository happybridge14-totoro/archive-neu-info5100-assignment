package q1.controller;

import q1.types.ButtonType;
import q1.model.Result;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import q1.view.BasicButton;

public class ButtonController implements EventHandler<ActionEvent>{
  private StringBuffer strBuffer;
  private boolean hasDot;
  private String operator;
  private Result result;
  private double previousNumber;
  private double cacheNumber;
  private boolean lock;

  final private String ERROR_STR = "error";

  private void reset() {
    strBuffer.setLength(0);
    hasDot = false;
    previousNumber = 0;
    cacheNumber = 0;
    operator = "";
    lock = false;
  }
  private void clearCache() {
    this.cacheNumber = 0;
  }
  private void softReset() {
    strBuffer.setLength(0);
    hasDot = false;
  }
  private double getCurrentNumber() {
    if (strBuffer.length() == 0) {
      return 0.0;
    }
    String numStr = strBuffer.toString();
    this.cacheNumber = this.doubleToString(numStr);
    return this.cacheNumber;
  }
  private double doubleToString(String numStr) {
    double ret = 0.0;
    try {
      ret = Double.valueOf(numStr);
    } catch(Exception e) {
      this.showError();
    }
    return ret;
  }
  private void showError() {
      this.lock = true;
      this.result.setInputValue(this.ERROR_STR);
  }
  private void calculate() {
    double tmp = strBuffer.length() == 0 ? this.cacheNumber : this.getCurrentNumber();
    if (this.operator.equals(ButtonType.PLUS.getValueString())) {
      this.previousNumber += tmp;
    } else if (this.operator.equals(ButtonType.MINUS.getValueString())){
      this.previousNumber -= tmp;
    } else if (this.operator.equals(ButtonType.MULTIPLY.getValueString())){
      this.previousNumber *= tmp;
    } else if (this.operator.equals(ButtonType.DIVIDE.getValueString())){
      this.previousNumber = this.previousNumber / tmp;
      this.lock = this.previousNumber == Double.POSITIVE_INFINITY || (this.previousNumber == Double.NEGATIVE_INFINITY);
    } else {
      this.previousNumber = tmp == 0 ? this.previousNumber : tmp;
    }
    this.result.setValue(this.previousNumber);
    this.softReset();
  }
  public ButtonController(Result result) {
    super();
    this.result = result;
    strBuffer = new StringBuffer();
    this.reset();
  }
  public void handle(ActionEvent e) {
    BasicButton target = (BasicButton)e.getTarget();
    ButtonType buttonType = target.getType();
    switch (buttonType) {
      case ONE:
      case TWO:
      case THREE:
      case FOUR:
      case FIVE:
      case SIX:
      case SEVEN:
      case EIGHT:
      case NINE:
        if (strBuffer.length() < 9 && !this.lock) {
          this.clearCache();
          strBuffer.append(buttonType.getValueString());
          this.result.setInputValue(strBuffer.toString());
        }
        break;
      case ZERO:
        if (!this.lock) {
          this.clearCache();
          if (strBuffer.length() != 0 && strBuffer.length() < 9) {
            strBuffer.append(buttonType.getValueString());
          }
          this.result.setInputValue(strBuffer.toString());
        }
        break;
      case DOT:
        if (!hasDot&& strBuffer.length() < 9 && !this.lock) {
          this.clearCache();
          hasDot = true;
          if (strBuffer.length() == 0) {
            strBuffer.append(ButtonType.ZERO.getValueString());
          }
          strBuffer.append(buttonType.getValueString());
          this.result.setInputValue(strBuffer.toString());
        }
        break;
      case PLUS:
      case MINUS:
      case MULTIPLY:
      case DIVIDE:
        if (!this.lock) {
          this.operator = buttonType.getValueString();
          if (strBuffer.length() != 0) {
            this.previousNumber = this.getCurrentNumber();
          }
          this.softReset();
        }
        break;
      case EQUAL:
        if (!this.lock) {
          this.calculate();
        }
        break;
      case CLEAR:
        this.reset();
        this.result.setInputValue("0");
        break;
      case SIGN:
        if (!this.lock) {
          if (strBuffer.length() > 0) {
            if (strBuffer.charAt(0) != buttonType.getValueString().charAt(0)) {
              strBuffer.insert(0, buttonType.getValueString());
            } else {
              strBuffer.deleteCharAt(0);
            }
            this.result.setInputValue(strBuffer.toString());
          } else if (this.previousNumber != 0) {
            this.previousNumber *= -1;
            this.result.setValue(this.previousNumber);
          }
        }
        break;
      case PERCENT:
        if (!this.lock) {
          if (strBuffer.length() > 0) {
            String tmp = strBuffer.toString();
            this.reset();
            this.previousNumber = this.doubleToString(tmp) / 100;
            this.result.setValue(this.previousNumber);
          } else if (this.previousNumber != 0) {
            Double tmp = this.previousNumber;
            this.reset();
            this.previousNumber = tmp / 100;
            this.result.setValue(this.previousNumber);
          }
        }
        break;
      default:
        break;
    }
  }
}
