package q1;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

class Test {
  public static void main(String[] args) {
    final String FILE_NAME = "q1/input.txt";
    File file = new File(FILE_NAME);
    System.out.println(file.getPath());
    System.out.println(file.getAbsolutePath());
    try {
      FileInputStream fileStream = new FileInputStream(file);
      StringBuilder ret = new StringBuilder();
      StringBuilder sentence = new StringBuilder();
      StringBuilder tmp = new StringBuilder();
      for (int i = fileStream.read(); i != -1; i = fileStream.read()) {
        String c = Character.toString(i);
        if (c.equals(" ")) {
          // Space
          sentence.insert(0, tmp);
          sentence.insert(0, ' ');
          tmp = new StringBuilder();
        } else if (c.matches("[.?!]")) {
          //End of a sentence
          sentence.insert(0, tmp);
          ret.append(sentence);
          ret.append(c);
          sentence = new StringBuilder();
          tmp = new StringBuilder();
        } else if (c.matches("[a-zA-Z0-9]")){
          tmp.append(c);
        } else {
          ret.append(c);
        }
      }
      System.out.println(ret.toString());
    } catch(IOException e) {
      System.out.println(e);
    }
  }
}
