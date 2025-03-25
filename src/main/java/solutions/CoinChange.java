package src.main.java.solutions;

import java.util.Arrays;

public class CoinChange {
  // First solution, greedy, failure
  public int coinChangeV1(int[] coins, int amount) {
    int count = 0;
    int temp = amount;
    Arrays.sort(coins);
    for (int i = coins.length - 1; i >= 0; i--) {
      while (temp > 0) {
        if (temp - coins[i] < 0) {
          break;
        } else {
          temp = temp - coins[i];
          System.out.println(temp);
          count++;
        }
      }
    }
    if (temp != 0) {
      return -1;
    }
    return count;
  }

  // Second solution, bottom-up DP
  public int coinChangeV2(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    // dp[i] = amount of coins needed to make some amount i
    Arrays.fill(dp, 1, dp.length, amount + 1);
    for (int i = 0; i < amount + 1; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        }
      }
    }
    return dp[amount] != amount + 1 ? dp[amount] : -1;
  }
}
