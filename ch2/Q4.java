import list.Node;

public class Q4 {
  public static void main(String[] args) {
    Node first = Node.build(3, 1, 5);
    Node second = Node.build(5, 9, 2);

    Node addition = addNodes(first, second);
    addition.print();

    if (Node.build(8, 0, 8).eql(addition)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }

  static Node addNodes(Node a, Node b) {
    Node headA = a;
    Node headB = b;
    Node acc = null;
    int carry = 0;

    while(headA != null && headB != null) {
      int result = headA.getValue() + headB.getValue() + carry;
      if (result < 10) {
        carry = 0;
        if (acc == null) {
          acc = new Node(result);
        } else {
          acc.appendToTail(new Node(result));
        }
      } else {
        int remainder = result % 10;
        carry = result / 10;
        acc.appendToTail(new Node(remainder));
      }
      headA = headA.next();
      headB = headB.next();
    }

    return acc;
  }

  static void puts(String str) { System.out.println(str); }
}
