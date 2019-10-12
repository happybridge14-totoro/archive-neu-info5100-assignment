abstract class Employee {
  private String name;
  private int paymentPerHour;
  final int DAYS_PER_WEEK = 5;
  final int WEEKS_PER_YEAR = 52;

  public Employee(String name, int paymentPerHour) {
    this.name = name;
    this.paymentPerHour = paymentPerHour;
  }

  public abstract int calculateSalary();

  public String getName() {
  	return name;
  }

  public void setName(String name) {
  	this.name = name;
  }

  public int getPaymentPerHour() {
  	return paymentPerHour;
  }

  public void setPaymentPerHour(int paymentPerHour) {
  	this.paymentPerHour = paymentPerHour;
  }
}
