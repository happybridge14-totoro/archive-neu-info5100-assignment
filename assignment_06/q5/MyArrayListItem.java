package q5;

class MyArrayListItem {
  private MyArrayListItem next;
  private int key;
  private int value;
  public MyArrayListItem(int key,int value) {
    this.key = key;
    this.value = value;
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
  public void setNext(MyArrayListItem next) {
    this.next = next;
  }
}
