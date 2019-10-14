package animal.pet;
import java.time.LocalDate;
import animal.boardable.Boardable;

public class Pet implements Boardable{
  static public int MALE = 0;
  static public int FEMALE = 1;
  static public int SPAYED = 2;
  static public int NEUTERED = 3;

  private String[] sexString = {"male", "female", "spayed", "neutered"};
  private String name;
  private String ownerName;
  private String color;
  int sex;
  private LocalDate boardingStartDate;
  private LocalDate boardingEndDate;

  public Pet(String name, String ownerName, String color) {
    this.name = name;
    this.ownerName = ownerName;
    this.color = color;
  }

  public void setBoardStart(int month, int day, int year) {
    this.boardingStartDate = LocalDate.of(year, month, day);
  }
  public void setBoardEnd(int month, int day, int year) {
    this.boardingEndDate = LocalDate.of(year, month, day);
  }
  public boolean boarding(int month, int day, int year) {
    LocalDate tmp = LocalDate.of(year, month, day);
    return tmp.compareTo(this.boardingStartDate) >= 0 && tmp.compareTo(this.boardingEndDate) <= 0;
  }

  public String getName() {
    return this.name;
  }

  public String getOwnerName() {
    return this.ownerName;
  }

  public String getColor() {
    return this.color;
  }

  public void setSex(int sexid) {
    this.sex = sexid;
  }

  public String getSex() {
    return sexString[sex];
  }

  public String toString() {
    return this.name + " owened by " + this.ownerName + "\r\n\r\nColor: " + this.color + "\r\n\r\nSex: " + this.getSex();
  }
}
