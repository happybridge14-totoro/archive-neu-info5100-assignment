package q1;
import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;
import java.io.Console;
import java.util.stream.Stream;
import java.util.Arrays;

class Atm {
  enum STATUS {
    IDLE,
    LOGIN,
    SIGNUP,
    RESETPASSWORD,
    OPERATION
  };

  private int availableAmountInMachine;
  private int transactionFee;

  private HashMap<String, UserData> usersInfo;
  private Stack<STATUS> statusStack;

  public Atm(int totalAmount, int transactionFee) {
    this.availableAmountInMachine = totalAmount;
    this.transactionFee = transactionFee;
    this.usersInfo = new HashMap<String, UserData>();
    this.statusStack = new Stack<STATUS>();
  }

  private UserData checkAccountNumber(String accountNumber) {
    return this.usersInfo.get(accountNumber);
  }

  private String setNewPassword(Console console) {
    char[] passwordArray, recheckPwdAry;
    while(true) {
      System.out.println("Please enter your new password:");
      passwordArray = console.readPassword("");
      System.out.println("Please re-enter your password:");
      recheckPwdAry = console.readPassword("");
      boolean samePassword = true;
      if (passwordArray.length == recheckPwdAry.length) {
        for (int i = 0; i < passwordArray.length; i++) {
          if(passwordArray[i] != recheckPwdAry[i]) {
            samePassword = false;
            break;
          }
        }
      }
      if (samePassword) {
        return new String(passwordArray);
      } else {
        System.out.println("Password not match.");
      }
    }
  }

  public void addUser(String accountNumber, String name, String age, String address, String phoneNumber, String pwd) {
    this.usersInfo.put(accountNumber, new UserData(accountNumber, name, age, address, phoneNumber, pwd));
  }

