package src.main.java.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
  public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    // Count fresh oranges
    int fresh = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          fresh++;
        } else if (grid[i][j] == 2) {
          queue.offer(new int[] { i, j });
        }
      }
    }
    int time = 0;
    int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    // BFS
    while (!queue.isEmpty() && fresh > 0) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] current = queue.poll();
        for (int[] direction : DIRS) {
          int newRow = current[0] + direction[0];
          int newCol = current[1] + direction[1];
          if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
              && grid[newRow][newCol] == 1) {
            grid[newRow][newCol] = 2;
            queue.offer(new int[] { newRow, newCol });
            fresh--;
          }
        }
      }
      time++;
    }
    return fresh == 0 ? time : -1;
  }
}
