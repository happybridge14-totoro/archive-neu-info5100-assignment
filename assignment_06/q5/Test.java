package q5;

class Test {
  public static void main(String[] args) {
    MyIntHashMap t1 = new MyIntHashMap();
    t1.put(1,4);
    System.out.println("put(1,4)");
    System.out.println("get(1), Expect: 4");
    System.out.println(t1.get(1));
    t1.put(1,5);
    System.out.println("put(1,5)");
    t1.put(2,10);
    System.out.println("put(2,10)");
    t1.put(3,1000);
    System.out.println("put(3,1000)");
    t1.put(5,3);
    System.out.println("put(5,3)");
    t1.put(10000,3);
    System.out.println("put(10000,3)");
    t1.put(10001,3);
    System.out.println("put(10001,3)");
    System.out.println("get(1), Expect: 5");
    System.out.println(t1.get(1));
    System.out.println("get(2), Expect: 10");
    System.out.println(t1.get(2));
    System.out.println("get(3), Expect: 1000");
    System.out.println(t1.get(3));
    System.out.println("get(4), Expect: -1");
    System.out.println(t1.get(4));
    System.out.println("get(5), Expect: 3");
    System.out.println(t1.get(5));
    System.out.println("get(10000), Expect: 3");
    System.out.println(t1.get(10000));
    System.out.println("get(10001), Expect: 3");
    System.out.println(t1.get(10001));
    System.out.println("get(10002), Expect: -1");
    System.out.println(t1.get(10002));
    System.out.println("remove(2)");
    t1.remove(2);
    System.out.println("get(1), Expect: 5");
    System.out.println(t1.get(1));
    System.out.println("get(1), Expect: -1");
    System.out.println(t1.get(2));
    System.out.println("get(1), Expect: 1000");
    System.out.println(t1.get(3));
    System.out.println("-------Test cases provided by assignment---------");
    MyIntHashMap t2 = new MyIntHashMap();
    t2.put(1, 1);
    t2.put(2, 2);
    System.out.println(t2.get(1));
    System.out.println(t2.get(3));
    t2.put(2, 1);
    System.out.println(t2.get(2));
    t2.remove(2);
    System.out.println(t2.get(2));
  }
}
