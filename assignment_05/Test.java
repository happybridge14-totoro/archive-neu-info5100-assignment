import java.time.LocalDate;
import animal.pet.Pet;
import animal.cat.Cat;
import animal.dog.Dog;

class Test {
  public static void main(String[] args) {
    //Q1
    System.out.println("Q1:");
    System.out.println("'final' is a keyword.");
    System.out.println("Final is used to apply restrictions on class, method and variable. Final class can't be inherited, final method can't be overridden and final variable value can't be changed.");
    System.out.println("'finally' is a block.");
    System.out.println("Finally is used to place important code, it will be executed whether exception is handled or not.");
    System.out.println();

    //Q2
    System.out.println("Q2:");
    Number.count();
    System.out.println();

    //Q3
    System.out.println("Q3:");
    int workingHours = 8;
    Contractor contractorTest = new Contractor("tom", 10, workingHours);
    System.out.println("Name: " + contractorTest.getName() + ", paymentPerHour: " + contractorTest.getPaymentPerHour() + ", workingHours: " + workingHours);
    System.out.println(contractorTest.getName() + "'s salary is: " + contractorTest.calculateSalary());
    FullTime fullTimeTest = new FullTime("paul", 10);
    System.out.println("Name: " + fullTimeTest.getName() + ", paymentPerHour: " + fullTimeTest.getPaymentPerHour());
    System.out.println(fullTimeTest.getName() + "'s salary is: " + fullTimeTest.calculateSalary());
    System.out.println();

    //Q4
    System.out.println("Q4:");
    try {
      ErrorTest.test();
    } catch(MyIndexOutOfBoundException e) {
      System.out.println(e);
    }
    System.out.println();

    //Q5
    System.out.println("Q5:");
    LocalDate rightNow = LocalDate.now();
    Cat catTest = new Cat("Tom", "Bob", "black", "short");
    catTest.setSex(Pet.SPAYED);
    catTest.setBoardStart(12, 11, 2016);
    catTest.setBoardEnd(12, 11, 2020);
    System.out.println(catTest);
    System.out.println();
    System.out.println("Is this cat on board? " + catTest.boarding(rightNow.getMonthValue(), rightNow.getDayOfMonth(), rightNow.getYear()));
    System.out.println();

    Dog dogTest = new Dog("Mumu", "Henry", "black and white", "medium");
    dogTest.setSex(Pet.NEUTERED);
    dogTest.setBoardStart(11, 12, 2016);
    dogTest.setBoardEnd(8, 15, 2019);
    System.out.println(dogTest);
    System.out.println();
    System.out.println("Is this dog on board? " + dogTest.boarding(rightNow.getMonthValue(), rightNow.getDayOfMonth(), rightNow.getYear()));
    System.out.println();

    //Q6
    System.out.println("Q6:");
    System.out.println("Order:");
    System.out.println("c.size() == 3");
    System.out.println("b.addAll(list)->addCount+=c.size(): b.getAddCount() == 3");
    System.out.println("b.addAll(list)->super.addAll(c): b.getAddCount() == 3");
    System.out.println("b.addAll(list)->super.addAll(c)->this.add(it.next()): b.getAddCount() == 4");
    System.out.println("b.addAll(list)->super.addAll(c)->this.add(it.next()): b.getAddCount() == 5");
    System.out.println("b.addAll(list)->super.addAll(c)->this.add(it.next()): b.getAddCount() == 6");
    System.out.println("b.getAddCount() + b.getI() == 6");
    System.out.println("add function in class A is never used.");
    System.out.println("i in class B is never used.");
    System.out.println();
  }
}
