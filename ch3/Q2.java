import list.Node;

public class Q2 {
  static class MinStack {
    Node top;

    public void push(int obj) {
      if (this.top != null) {
        int prevMin = extractMin(this.top);
        int[] newTuple = {obj, Math.min(obj, prevMin)};
        Node n = new Node(newTuple);
        n.setNext(this.top);
        this.top = n;
      } else {
        int[] newTuple = {obj, obj};
        this.top = new Node(newTuple);
      }
    }

    public int pop() {
      if (this.top != null) {
        int obj = extractValue(this.top);
        this.top = this.top.next();
        return obj;
      } else {
        return -1;
      }
    }

    public int min() {
      if (this.top != null) {
        return extractMin(this.top);
      } else {
        return -1;
      }
    }

    public void print() {
      this.top.print();
    }

    private int extractValue(Node n) {
      return extractValue(n.getValue());
    }
    private int extractValue(int[] tuple) {
      return tuple[0];
    }

    private int extractMin(Node n) {
      return extractMin(n.getValue());
    }
    private int extractMin(int[] tuple) {
      return tuple[1];
    }
  }

  public static void main(String[] args) {
    MinStack s = new MinStack();

    puts("Push 3 => [3]");
    s.push(3);
    s.print();

    puts("Min => 3");
    puts(s.min());

    puts("Push 2 => [3, 2]");
    s.push(2);
    s.print();

    puts("Min => 2");
    puts(s.min());

    puts("Pop => [3]");
    s.pop();
    s.print();

    puts("Min => 3");
    puts(s.min());
  }

  private static void puts(Object o) { puts("" + o.toString); }
  private static void puts(String s) { System.out.println(s); }
}
