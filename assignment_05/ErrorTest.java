class ErrorTest {
  public static void test() throws IndexOutOfBoundsException {
    try {
      int ary[] = {1};
      int index = 33;
      System.out.println(ary[index]);
    } catch(IndexOutOfBoundsException e) {
      throw new MyIndexOutOfBoundException(e);
    }
  }
}
