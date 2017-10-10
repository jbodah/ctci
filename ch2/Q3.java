import list.Node;

public class Q3 {
  public static void main(String[] args) {
    Node list = new Node('a');
    list.appendToTail(new Node('b'));
    Node node = new Node('c');
    list.appendToTail(node);
    list.appendToTail(new Node('d'));
    list.appendToTail(new Node('e'));
    printList(list);

    removeNode(node);
    printList(list);
  }

  static void removeNode(Node node) {
    Node next = node.next();
    Node lookahead = next.next();
    node.setValue(next.getValue());
    node.setNext(lookahead);
  }

  static void printList(Node node) {
    while(node != null) {
      System.out.printf("%d ", node.getValue());
      node = node.next();
    }

    System.out.println();
  }
}
