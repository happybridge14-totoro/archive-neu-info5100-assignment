package q5;
class MyIntHashMap {
  private MyArrayListItem[] buckets;
  public MyIntHashMap() {
    this.buckets = new MyArrayListItem[10001];
  }
  private int getHashKey(int key) {
    return key / 100;
  }
  public void put(int key, int value) {
    int hashKey = getHashKey(key);
    MyArrayListItem head = this.buckets[hashKey];
    if (head == null) {
      this.buckets[hashKey] = new MyArrayListItem(key, value, null);
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
        lastItem.setNext(new MyArrayListItem(key, value, lastItem));
      }
    }
  }
  public void remove(int key) {
    int hashKey = getHashKey(key);
    MyArrayListItem head = this.buckets[hashKey];
    while(head != null) {
      if (head.getKey() == key) {
        if (head.getPre() != null) {
          head.getPre().setNext(head.getNext());
        } else {
          this.buckets[hashKey] = head.getNext();
        }
        if (head.getNext() != null) {
          head.getNext().setPre(head.getPre());
        }
        break;
      }
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
