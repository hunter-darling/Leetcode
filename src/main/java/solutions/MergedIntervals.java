package main.java.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergedIntervals {
  public int[][] merge(int[][] intervals) {
    if (intervals.length == 1){
      return intervals;
    }
  
    // Sort - allows us to check bounds more easily
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> merged = new ArrayList<>();
    int[] current = intervals[0];
    merged.add(current);

    for (int[] interval : intervals) {
      int currentEnd = current[1];
      int nextStart = interval[0];
      int nextEnd = interval[1];

      if (nextStart <= currentEnd) {
        // Overlap - merge intervals, use max of the 2 upper bounds
        current[1] = Math.max(currentEnd, nextEnd);
      } else {
        // No more overlap, move to next interval and add to "merged"
        // We will still have a pointer to it via "current", so we can edit it in place in the "merged" List
        current = interval;
        merged.add(current);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
  
  // Potential improvement: edit in place?
  public int[][] mergeInPlace(int[][] intervals) {
    if (intervals.length == 1) {
      return intervals;
    }

    // Sort
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    // Will point to last merged interval
    int index = 0;

    for (int i = 1; i < intervals.length; i++) {
      // Overlap
      if (intervals[index][1] >= intervals[i][0]) {
        // Merge by updating end of current interval
        intervals[index][1] = Math.max(intervals[i][1], intervals[index][1]);
      } else {
        // Move "index" pointer to next position and copy current interval to "index" index
        index++;
        intervals[index] = intervals[i];
      }
    }
    // Copy only merged subarray of "intervals"
    return Arrays.copyOfRange(intervals, 0, index + 1);
  }
}
