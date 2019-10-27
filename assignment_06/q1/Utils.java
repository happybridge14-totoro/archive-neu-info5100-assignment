package q1;

class Utils {
  static public String displayBalance(int originalBalanceData) {
    double data = originalBalanceData / 100.0;
    return String.format("%.2f", data);
  }
  static public String displayBalanceWithDolllar(int originalBalanceData) {
    return "$" + displayBalance(originalBalanceData);
  }

  final static public String FORMAT = "%-12s";
  final static public String TIMEFORMAT = "%-21s";
  final static public String AMOUNTFORMAT = "%-16s";
}
