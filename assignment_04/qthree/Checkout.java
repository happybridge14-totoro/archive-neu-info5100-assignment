package qthree;

import java.util.Vector;

public class Checkout {
    // According to the examples, the tax rate is 0.065.
    final double TAX_RATE = 0.065;
    DessertShop shop;
    int totalCost;

    private Vector<DessertItem> items;

    public Checkout() {
        this.items = new Vector<DessertItem>();
        this.shop = new DessertShop("M & M Dessert Shop");
        this.totalCost = 0;
    }
    public int numberOfItems() {
        return items.size();
    }
    public void enterItem(DessertItem item) {
        items.add(item);
        totalCost += item.getCost();
    }
    public void clear() {
        items.clear();
        totalCost = 0;
    }
    public int totalCost() {
        return totalCost;
    }
    public int totalTax() {
        return (int)Math.round(TAX_RATE * totalCost);
    }
    private void formatCenter(int maxLength, String mainString, StringBuilder output) {
        int mainStringLength = mainString.length();
        int blankSpace = (maxLength - mainStringLength) / 2;
        String format = "%" + (blankSpace + mainStringLength) + "s";
        output.append(String.format(format, mainString));
        output.append("\r\n");
    }
    private void formatWithPrice(int maxLength, String name, String cost,  StringBuilder output) {
        String format = "%" + (maxLength - name.length()) + "s";
        output.append(name);
        output.append(String.format(format, cost));
        output.append("\r\n");
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("\r\n");
        //Center strings
        final String dashes = "--------------------";
        final int stringLength = 50;
        this.formatCenter(stringLength, this.shop.getShopName(), ret);
        this.formatCenter(stringLength, dashes, ret);
        ret.append("\r\n");
        //items
        items.forEach((n)-> {
            if (n.getExtraInfo() != null) {
                ret.append(n.getExtraInfo());
                ret.append("\r\n");
            }
            this.formatWithPrice(stringLength, n.getName(), this.shop.cents2dollarsAndCentsmethod(n.getCost()), ret);
        });
        ret.append("\r\n");

        //summary
        this.formatWithPrice(stringLength, "Tax", this.shop.cents2dollarsAndCentsmethod(this.totalTax()), ret);
        this.formatWithPrice(stringLength, "Total Cost", this.shop.cents2dollarsAndCentsmethod(this.totalCost() + this.totalTax()), ret);
        return ret.toString();
    }
}
