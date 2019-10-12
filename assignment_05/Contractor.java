class Contractor extends Employee {
  private int workingHours;

  public Contractor(String name, int paymentPerHour, int workingHours) {
    super(name, paymentPerHour);
    this.workingHours = workingHours;
  }

  public int calculateSalary() {
    return this.workingHours * this.getPaymentPerHour() * this.WEEKS_PER_YEAR * this.DAYS_PER_WEEK;
  }
}
