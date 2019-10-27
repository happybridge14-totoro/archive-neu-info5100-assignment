package q1;

class User {
  private String name;
  private String age;
  private String address;
  private String phoneNumber;
  private String bankAccountNumber;

  public User(String bankAccountNumber, String name, String age, String address, String phoneNumber) {
    this.name = name;
    this.age = age;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.bankAccountNumber = bankAccountNumber;
  }
  public String getName() {
    return this.name;
  }
  public String getAge() {
    return this.age;
  }
  public String getAddress() {
    return this.address;
  }
  public String getPhoneNumber() {
    return this.phoneNumber;
  }
  public String getBankAccountNumber() {
    return this.bankAccountNumber;
  }
}
