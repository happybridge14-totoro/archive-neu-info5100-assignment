package q3;
import java.util.HashMap;

class Test {
  public static boolean isAnagram(String s, String t) {
    if (s.length() == t.length()) {
      char[] charAry = s.toCharArray();
      HashMap<String, Integer> tmp = new HashMap<String, Integer>();
      for (char i : charAry) {
        String key = Character.toString(i);
        Integer val = tmp.get(key);
        int count = val == null ? 0 : val;
        tmp.put(key.toString(), ++count);
      }
      charAry = t.toCharArray();
      for (char i : charAry) {
        String key = Character.toString(i);
        Integer val = tmp.get(key);
        if (val == null || val <= 0) {
          return false;
        }
        tmp.put(key, --val);
      }
      return true;
    } else {
      return false;
    }
  }
  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaram";
    System.out.println("s='anagram', t='nagaram', expect: true");
    System.out.println(Test.isAnagram(s, t));
    s = "rat";
    t = "car";
    System.out.println("s='rat', t='car', expect: false");
    System.out.println(Test.isAnagram(s, t));
    s = "anagram";
    t = "nagarnm";
    System.out.println("s='anagram', t='nagarnm', expect: false");
    System.out.println(Test.isAnagram(s, t));
  }
}
