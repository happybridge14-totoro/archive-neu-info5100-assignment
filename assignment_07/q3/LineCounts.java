package q3;

import utils.FileReader;
import java.io.FileInputStream;
import java.io.IOException;

class LineCounts extends FileReader{
  LineCounts(String fileName) {
    super(fileName);
  }
  @Override
  protected void parseString(StringBuilder ret, FileInputStream fileStream) throws IOException {
    int count = 0;
    for (int i = fileStream.read(); i != -1; i = fileStream.read()) {
      String c = Character.toString(i);
      if (c.equals("\r") || c.equals("\n")) {
        count++;
      }
    }
    ret.append(count);
  }
  public static void main(String[] args) {
    for(int i = 0; i < args.length; i++) {
      String fileName = (String)args[i];
      LineCounts test = new LineCounts(fileName);
      System.out.println("File name: " + fileName);
      System.out.print("Line count: ");
      System.out.println(test.printString());
    }
  }
}
