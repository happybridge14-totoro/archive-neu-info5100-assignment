package q1;

class Test {
  public static void main(String[] args) {
    Atm test = new Atm(100000, 10);
    //Add two test data here
    test.addUser("1", "1", "1", "1", "1", "1");
    test.addUser("2", "2", "2", "2", "2", "2");
    //Main entrance
    test.run();
  }
}
