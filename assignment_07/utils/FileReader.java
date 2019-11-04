package utils;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

abstract public class FileReader {
  private StringBuilder ret = new StringBuilder();
  public FileReader(String filepath) {
    File file = new File(filepath);
    FileInputStream fileStream = null;
    try {
      fileStream = new FileInputStream(file);
      this.parseString(ret, fileStream);
    } catch(IOException e) {
      System.out.println(e);
    } finally {
      try { fileStream.close(); } catch (Throwable ignore) {}
    }
  }
  public String printString() {
    return ret.toString();
  }
  protected abstract void parseString(StringBuilder ret, FileInputStream fileStream) throws IOException;
}
