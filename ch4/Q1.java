import tree/Node;

public class Q1 {
  public static void main(String[] args) {
    Node<Integer> tree = new Node<Integer>();
    if (!treeIsBalanced(tree)) {
      throw new Exception("err");
    }
  }

  static boolean treeIsBalanced(Node<Integer> tree) {
    // get all leaves
    // get depth of each leaf
    // assert max/min depth within 1 of each other
    Integer[] depths = eachLeaf.map(leaf -> leaf.depth);

    max_min =
      depths.reduce({null, null}, depth, max_min -> {
        Integer max = max_min[0];
        Integer min = max_min[1];

        if (max == null || max < depth) {
          max = depth;
        }

        if (min == null || min < depth) {
          min = depth;
        }

        {max, min}
      );

      // assert max - min <= 1
  }

  // TODO
  static List<Node<Integer>> eachLeaf(Node tree) {
    return findLeaves(tree, 0);
  }

  // TODO
  static List<Node<Integer>> findLeaves(Node tree, Integer depth) {
    if (tree.isLeaf()) {
      Leaf leaf = new Leaf(tree, depth);
      return List<Leaf> = new List<Leaf>([leaf])
    }

    return findLeaves(tree.getLeft(), depth + 1).concat(
        findLeaves(tree.getRight(), depth + 1));
  }
}

class Leaf extends Node<Integer> {
  public final Node left;
  public final Node right;
  public final Integer value;
  public final Integer depth;

  public Leaf(Node tree, Integer depth) {
    this.left = tree.getLeft();
    this.right = tree.getRight();
    this.value = tree.getValue();
    this.depth = depth;
  }
}
