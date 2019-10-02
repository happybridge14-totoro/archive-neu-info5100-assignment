package qthree;

class IceCream extends DessertItem {
    private int cost;
    public IceCream(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    public int getCost() {
        return this.cost;
    }
}
