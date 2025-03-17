package src.main.java.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 57. Insert Interval
 */
public class InsertInterval {
  // First solution, accepted, but pretty slow, may come back to optimize at some
  // point... right
  public int[][] insert(int[][] intervals, int[] newInterval) {
    /*
     * Using Java, so would have to index using the data structures provided, but
     * since we are not guaranteed that as we iterate through the intervals that we
     * will be adding an element to the result array, need to use an ArrayList with
     * built in "add"-type method, and then cast it to a valid return type.
     */
    List<int[]> newIntervals = new ArrayList<>();
    boolean newIntervalAdded = false;
    int i = 0;
    while (i < intervals.length) {
      if (intervals[i][1] < newInterval[0]) {
        newIntervals.add(intervals[i]);
      } else if (newInterval[1] < intervals[i][0]) {
        newIntervals.add(newInterval);
        newIntervalAdded = true;
        // If we get here, we can just add all the rest of the intervals array
        int j = i;
        while (j < intervals.length) {
          newIntervals.add(intervals[j]);
          j++;
        }
        break;
      } else {
        // Merge overlaps
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      }
      i++;
    }
    if (!newIntervalAdded) {
      newIntervals.add(newInterval);
    }
    return newIntervals.toArray(int[][]::new);
  }
}
