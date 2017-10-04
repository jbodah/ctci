public class Q2 {
  public static void main(String[] args) {
    String input = args[0];
    char[] chars = input.toCharArray();
    char[] charsOut = reverse(chars);
    for (char c : charsOut) {
      System.out.printf("%c\n", c);
    }
  }

  public static char[] reverse(char[] chars) {
    int len = chars.length;
    char[] reversed = new char[len];
    for (int idx = len - 1 ; idx >= 0 ; idx--) {
      int j = len - 1 - idx;
      reversed[j] = chars[idx];
    }
    return reversed;
  }
}
