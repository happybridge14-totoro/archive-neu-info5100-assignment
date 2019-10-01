package qtwo;


public class PsychiatristObject {
    public void examine(MoodyObject moodyObject) {
        System.out.println("How are you feeling today?");
        moodyObject.queryMood();
        System.out.println();
        moodyObject.expreeFeelings();
    }
    public void observe(MoodyObject moodyObject) {
        System.out.println("Observation: " + moodyObject);
    }
    public static void main(String[] args) {
        PsychiatristObject psychiatrist = new PsychiatristObject();
        HappyObject happy = new HappyObject();
        SadObject sad = new SadObject();

        psychiatrist.examine(happy);
        psychiatrist.observe(happy);
        System.out.println();
        
        psychiatrist.examine(sad);
        psychiatrist.observe(sad);
        System.out.println();
    }
}
