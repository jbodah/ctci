public class Q5 {
  public static void main(String[] args) {
    String input = args[0];
    StringBuilder builder = new StringBuilder();

    input.chars().forEach(i -> {
      char c = (char) i;
      if (c == ' ') {
        builder.append("%20");
      } else {
        builder.append(c);
      }
    });

    System.out.println(builder.toString());
  }
}
