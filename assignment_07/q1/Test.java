package q1;

import utils.FileReader;
import java.io.FileInputStream;
import java.io.IOException;

class Test extends FileReader{
  Test(String fileName) {
    super(fileName);
  }
  @Override
  protected void parseString(StringBuilder ret, FileInputStream fileStream) throws IOException {
    StringBuilder sentence = new StringBuilder();
    StringBuilder word = new StringBuilder();
    for (int i = fileStream.read(); i != -1; i = fileStream.read()) {
      String c = Character.toString(i);
      if (c.equals(" ")) {
        // Space
        sentence.insert(0, word);
        sentence.insert(0, ' ');
        word.setLength(0);
      } else if (c.matches("[.?!]")) {
        //End of a sentence
        sentence.insert(0, word);
        ret.append(sentence);
        ret.append(c);
        sentence.setLength(0);
        word.setLength(0);
      } else if (c.matches("[a-zA-Z0-9]")){
        word.append(c);
      } else {
        ret.append(c);
      }
    }
  }
  public static void main(String[] args) {
    final String FILE_NAME = "q1/input.txt";
    Test test = new Test(FILE_NAME);
    System.out.println(test.printString());
  }
}
