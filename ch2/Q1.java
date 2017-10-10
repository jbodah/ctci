import java.util.HashMap;

public class Q1 {
  static class Node {
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

  public static void main(String[] argv) {
    Node list = new Node(1);
    list.appendToTail(new Node(2));
    list.appendToTail(new Node(1));
    list.appendToTail(new Node(3));
    list.appendToTail(new Node(5));
    list.appendToTail(new Node(5));
    list.appendToTail(new Node(1));
    list.appendToTail(new Node(5));
    printList(list);

    Node newList = removeDupesWithBuffer(list);
    printList(newList);
  }

  static Node removeDupesWithBuffer(Node list) {
    HashMap<Integer, Boolean> seen = new HashMap<Integer, Boolean>();
    Node prev = null;
    Node current = list;

    while(current != null) {
      int value = current.getValue();
      if (seen.containsKey(value)) {
        prev.setNext(current.next());
        current = current.next();
      } else {
        seen.put(value, true);
        prev = current;
        current = current.next();
      }
    }

    return list;
  }

  static void printList(Node n) {
    if (n == null) {
      puts();
    } else {
      puts(n.getValue());
      printList(n.next());
    }
  }

  static void puts() {
    System.out.println();
  }
  static void puts(int n) {
    System.out.printf("%d\n", n);
  }
  static void puts(String str) {
    System.out.println(str);
  }
}
