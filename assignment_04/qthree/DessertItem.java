package qthree;

abstract class DessertItem {
    protected String name;
    public DessertItem() { }
    public final String getName() {
        return this.name;
    }
    abstract int getCost();
    abstract String getUnitInfo();
}
