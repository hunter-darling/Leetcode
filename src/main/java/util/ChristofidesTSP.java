package src.main.java.util;

import java.util.*;

public class ChristofidesTSP {
  static final int INF = Integer.MAX_VALUE;
  static final int N = 4;
  static String[] cities = { "A", "B", "C", "D" };
  static int[][] dist = {
      { 0, 2, 9, 10 },
      { 2, 0, 6, 4 },
      { 9, 6, 0, 8 },
      { 10, 4, 8, 0 }
  };

  // Prim’s algorithm for MST
  static List<int[]> primMST() {
    boolean[] visited = new boolean[N];
    int[] key = new int[N];
    int[] parent = new int[N];
    Arrays.fill(key, INF);
    key[0] = 0;
    parent[0] = -1;

    for (int count = 0; count < N - 1; count++) {
      int u = minKey(key, visited);
      visited[u] = true;

      for (int v = 0; v < N; v++) {
        if (dist[u][v] != 0 && !visited[v] && dist[u][v] < key[v]) {
          parent[v] = u;
          key[v] = dist[u][v];
        }
      }
    }

    List<int[]> mst = new ArrayList<>();
    for (int i = 1; i < N; i++) {
      mst.add(new int[] { parent[i], i });
    }
    return mst;
  }

  static int minKey(int[] key, boolean[] visited) {
    int min = INF, minIndex = -1;
    for (int v = 0; v < N; v++) {
      if (!visited[v] && key[v] < min) {
        min = key[v];
        minIndex = v;
      }
    }
    return minIndex;
  }

  // Get nodes with odd degree
  static Set<Integer> getOddDegreeVertices(List<int[]> edges) {
    int[] degree = new int[N];
    for (int[] edge : edges) {
      degree[edge[0]]++;
      degree[edge[1]]++;
    }

    Set<Integer> odd = new HashSet<>();
    for (int i = 0; i < N; i++) {
      if (degree[i] % 2 != 0)
        odd.add(i);
    }
    return odd;
  }

  // Brute-force min-weight perfect matching on odd vertices
  static List<int[]> minMatching(Set<Integer> oddSet) {
    List<Integer> odd = new ArrayList<>(oddSet);
    List<int[]> bestMatch = null;
    int bestWeight = INF;
    permuteMatch(odd, 0, new ArrayList<>(), 0, bestWeight, bestMatch);
    return bestMatching;
  }

  static List<int[]> bestMatching = new ArrayList<>();

  static void permuteMatch(List<Integer> odd, int index, List<int[]> current, int weight, int bestWeight,
      List<int[]> bestMatch) {
    if (odd.isEmpty()) {
      if (weight < bestWeight) {
        bestMatching = new ArrayList<>(current);
      }
      return;
    }

    int a = odd.get(0);
    for (int i = 1; i < odd.size(); i++) {
      int b = odd.get(i);
      List<Integer> remaining = new ArrayList<>(odd);
      remaining.remove(0);
      remaining.remove((Integer) b);
      current.add(new int[] { a, b });
      permuteMatch(remaining, index + 1, current, weight + dist[a][b], bestWeight, bestMatch);
      current.remove(current.size() - 1);
    }
  }

  public static void main(String[] args) {
    List<int[]> mst = primMST();
    System.out.println("MST edges:");
    for (int[] edge : mst)
      System.out.println(cities[edge[0]] + " - " + cities[edge[1]]);

    Set<Integer> odd = getOddDegreeVertices(mst);
    System.out.println("Odd degree vertices: " + odd);

    List<int[]> match = minMatching(odd);
    System.out.println("Matching edges:");
    for (int[] edge : bestMatching)
      System.out.println(cities[edge[0]] + " - " + cities[edge[1]]);

    // Combine MST and matching edges (no actual Euler tour)
    List<int[]> combined = new ArrayList<>(mst);
    combined.addAll(bestMatching);

    // For simplicity, just print the combined cost
    int totalCost = 0;
    for (int[] edge : combined) {
      totalCost += dist[edge[0]][edge[1]];
    }

    System.out.println("Approximate TSP tour cost (MST + Matching): " + totalCost);
  }
}
