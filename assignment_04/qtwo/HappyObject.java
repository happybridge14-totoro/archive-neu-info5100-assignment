package qtwo;


public class HappyObject extends MoodyObject {
    final protected String getMood() {
        return "happy";
    }
    final protected void expreeFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }
    public String toString() {
        return "Subject laughs a lot";
    }
}