  public void run() {
    Scanner scanner = new Scanner(System.in);
    STATUS currentStatus = STATUS.IDLE;
    String accountNumber, password, name, age, address, phone;
    Console console = System.console();
    char[] passwordArray;
    String action;
    UserData currentUserInfo = null;
    try {
      while(true) {
        switch (currentStatus) {
          case IDLE:
            System.out.println("Enter number to choose action: 1.Login 2.SignUp 0.Exit");
            action = scanner.nextLine();
            System.out.println(action);
            if (action.equals("1")) {
              statusStack.push(currentStatus);
              currentStatus = STATUS.LOGIN;
            } else if (action.equals("2")) {
              statusStack.push(currentStatus);
              currentStatus = STATUS.SIGNUP;
            } else if (action.equals("0")) {
              scanner.close();
              return;
            } else {
              System.out.println("Invalid number, please choose again.");
            }
            break;
          case LOGIN:
            System.out.println("Please enter your bank account number:");
            accountNumber = scanner.nextLine();
            currentUserInfo = checkAccountNumber(accountNumber);
            if (currentUserInfo != null) {
              System.out.println("Please enter the password:");
              passwordArray = console.readPassword("");
              password = new String(passwordArray);
              if (currentUserInfo.checkPassWord(password)) {
                System.out.println("Welcome, " + currentUserInfo.getName() + "!");
                statusStack.add(currentStatus);
                currentStatus = STATUS.OPERATION;
              } else {
                System.out.println("Password error! Please check your password.");
                System.out.println("Enter number to choose action: 1.Back 2.Forget password");
                while (true) {
                  action = scanner.nextLine();
                  if (action.equals("1")) {
                    currentStatus = statusStack.pop();
                    break;
                  } else if(action.equals("2")) {
                    statusStack.add(currentStatus);
                    currentStatus = STATUS.RESETPASSWORD;
                    break;
                  } else {
                    System.out.println("Invalid number, please choose again.");
                  }
                }
              }
            } else {
              System.out.println("Bank account number not exists. Please check your bank account number or register a new account.");
              currentStatus = statusStack.pop();
            }
            break;
          case SIGNUP:
            System.out.println("Please follow the instruction to register as a new user:");
            System.out.println("Please enter your bank account number:");
            accountNumber = scanner.nextLine();
            if (this.checkAccountNumber(accountNumber) == null) {
              password = setNewPassword(console);
              System.out.println("Please enter your name:");
              name = scanner.nextLine();
              System.out.println("Please enter your age:");
              age = scanner.nextLine();
              System.out.println("Please enter your phone number:");
              phone = scanner.nextLine();
              System.out.println("Please enter your address:");
              address = scanner.nextLine();
              usersInfo.put(accountNumber, new UserData(accountNumber, name, age, address, phone, password));
              System.out.println("New account created. Now you can login with your bank account number.");
            } else {
              System.out.println("Account already exists. You can sign in with this account.");
            }
            currentStatus = statusStack.pop();
            break;
          case RESETPASSWORD:
            System.out.println("Please provide your information to reset the password:");
            System.out.println("Please enter your name:");
            name = scanner.nextLine();
            boolean hasError = true;
            if (currentUserInfo.checkName(name)) {
              System.out.println("Please enter your age:");
              age = scanner.nextLine();
              if (currentUserInfo.checkAge(age)) {
                System.out.println("Please enter your phoneNumber:");
                phone = scanner.nextLine();
                if (currentUserInfo.checkPhoneNumber(phone)) {
                  hasError = false;
                  System.out.println("Information matches.");
                  password = setNewPassword(console);
                  currentUserInfo.updatePassWord(password);
                  System.out.println("New password set. Please login:");
                }
              }
            }
            if (hasError) {
              System.out.println("Checking failed. Unable to reset the password.");
            }
            currentStatus = statusStack.pop();
            break;
          case OPERATION:
            System.out.println("Enter number to choose action: 1.Show balance 2.Withdraw 3.Deposit 4.Show recent transactions 5.Change password 0.Exit");
            while (true) {
              action = scanner.nextLine();
              if (action.equals("1")) {
                System.out.println("Your balance is: " + Utils.displayBalanceWithDolllar(currentUserInfo.getBalance()));
                break;
              } else if(action.equals("2")) {
                while(true) {
                  System.out.print("Please enter the amount you want to withdraw (the transaction fee is ");
                  System.out.print(Utils.displayBalanceWithDolllar(this.transactionFee));
                  System.out.print(", maximum amount is: ");
                  System.out.print(Utils.displayBalanceWithDolllar(this.availableAmountInMachine));
                  System.out.println("):");
                  System.out.print("$");
                  String s = scanner.nextLine();
                  if (s.matches("^\\d*\\.?\\d{0,2}")) {
                    double tmp = Double.parseDouble(s);
                    int amount = (int) (tmp * 100);
                    int totalToWithdraw = amount + this.transactionFee;
                    int balance = currentUserInfo.getBalance();
                    double dbBalance = balance / 100.0;
                    if ((tmp * 100) > Integer.MAX_VALUE) {
                      System.out.println("Amount exceeds system limit! Please enter again");
                      continue;
                    }
                    if (balance >= totalToWithdraw) {
                      if (totalToWithdraw <= this.availableAmountInMachine) {
                        balance = currentUserInfo.withdraw(totalToWithdraw);
                        Transaction newRecord = new Transaction(TransactionType.WITHDRAWAL, amount, this.transactionFee, balance);
                        currentUserInfo.addTransactionRecord(newRecord);
                        System.out.println("Done!");
                        break;
                      } else {
                        System.out.println("Sorry, the amount is beyond this machine's maximum amount.");
                        break;
                      }
                    } else {
                      System.out.println("The amount and fee is more than your balance.");
                      break;
                    }
                  } else {
                    System.out.println("Not a valid number! Please enter again.");
                  }
                }
                break;
              } else if(action.equals("3")) {
                while(true) {
                  System.out.println("Please enter the amount you want to deposit (the transaction fee is " + Utils.displayBalanceWithDolllar(this.transactionFee) + ", the mount should be greater than the transaction fee):");
                  System.out.print("$");
                  String s = scanner.nextLine();
                  if (s.matches("^\\d*\\.?\\d{0,2}")) {
                    double tmp = Double.parseDouble(s);
                    int amount = (int) (tmp * 100);
                    int balance = currentUserInfo.getBalance();
                    if ((tmp * 100 + balance) > Integer.MAX_VALUE) {
                      System.out.println("Amount exceeds system limit! Please enter again");
                      continue;
                    }
                    if (amount > this.transactionFee) {
                      balance = currentUserInfo.deposit(amount - this.transactionFee);
                      Transaction newRecord = new Transaction(TransactionType.DEPOSIT, amount, this.transactionFee, balance);
                      currentUserInfo.addTransactionRecord(newRecord);
                      System.out.println("Done!");
                    } else {
                      System.out.println("The amount is not greater than the transaction fee.");
                    }
                    break;
                  } else {
                    System.out.println("Not a valid number! Please enter again.");
                  }
                }
                break;
              } else if(action.equals("4")) {
                System.out.println("Transaction details:(most recent 10 records)");
                StringBuilder ret = new StringBuilder();
                ret.append(String.format(Utils.TIMEFORMAT, "Date Time"));
                ret.append(String.format(Utils.FORMAT, "Type"));
                ret.append(String.format(Utils.AMOUNTFORMAT, "Amount"));
                ret.append(String.format(Utils.FORMAT, "Fee"));
                ret.append(String.format(Utils.AMOUNTFORMAT, "Balance"));
                System.out.println(ret.toString());
                Transaction[] records = currentUserInfo.getRecentTransactions();
                Stream<Transaction> recordStream = Arrays.stream(records);
                recordStream.forEach(x->{
                  System.out.println(x);
                });
                recordStream.close();
                break;
              } else if(action.equals("5")) {
                password = setNewPassword(console);
                currentUserInfo.updatePassWord(password);
                System.out.println("New password set.");
                break;
              } else if(action.equals("0")) {
                System.out.println("Thank you for using ATM, goodbye!");
                currentStatus = STATUS.IDLE;
                statusStack.empty();
                break;
              } else {
                System.out.println("Invalid number, please choose again.");
              }
            }
            break;
        }
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }
}
