package utils;

import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class FilePrinter {
  static public void writeStringToFile(String fileName, String content) {
    File file = null;
    FileOutputStream fos = null;
    PrintStream ps = null;
    try {
      file = new File(fileName);
      fos = new FileOutputStream(file);
      ps = new PrintStream(fos);
      ps.print(content);
    } catch(IOException e) {
      System.out.println(e);
    } finally {
      try {
        fos.close();
        ps.close();
      } catch (Throwable ignore) {
      }
    }
  }
}
