package tree;

public class Node<T> {
  T value;
  Node left;
  Node right;

  public Node() {
    this.left = new NullNode();
    this.right = new NullNode();
  }

  public boolean isNull() { return false; }

  public Node getLeft() { return this.left; }
  public Node getRight() { return this.right; }
  public T getValue() { return this.value; }

  public void setLeft(Node left) { this.left = left; }
  public void setRight(Node right) { this.right = right; }
  public void setValue(T value) { this.value = value; }

  public boolean isLeaf() {
    return (this.left instanceof NullNode<T>) &&
      (this.right instanceof NullNode<T>);
  }
}

class NullNode<T> extends Node<T> {
  public final Node left;
  public final Node right;
  public final T value;

  public NullNode() {
    this.left = null;
    this.right = null;
    this.value = null;
  }

  public boolean isNull() { return true; }
  public Node getLeft() { return this.left; }
  public Node getRight() { return this.right; }
  public T getValue() { return this.value; }

  public void setLeft(Node left) { }
  public void setRight(Node right) { }
  public void setValue(T value) { }
}
