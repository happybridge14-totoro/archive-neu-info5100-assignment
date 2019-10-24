package q5;

class MyArrayListItem {
  private MyArrayListItem next;
  private MyArrayListItem pre;
  private int key;
  private int value;
  public MyArrayListItem(int key,int value, MyArrayListItem pre) {
    this.key = key;
    this.value = value;
    this.pre = pre;
    this.next = null;
  }
  public int getKey() {
    return key;
  }
  public int getValue() {
    return value;
  }
  public void setValue(int value) {
    this.value = value;
  }
  public MyArrayListItem getNext() {
    return next;
  }
  public MyArrayListItem getPre() {
    return pre;
  }
  public void setNext(MyArrayListItem next) {
    this.next = next;
  }
  public void setPre(MyArrayListItem pre) {
    this.pre = pre;
  }
}
