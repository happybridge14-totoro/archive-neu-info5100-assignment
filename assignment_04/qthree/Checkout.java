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
    public String toString() {
        return "";
    }
}
