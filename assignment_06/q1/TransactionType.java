package q1;
public enum TransactionType {
  WITHDRAWAL ("withDrawal"),
  DEPOSIT ("deposit");

  private final String displayName;
  TransactionType(String displayName) {
    this.displayName = displayName;
  }
  public String toString() {
    return this.displayName;
  }
}
