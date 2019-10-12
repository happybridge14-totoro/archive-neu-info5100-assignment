class Cat extends Pet {
  private String hairLength;
  public Cat(String name, String ownerName, String color, String hairLength) {
    super(name, ownerName, color);
    this.hairLength = hairLength;
  }
  public String toString() {
    return "Cat:\r\n\r\n" + super.toString() + "\r\n\r\nHair:" + this.hairLength;
  }
}
