package src.main.java.solutions;

// import java.util.ArrayDeque;
// import java.util.List;
// import java.util.Queue;

public class NumberOfIslands {
  // BFS, I cheated a bit, but I knew the general setup
  // public int numIslands(char[][] grid) {
  // if (grid.length == 0) {
  // return 0;
  // }
  // int islands = 0;
  // int h = grid.length;
  // int w = grid[0].length;
  // for (int i = 0; i < h; i++) {
  // for (int j = 0; j < w; j++) {
  // if (grid[i][j] == '1') {
  // bfs(i, j, grid);
  // islands++;
  // }
  // }
  // }
  // return islands;
  // }

  // private static final int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, {
  // -1, 0 } };

  // private void bfs(int i, int j, char[][] grid) {
  // Queue<Pair<Integer, Integer>> cue = new ArrayDeque<>(List.of(new Pair<>(i,
  // j)));
  // grid[i][j] = 'v';
  // // While queue not empty, expanding island
  // while (!cue.isEmpty()) {
  // final int q = cue.peek().getKey();
  // final int r = cue.poll().getValue();
  // for (int[] dir : directions) {
  // final int x = q + dir[0];
  // final int y = r + dir[1];
  // if (x < 0 || x == grid.length || y < 0 || y == grid[0].length)
  // continue;
  // if (grid[x][y] != '1')
  // continue;
  // cue.offer(new Pair<>(x, y));
  // grid[x][y] = 'v';
  // }
  // }
  // }
}
