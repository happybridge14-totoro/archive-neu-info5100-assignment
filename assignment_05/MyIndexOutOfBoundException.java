import java.util.regex.Pattern;
import java.util.regex.Matcher;
class MyIndexOutOfBoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  final private int lowerBound = 0;
  private int upperBound;
  private int index;
  public MyIndexOutOfBoundException(IndexOutOfBoundsException e) {
    Pattern pattern = Pattern.compile("(\\d)+");
    Matcher matcher = pattern.matcher(e.getMessage());
    if (matcher.find())
    {
      index = Integer.parseInt(matcher.group());
    }
    if (matcher.find())
    {
      upperBound = Integer.parseInt(matcher.group());
    }
  }
  public String getMessage() {
    return "Index: " + this.index + ", but Lower bound: " + this.lowerBound + ", UpperBound: " + this.upperBound;
  }
  public String toString() {
    return "Error Message: " + this.getMessage();
  }
}
