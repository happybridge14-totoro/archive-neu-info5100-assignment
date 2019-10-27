package q1;

import java.time.LocalDateTime;

class Transaction {
  private LocalDateTime time;
  private TransactionType type;
  private int amount;
  private int fee;
  private int balance;

  public Transaction(TransactionType type, int amount, int fee, int balance) {
    time = LocalDateTime.now();
    this.type = type;
    this.amount = amount;
    this.fee = fee;
    this.balance = balance;
  }

  public String toString() {
    StringBuilder ret = new StringBuilder();
    ret.append(String.format(Utils.TIMEFORMAT, this.time.withNano(0).toString()));
    ret.append(String.format(Utils.FORMAT, type.toString()));
    ret.append(String.format(Utils.AMOUNTFORMAT, Utils.displayBalanceWithDolllar(amount)));
    ret.append(String.format(Utils.FORMAT, Utils.displayBalanceWithDolllar(fee)));
    ret.append(String.format(Utils.AMOUNTFORMAT, Utils.displayBalanceWithDolllar(balance)));
    return ret.toString();
  }
}
