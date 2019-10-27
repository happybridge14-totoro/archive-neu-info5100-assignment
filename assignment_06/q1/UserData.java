package q1;

import java.util.ArrayDeque;
import java.util.Iterator;

class UserData {
  private User user;
  private String pwd;
  private int balance;
  private ArrayDeque<Transaction> records;
  private final int MAX_RECORD_LENGTH = 10;

  public UserData(String accountNumber, String name, String age, String address, String phoneNumber, String pwd) {
    this.pwd = pwd;
    this.balance = 0;
    this.user = new User(accountNumber, name, age, address, phoneNumber);
    records = new ArrayDeque<Transaction>();
  }
  public boolean checkPassWord(String pwd) {
    return pwd.equals(this.pwd);
  }
  public void updatePassWord(String pwd) {
    this.pwd = pwd;
  }
  public int getBalance() {
    return this.balance;
  }
  public int deposit(int amount) {
    this.balance += amount;
    return this.balance;
  }
  public int withdraw(int amount) {
    if (this.balance >= amount) {
      this.balance -= amount;
    }
    return this.balance;
  }
  public String getName() {
    return this.user.getName();
  }
  public boolean checkName(String name) {
    return name.equals(this.user.getName());
  }
  public boolean checkAge(String age) {
    return age.equals(this.user.getAge());
  }
  public boolean checkPhoneNumber(String phoneNumber) {
    return phoneNumber.equals(this.user.getPhoneNumber());
  }
  public void addTransactionRecord(Transaction newRecord) {
    records.add(newRecord);
  }
  public Transaction[] getRecentTransactions() {
    int length = records.size() > this.MAX_RECORD_LENGTH ? this.MAX_RECORD_LENGTH : records.size();
    Transaction[] ret = new Transaction[length];
    Iterator<Transaction> itr = records.descendingIterator();
    for (int i = 0; i < length; i++) {
      ret[i] = itr.next();
    }
    return ret;
  }
}
