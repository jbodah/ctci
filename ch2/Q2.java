import list.Node;

public class Q2 {
  public static void main(String[] argv) throws Exception {
    Node list = new Node(1);
    list.appendToTail(new Node(2));
    list.appendToTail(new Node(3));
    list.appendToTail(new Node(4));
    list.appendToTail(new Node(5));
    list.appendToTail(new Node(6));
    list.appendToTail(new Node(7));
    list.appendToTail(new Node(8));

    int n = Integer.parseInt(argv[0]);

    Node nth = nthFromLast(list, n);
    System.out.println(nth.getValue());
  }

  static Node nthFromLast(Node list, int n) throws Exception {
    Node head = list;
    Node runner = list;
    while(n > 0) {
      if (runner == null) { throw new Exception("n too big"); }
      runner = runner.next();
      n--;
    }
    while(runner != null) {
      head = head.next();
      runner = runner.next();
    }
    return head;
  }
}
