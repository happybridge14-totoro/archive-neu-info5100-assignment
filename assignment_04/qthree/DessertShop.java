package qthree;

public class DessertShop {
    private String name;
    public DessertShop(String name) {
        this.name = name;
    }
    public String getShopName() {
        return this.name;
    }
    public String cents2dollarsAndCentsmethod(int cents) {
        StringBuilder tmp = new StringBuilder();
        tmp.append(cents / 100);
        tmp.append(".");
        if (cents % 100 < 10) {
            tmp.append("0");
            tmp.append(cents % 100);
        } else {
            tmp.append(cents % 100);
        }
        return tmp.toString();
    }
}
