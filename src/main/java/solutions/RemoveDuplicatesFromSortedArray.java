package src.main.java.solutions;

import java.util.Arrays;

/**
 * LC 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    // two pointers,
    // first scans through the array,
    // second is pointed at the position we want to move the next discovered unique
    // value to

    // first pointer
    int i = 0;
    // second pointer
    for (final int num : nums)
      if (i < 1 || num > nums[i - 1]) {
        nums[i++] = num;
      }
    System.out.println(Arrays.toString(nums));
    return i;
  }
}
