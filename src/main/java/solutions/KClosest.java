package src.main.java.solutions;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
  public int[][] kClosest(int[][] points, int k) {
    Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(distance(a), distance(b)));
    for (int[] point : points) {
      maxHeap.offer(point);
    }
    int[][] kClosest = new int[k][2];
    for (int i = 0; i < k; i++) {
      kClosest[i] = maxHeap.poll();
    }
    return kClosest;
  }

  private Double distance(int[] point) {
    return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
  }
}
