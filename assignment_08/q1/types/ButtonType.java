package q1.types;
public enum ButtonType
{
    ONE ("1"),
    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE ("5"),
    SIX ("6"),
    SEVEN ("7"),
    EIGHT ("8"),
    NINE ("9"),
    ZERO ("0"),
    DOT ("."),
    PLUS ("+"),
    MINUS ("-"),
    MULTIPLY ("×"),
    DIVIDE ("÷"),
    EQUAL ("="),
    PERCENT ("%"),
    SIGN ("+/-", "-"),
    CLEAR ("AC");

    private String displayString;
    private String valueString;
    ButtonType(String displayString) {
      this.displayString = displayString;
      this.valueString = displayString;
    }
    ButtonType(String displayString, String valueString) {
      this.displayString = displayString;
      this.valueString = valueString;
    }
    public String toString() {
      return this.displayString;
    }
    public String getValueString() {
      return this.valueString;
    }
}
