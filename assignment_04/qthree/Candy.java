package qthree;

class Candy extends DessertItem {
    private double weight;
    private double pricePerPound;

    public Candy(String name, double weight, double pricePerPound) {
        this.name = name;
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    public int getCost() {
        return (int)Math.round(weight * pricePerPound);
    }
    public String getExtraInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(weight);
        sb.append(" lbs. @ ");
        sb.append(pricePerPound / 100);
        sb.append(" /lb.");
        return sb.toString();
    }
}
