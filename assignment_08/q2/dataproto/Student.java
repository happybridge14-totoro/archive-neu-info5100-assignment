package q2.dataproto;

public class Student {
  private String id;
  private String name;
  private GenderType gender;

  public Student() {
    this.id = "";
    this.name = "";
  }

  public Student(String id, String name, GenderType gender) {
    this.id = id;
    this.name = name;
    this.gender = gender;
  }
  public void modifyData(String id, String name, GenderType gender) {
    this.id = id;
    this.name = name;
    this.gender = gender;
  }
  public String getID() {
    return this.id;
  }
  public String getName() {
    return this.name;
  }
  public GenderType getGender() {
    return this.gender;
  }
}
