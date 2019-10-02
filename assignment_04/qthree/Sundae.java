package qthree;

class Sundae extends IceCream {
    private String toppingName;
    private int toppingCost;

    public Sundae(String name, int cost, String toppingName, int toppingCost) {
        super(name, cost);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    public int getCost() {
        return super.getCost() + this.toppingCost;
    }
    public String getExtraInfo() {
        return this.toppingName + " Sundao with";
    }
}
