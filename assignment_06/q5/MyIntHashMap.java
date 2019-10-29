package q5;
class MyIntHashMap {
  private final int MAX_LENGTH = 100;
  private MyArrayListItem[] buckets;
  public MyIntHashMap() {
    this.buckets = new MyArrayListItem[MAX_LENGTH];
  }
  private int getHashKey(int key) {
    return (MAX_LENGTH - 1) & key;
  }
  public void put(int key, int value) {
    int hashKey = getHashKey(key);
    MyArrayListItem head = this.buckets[hashKey];
    if (head == null) {
      this.buckets[hashKey] = new MyArrayListItem(key, value);
    } else {
      boolean foundItem = false;
      MyArrayListItem lastItem = null;
      while(head != null) {
        if (head.getKey() == key) {
          head.setValue(value);
          foundItem = true;
          break;
        }
        lastItem = head;
        head = head.getNext();
      }
      if (!foundItem) {
        lastItem.setNext(new MyArrayListItem(key, value));
      }
    }
  }
  public void remove(int key) {
    int hashKey = getHashKey(key);
    MyArrayListItem head = this.buckets[hashKey];
    MyArrayListItem pre = null;
    while(head != null) {
      if (head.getKey() == key) {
        if (pre != null) {
          pre.setNext(head.getNext());
        } else {
          this.buckets[hashKey] = head.getNext();
        }
        break;
      }
      pre = head;
      head = head.getNext();
    }
  }
  public int get(int key) {
    int hashKey = getHashKey(key);
    MyArrayListItem head = this.buckets[hashKey];
    while(head != null) {
      if (head.getKey() == key) {
        return head.getValue();
      }
      head = head.getNext();
    }
    return -1;
  }
}
