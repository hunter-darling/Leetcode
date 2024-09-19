package src.main.java.solutions;

/**
 * LC 189. Rotate Array
 */
public class RotateArray {
  public void rotate(int[] nums, int k) {
    // // extra array
    // int[] extraArray = new int[nums.length];
    // // iterate and place in extra
    // for (int i = 0; i < nums.length; i++) {
    // extraArray[(i+k)%nums.length] = nums[i];
    // System.out.println(Arrays.toString(extraArray));
    // }
    // // copy array over
    // System.arraycopy(extraArray, 0, nums, 0, extraArray.length);

    // reverse reverse
    k = k % nums.length;

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);

    // int i = 0;
    // int j = nums.length - 1;

    // while (i < j) {
    // nums[i] = nums[j];
    // nums[j] = nums[i];
    // }

  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
      i++;
      j--;
    }
  }
}
