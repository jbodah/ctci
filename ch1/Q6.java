public class Q6 {
  static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public void moveUp() {
      this.y -= 1;
    }

    public void moveDown() {
      this.y += 1;
    }

    public void moveLeft() {
      this.x -= 1;
    }

    public void moveRight() {
      this.x += 1;
    }

    public int getX() {
      return this.x;
    }

    public int getY() {
      return this.y;
    }
  }

  static class Image {
    int[][] img;

    public Image(int[][] img) {
      this.img = img;
    }

    public int valueAt(Point p) {
      return this.img[p.getY()][p.getX()];
    }

    public void setValueAt(Point p, int val) {
      this.img[p.getY()][p.getX()] = val;
    }

    public int[][] getImg() {
      return this.img;
    }

    public int length() {
      return this.img.length;
    }
  }

  public static void main(String[] argv) {
    int[][] img =
      {
        {1, 1, 0, 1},
        {0, 0, 1, 1},
        {0, 0, 0, 0},
        {0, 1, 1, 0}
      };

    printImage(img);

    int[][] newImg = rotateImage(new Image(img));

    printImage(newImg);
  }

  static void printImage(int[][] img) {
    for(int[] row : img) {
      System.out.println("");
      for(int d : row) {
        System.out.printf("%d ", d);
      }
    }
    System.out.println("");
  }

  static int[][] rotateImage(Image img) {
    int numLayers = img.length() / 2;
    int maxX = img.length() - 1;
    int maxY = img.length() - 1;

    for(int layerIdx = 0; layerIdx < numLayers; layerIdx++) {
      Point northIdx = new Point(layerIdx, layerIdx);
      Point westIdx = new Point(layerIdx, maxY - layerIdx);
      Point southIdx = new Point(maxX - layerIdx, maxY - layerIdx);
      Point eastIdx = new Point(maxX - layerIdx, layerIdx);

      System.out.println("maxX - 2 * layerIdx - 1 = " + (maxX - 2 * layerIdx - 1));
      for(int n = 0; n < maxX - 2 * layerIdx; n++) {
        int tmp = img.valueAt(northIdx);
        img.setValueAt(northIdx, img.valueAt(westIdx));
        img.setValueAt(westIdx, img.valueAt(southIdx));
        img.setValueAt(southIdx, img.valueAt(eastIdx));
        img.setValueAt(eastIdx, tmp);

        northIdx.moveRight();
        westIdx.moveUp();
        southIdx.moveLeft();
        eastIdx.moveDown();

        System.out.println("After n " + n);
        printImage(img.getImg());
      }

      System.out.println("After layer " + layerIdx);
      printImage(img.getImg());
    }

    return img.getImg();
  }
}
