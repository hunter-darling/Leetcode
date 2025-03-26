package src.main.java.solutions;

/*
 * LC 238. Product of Array Except Self
 */
public class ProductExceptSelf {
  // First try?? I actually fully understood this one!
  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] answer = new int[len];

    // build arrays to hold each product to the 'left' and 'right' of each index
    int[] left = new int[len];
    int[] right = new int[len];

    left[0] = 1;
    right[len - 1] = 1;

    for (int i = 1; i < len; i++) {
      left[i] = nums[i - 1] * left[i - 1];
    }
    for (int i = len - 2; i >= 0; i--) {
      right[i] = nums[i + 1] * right[i + 1];
    }

    for (int i = 0; i < len; i++) {
      answer[i] = left[i] * right[i];
    }

    return answer;
  }
}
