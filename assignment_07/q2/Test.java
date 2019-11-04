package q2;

import utils.FileReader;
import utils.FilePrinter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

class Test extends FileReader{
  Test(String fileName) {
    super(fileName);
  }
  @Override
  protected void parseString(StringBuilder ret, FileInputStream fileStream) throws IOException {
    Stack<Integer> numberStack = new Stack<Integer>();
    Stack<String> stringStack = new Stack<String>();
    StringBuilder tmp = new StringBuilder();
    for (int i = fileStream.read(); i != -1; i = fileStream.read()) {
      String c = Character.toString(i);
      if (c.matches("[a-zA-Z]")) {
        if (numberStack.empty()) {
          ret.append(c);
        } else {
          tmp.append(c);
        }
      } else if(c.matches("\\d")) {
        numberStack.push(Integer.parseInt(c));
      } else if(c.equals("[")) {
        if (tmp.length() != 0) {
          stringStack.push(tmp.toString());
          tmp.setLength(0);
        }
      } else if(c.equals("]")) {
        int times = numberStack.pop();
        String str = null;
        if (tmp.length() != 0) {
          str = tmp.toString();
        } else {
          str = stringStack.pop();
        }
        tmp.setLength(0);
        while(times-- > 0) {
          tmp.append(str);
        }
        if (stringStack.empty()) {
          ret.append(tmp);
        } else {
          stringStack.push(new StringBuilder(stringStack.pop()).append(tmp).toString());
        }
        tmp.setLength(0);
      } else {
        ret.append(c);
      }
    }
  }
  public static void main(String[] args) {
    final String FILE_NAME = "q2/input.txt";
    final String OUTPUT_FILE_NAME = "q2/output.txt";
    Test test = new Test(FILE_NAME);
    FilePrinter.writeStringToFile(OUTPUT_FILE_NAME, test.printString());
  }
}
