package src.main.java.solutions;

/**
 * LC 70. Climbing Stairs
 */
public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }
    int a = 1;
    int b = 1;
    int c;
    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    return b;
  }
}
