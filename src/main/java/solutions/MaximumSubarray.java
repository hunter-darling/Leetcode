package src.main.java.solutions;

public class MaximumSubarray {
  // initial solution, 210/210 test cases, but slow as all hell
  // public int maxSubArray(int[] nums) {
  // int left = 0;
  // int right = 0;
  // int sum = nums[left];
  // int maxSum = sum;
  // while (right < nums.length - 1) {
  // right++;
  // if (sum < 0 && sum < nums[right]) {
  // left = right;
  // sum = 0;
  // }
  // sum = sum + nums[right];
  // if (sum > maxSum) {
  // maxSum = sum;
  // }
  // }
  // return maxSum;
  // }

  // Optimized solution
  public int maxSubArray(int[] nums) {
    int sum = 0;
    int maxSum = nums[0];
    for (int i : nums) {
      if (sum < 0) {
        sum = 0;
      }
      sum += i;
      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }
}
