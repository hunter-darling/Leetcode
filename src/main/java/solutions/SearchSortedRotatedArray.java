package src.main.java.solutions;

public class SearchSortedRotatedArray {
  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      final int mid = (low + high) / 2;
      if (nums[mid] == target)
        return mid;
      if (nums[low] <= nums[mid]) {
        // 'lower half'
        if (nums[low] <= target && target < nums[mid]) {
          // move the upper bound down
          high = mid - 1;
        } else {
          // move the lower bound up
          low = mid + 1;
        }
      } else {
        // 'upper half'
        if (nums[mid] < target && target <= nums[high]) {
          // move the lower bound up
          low = mid + 1;
        } else {
          // move the upper bound down
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}