package src.main.java.solutions;

public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    // Pixel we start on should not be the same color as the color we are "filling"
    if (image[sr][sc] == color)
      return image;
    // DFS, any 4-directionally adjacent pixels with "color" matching our starting
    // color get filled
    fill(image, sr, sc, image[sr][sc], color);
    return image;
  }

  private void fill(int[][] image, int sr, int sc, int startColor, int newColor) {
    if (sr < 0 ||
        sc < 0 ||
        sr >= image.length ||
        sc >= image[0].length ||
        image[sr][sc] != startColor) {
      return;
    }
    image[sr][sc] = newColor;
    // Recursion!
    fill(image, sr - 1, sc, startColor, newColor);
    fill(image, sr + 1, sc, startColor, newColor);
    fill(image, sr, sc - 1, startColor, newColor);
    fill(image, sr, sc + 1, startColor, newColor);
  }
}
