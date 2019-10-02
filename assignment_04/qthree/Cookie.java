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
    public String getExtraInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.number);
        sb.append(" @ ");
        sb.append(this.pricePerDozen / 100);
        sb.append(" /dz.");
        return sb.toString();
    }
}
