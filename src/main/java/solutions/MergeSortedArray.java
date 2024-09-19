package src.main.java.solutions;

/**
 * LC 88. Merge Sorted Array
 */
public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    // last element in nums1
    int k = m + n - 1;

    // merge from back to front
    while (j >= 0 && i >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        i--;
      } else {
        nums1[k] = nums2[j];
        j--;
      }
      k--;
    }

    // fill nums1 w/ remaining elements, if any
    while (j >= 0) {
      nums1[k] = nums2[j];
      j--;
      k--;
    }
  }
}
