import java.util.Arrays;

public class Q3 {
  public static void main(String[] argv) {
    String input = argv[0];
    char[] out = memEfficientRemoveDupes(input.toCharArray());
    String str = new String(out);
    System.out.println(str);
  }

  private static char[] memEfficientRemoveDupes(char[] chars) {
    boolean[] bitMap = new boolean[256];
    int nextIdx = 0;

    for(int i = 0; i < chars.length; i++) {
      char c = chars[i];
      int ascii = atoi(c);
      if (bitMap[ascii] == true) {
        // do nothing
      } else {
        bitMap[ascii] = true;
        if (i == nextIdx) {
          nextIdx++;
        } else {
          chars[nextIdx] = chars[i];
          nextIdx++;
        }
      }
    }

    // chars[nextIdx] = '\0';

    // return chars;

    // Hack to make java work with null-terminated strings
    return Arrays.copyOfRange(chars, 0, nextIdx);
  }

  private static Integer atoi(char c) {
    return (int) c;
  }
}
