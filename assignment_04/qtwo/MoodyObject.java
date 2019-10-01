package qtwo;


abstract class MoodyObject {
    protected abstract String getMood();
    protected abstract void expreeFeelings();
    public void queryMood() {
        System.out.println("I feel " + this.getMood() + " today!");
    };
}
