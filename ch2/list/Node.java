package list;

public class Node {
  Node next;
  Node tail;
  int value;

  public Node(int value) {
    this.value = value;
    this.next = null;
    this.tail = null;
  }

  public void appendToTail(Node node) {
    if (this.next == null) {
      this.next = node;
      this.tail = node;
    } else {
      this.tail.appendToTail(node);
      this.tail = node;
    }
  }

  public Node next() {
    return this.next;
  }

  public int getValue() {
    return this.value;
  }

  public void setNext(Node node) {
    this.next = node;
  }
}
