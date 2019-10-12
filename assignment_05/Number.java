import java.util.Scanner;
import java.util.InputMismatchException;

class Number {
  static public void count() {
    Scanner input = new Scanner(System.in);
    try {
      System.out.print("Please input the integer dividend: ");
      int dividend = input.nextInt();
      System.out.print("Please input the integer divisor: ");
      int divisor = input.nextInt();
      System.out.println("The result is: " + dividend / divisor);
    } catch(InputMismatchException e) {
      System.out.println("Input error: the input is not an integer.");
    } catch(ArithmeticException e) {
      System.out.println("Math error: " + e.getMessage());
    } catch(Exception e) {
      System.out.println("Error: " + e.getMessage());
    } finally {
      input.close();
      System.out.println("Scanner closed.");
    }
  }
}
