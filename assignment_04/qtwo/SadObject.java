package qtwo;


public class SadObject extends MoodyObject {
    final protected String getMood() {
        return "sad";
    }
    final protected void expreeFeelings() {
        System.out.println(" 'wah' 'boo hoo' 'weep' 'sob' 'weep' ");
    }
    public String toString() {
        return "Subject cries a lot";
    }
}
