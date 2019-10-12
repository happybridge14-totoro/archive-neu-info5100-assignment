class FullTime extends Employee {
  private final int WORKINGHOURS = 8;

  public FullTime(String name, int paymentPerHour) {
    super(name, paymentPerHour);
  }
  public int calculateSalary() {
    return this.getPaymentPerHour() * this.WORKINGHOURS * this.DAYS_PER_WEEK * this.WEEKS_PER_YEAR;
  }
}
