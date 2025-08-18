package src.main.java.solutions;

import java.util.ArrayList;
import java.util.List;

/*
 * LC 39: Combination Sum
 * DFS & backtracking
 */
public class CombinationSum {

  // Recursive solution, O(2^n)
  public List<List<Integer>> combinationSumRecursive(int[] candidates, int target) {
    List<List<Integer>> combinations = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), combinations);
    return combinations;
  };

  private void backtrack(int[] candidates, int target, int startIndex, List<Integer> currentCombination,
      List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(currentCombination));
      return;
    }

    for (int i = startIndex; i < candidates.length; i++) {
      int candidate = candidates[i];
      if (candidate <= target) {
        currentCombination.add(candidate);
        backtrack(candidates, target - candidate, i, currentCombination, result);
        currentCombination.remove(currentCombination.size() - 1);
      }
    }
  }

}
