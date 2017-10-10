import java.util.function.Predicate;

public class Q7 {
  public static void main(String[] argv) {
    int[][] matrix = {
      {1, 1, 1, 1},
      {1, 1, 0, 1},
      {1, 1, 1, 1},
      {1, 0, 1, 1},
      {1, 1, 1, 1}
    };

    printMatrix(matrix);

    int[][] outMatrix = zeroOutRowAndColumnIf(matrix, n -> n == 0);

    printMatrix(outMatrix);
  }

  static void printMatrix(int[][] matrix) {
    for(int row[] : matrix) {
      System.out.println();
      for(int i : row) {
        System.out.printf("%d ", i);
      }
    }
    System.out.println();
  }

  static int[][] zeroOutRowAndColumnIf(int[][] matrix, Predicate<Integer> predicate) {
    int[][] newMatrix = new int[matrix.length][matrix[0].length];
    boolean[][] cache = new boolean[matrix.length][matrix[0].length];

    for(int j = 0; j < matrix.length; j++) {
      for(int i = 0; i < matrix[0].length; i++) {
        if (cache[j][i]) {
          continue;
        }

        int value = matrix[j][i];

        if (predicate.test(value)) {
          System.out.println("test pass");
          for(int tmp = 0; tmp < matrix[0].length; tmp++) {
            newMatrix[j][tmp] = 0;
            cache[j][tmp] = true;
          }

          for(int tmp = 0; tmp < matrix.length; tmp++) {
            newMatrix[tmp][i] = 0;
            cache[tmp][i] = true;
          }
        } else {
          newMatrix[j][i] = value;
        }

        printMatrix(newMatrix);
      }
    }

    return newMatrix;
  }
}
