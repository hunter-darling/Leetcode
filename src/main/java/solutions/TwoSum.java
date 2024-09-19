package src.main.java.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 1. Two Sum
 */
public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numToIndexMap = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      if (numToIndexMap.containsKey(target - nums[i]))
        return new int[] { numToIndexMap.get(target - nums[i]), i };
      numToIndexMap.put(nums[i], i);
    }
    return null;
  }
}
