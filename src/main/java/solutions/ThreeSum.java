package src.main.java.solutions;

import java.util.ArrayList;
import java.util.Arrays;
// import java.util.HashSet;
import java.util.List;
// import java.util.Set;

public class ThreeSum {
  // First solution, 254/314 test cases passed, time limit exceeded (i mean, it's
  // O(n^3))
  // public List<List<Integer>> threeSum(int[] nums) {
  // List<List<Integer>> result = new ArrayList<>();
  // List<Set<Integer>> usedTriplets = new ArrayList<>();
  // for (int i = 0; i < nums.length; i++) {
  // for (int j = 0; j < nums.length; j++) {
  // for (int k = 0; k < nums.length; k++) {
  // if (nums[i] + nums[j] + nums[k] == 0 &&
  // i != j && i != k && j != k) {
  // Set<Integer> triplet = new HashSet<>();
  // triplet.add(nums[i]);
  // triplet.add(nums[j]);
  // triplet.add(nums[k]);
  // if (!usedTriplets.contains(triplet)) {
  // List<Integer> validTriplet = Arrays.asList(nums[i], nums[j], nums[k]);
  // result.add(validTriplet);
  // usedTriplets.add(triplet);
  // }
  // }
  // }
  // }
  // }
  // return result;
  // }

  // Second solution, sort nums forst, use more pointers and less loops
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
      // If we have already encountered an element at current i, skip it
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int tripletSum = nums[i] + nums[left] + nums[right];
        if (tripletSum == 0) {
          result.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
          // Shrink window as we encounter duplicates
          while (left < right && nums[left] == nums[left - 1])
            left++;
          while (left < right && nums[right] == nums[right + 1])
            right--;
          // Move left pointer forward
        } else if (tripletSum < 0) {
          left++;
          // Or move right pointer back
        } else {
          right--;
        }
      }
    }
    return result;
  }
}
