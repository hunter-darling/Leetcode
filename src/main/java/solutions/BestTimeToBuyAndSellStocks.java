package src.main.java.solutions;

/**
 * LC 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStocks {
  // First submission: time limit exceeded, passed 203/212
  // public int maxProfit(int[] prices) {
  // int maxProfit = 0;
  // for (int i = 0; i < prices.length; i++) {
  // for (int j = i + 1; j < prices.length; j++) {
  // if (prices[j] - prices[i] > maxProfit) {
  // maxProfit = prices[j] - prices[i];
  // }
  // }
  // }
  // return maxProfit;
  // }

  // Second submission, straight up wrong, passed 186/212
  // public int maxProfit(int[] prices) {
  // int buy = 0;
  // int sell = 1;
  // int maxProfit = 0;
  // while (sell < prices.length) {
  // if (prices[buy] < prices[sell]) {
  // if (maxProfit < prices[sell] - prices[buy]) {
  // maxProfit = prices[sell] - prices[buy];
  // }
  // } else {
  // buy++;
  // }
  // sell++;
  // }
  // return maxProfit;
  // }

  // Needed to shift left boundary (buy) to right boundary (sell)
  // Third submission, 212/212, success! But it's slow as hell...
  public int maxProfit(int[] prices) {
    int buy = 0;
    int sell = 1;
    int maxProfit = 0;
    while (sell < prices.length) {
      if (prices[buy] < prices[sell]) {
        if (maxProfit < prices[sell] - prices[buy]) {
          maxProfit = prices[sell] - prices[buy];
        }
      } else {
        buy = sell;
      }
      sell++;
    }
    return maxProfit;
  }
}
