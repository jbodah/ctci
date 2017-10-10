import java.util.HashMap;

public class Q4 {
  public static void main(String[] args) {
    // TODO: handle edge cases w input
    String left = args[0];
    String right = args[1];

    HashMap<Character, Integer> freqMap = new HashMap<Character, Integer>();

    left.chars().forEach(i -> {
      Character c = (char) i;
      if (freqMap.containsKey(c)) {
        int val = freqMap.get(c);
        freqMap.put(c, val + 1);
      } else {
        freqMap.put(c, 1);
      }
    });

    for (char c : right.toCharArray()) {
      if (freqMap.containsKey(c)) {
        int val = freqMap.get(c);
        if (val == 0) {
          System.out.println("false");
          return;
        }
        freqMap.put(c, val - 1);
      } else {
        System.out.println("false");
        return;
      }
    };

    if (freqMap.entrySet().stream().map(e -> e.getValue()).allMatch(v -> v == 0)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
