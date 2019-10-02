package qthree;

public class Cookie extends DessertItem {
    private int number;
    private double pricePerDozen;

    public Cookie(String name, int number, double pricePerDozen) {
        this.name = name;
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public int getCost() {
        return (int)Math.round(pricePerDozen * number / 12);
    }
    public String getUnitInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(" @ ");
        sb.append(pricePerPound);
        sb.append(" /lb.");
        return sb.toString();
    }
}
