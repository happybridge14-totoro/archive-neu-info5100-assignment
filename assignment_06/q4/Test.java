package q4;
import java.util.HashMap;
class Test {
  public static boolean uniqueOccurrences(int[] arr) {
    HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
    for (int i : arr) {
      Integer value = tmp.get(i);
      if (value == null) {
        tmp.put(i, 1);
      } else {
        tmp.put(i, ++value);
      }
    }
    HashMap<Integer, Integer> ret = new HashMap<Integer, Integer>();
    for(HashMap.Entry<Integer, Integer> entry: tmp.entrySet()) {
      int newKey = entry.getValue();
      if (ret.get(newKey) != null) {
        return false;
      } else {
        ret.put(newKey, 1);
      }
    }
    return true;
  }
  public static void main(String[] args) {
    int[] testAry = {1,2,2,1,1,3};
    System.out.println("[1,2,2,1,1,3], expect: true");
    System.out.println(Test.uniqueOccurrences(testAry));
    int[] testAry1 = {1,2};
    System.out.println("[1,2], expect: false");
    System.out.println(Test.uniqueOccurrences(testAry1));
    int[] testAry2 = {-3,0,1,-3,1,1,1,-3,10,0};
    System.out.println("[-3,0,1,-3,1,1,1,-3,10,0], expect: true");
    System.out.println(Test.uniqueOccurrences(testAry2));
    int[] testAry3 = {2,2,2,2,2, -1, -1 , -4, 3,3,3,3,3};
    System.out.println("[2,2,2,2,2, -1, -1 , -4, 3,3,3,3,3], expect: false");
    System.out.println(Test.uniqueOccurrences(testAry3));
  }
}
