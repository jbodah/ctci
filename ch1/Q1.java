import java.util.HashSet;

public class Q1 {
  public static void main(String[] args) {
    String input = args[0];
    HashSet<Character> seen = new HashSet<Character>();

    for (Character c : input.toCharArray()) {
      if (seen.contains(c)) {
        System.exit(1);
      }
      else {
        seen.add(c);
      }
    }

    System.exit(0);
  }
}
