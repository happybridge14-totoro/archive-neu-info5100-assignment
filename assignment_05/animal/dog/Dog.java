package animal.dog;
import animal.pet.Pet;

public class Dog extends Pet {
  private String size;
  public Dog(String name, String ownerName, String color, String size) {
    super(name, ownerName, color);
    this.size = size;
  }
  public String toString() {
    return "Dog:\r\n\r\n" + super.toString() + "\r\n\r\nSize: " + this.size;
  }
}
