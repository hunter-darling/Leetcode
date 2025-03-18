package src.main.java.solutions;

// import java.util.ArrayDeque;
// import java.util.Queue;

/*
 * LC 542: 01 Matrix
 * Finding shortest distance from each non-zero cell to a zero cell.
 */
public class BinaryMatrix {
  // First attempt, 20/50 test cases passed, needed to do cell-by-cell BFS
  // public int[][] updateMatrix(int[][] mat) {
  // // Check each cell, if 0, mark 0, else, check cells in each direction (up,
  // down,
  // // left, right), and find minimum of sum in each direction?
  // int m = mat.length;
  // int n = mat[0].length;
  // for (int i = 0; i < m; i++) {
  // for (int j = 0; j < n; j++) {
  // if (mat[i][j] == 0) {
  // continue;
  // } else {
  // int cellValue = mat[i][j];
  // int aboveCell = i - 1 >= 0 ? mat[i - 1][j] : 99;
  // int belowCell = i + 1 <= m - 1 ? mat[i + 1][j] : 99;
  // int leftCell = j - 1 >= 0 ? mat[i][j - 1] : 99;
  // int rightCell = j + 1 <= n - 1 ? mat[i][j + 1] : 99;
  // mat[i][j] = mat[i][j] +
  // Math.min(
  // Math.min(aboveCell, belowCell),
  // Math.min(leftCell, rightCell));
  // }
  // }
  // }
  // return mat;
  // }

  // Second attempt, after some helpful studying
  // public int[][] updateMatrix(int[][] mat) {
  // // For easier directional checking
  // int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
  // int m = mat.length;
  // int n = mat[0].length;
  // // Create queue for BFS
  // Queue<Pair<Integer, Integer>> cue = new ArrayDeque<>();
  // // Iterate through, add to queue or set to big value
  // for (int i = 0; i < m; i++) {
  // for (int j = 0; j < n; j++) {
  // if (mat[i][j] == 0) {
  // cue.add(new Pair<>(i, j));
  // } else {
  // mat[i][j] = 1000000;
  // }
  // }
  // }
  // // BFS
  // while (!cue.isEmpty()) {
  // final int i = cue.peek()[0];
  // final int j = cue.poll().getValue();
  // for (int[] dir : directions) {
  // final int x = i + dir[0];
  // final int y = j + dir[1];
  // if (x < 0 || x == m || y < 0 || y == n) {
  // continue;
  // }
  // // System.out.println("i:" + i + " j:" + j);
  // // System.out.println("x:" + x + " y:" + y);
  // // System.out.println(i+","+j+": " + mat[i][j]);
  // // System.out.println(x+","+y+": " + mat[x][y]);
  // if (mat[x][y] <= mat[i][j] + 1) {
  // continue;
  // }
  // // If x,y is 1000000, add the coordinates to the queue and set value to
  // current
  // // node + 1, i.e. we have found an edge to add to the distance from 0
  // cue.offer(new Pair<>(x, y));
  // mat[x][y] = mat[i][j] + 1;
  // }
  // }
  // return mat;
  // }
}
