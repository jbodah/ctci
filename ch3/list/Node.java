package list;

public class Node {
  Node next;
  Node tail;
  Object value;

  public static Node build(Object ...args) {
    Node acc = null;
    for (Object value : args) {
      if (acc == null) {
        acc = new Node(value);
      } else {
        acc.appendToTail(new Node(value));
      }
    }
    return acc;
  }

  public Node(Object value) {
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

  public boolean eql(Node other) {
    if (this.getValue() == other.getValue()) {
      if (this.next() == null && other.next() == null) {
        return true;
      } else {
        return this.next().eql(other.next());
      }
    } else {
      return false;
    }
  }

  public Object getValue() {
    return this.value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public void setNext(Node node) {
    this.next = node;
  }

  public void print() {
    Node node = this;
    while (node != null) {
      System.out.printf("%d ", node.getValue());
      node = node.next();
    }

    System.out.println();
  }
}
