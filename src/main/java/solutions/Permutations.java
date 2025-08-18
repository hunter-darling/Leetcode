package src.main.java.solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    // Permutations, that means the result set is the size of the entry set(!)
    List<List<Integer>> permutations = new ArrayList<>();
    backtrackDfs(nums, new ArrayList<>(), permutations);
    return permutations;
  }

  private void backtrackDfs(int[] nums, List<Integer> permutation, List<List<Integer>> permutations) {
    if (permutation.size() == nums.length) {
      permutations.add(new ArrayList<>(permutation));
    }

    for (int i = 0; i < nums.length; i++) {
      if (permutation.contains(nums[i]))
        continue;
      permutation.add(nums[i]);
      backtrackDfs(nums, permutation, permutations);
      permutation.remove(permutation.size() - 1);
      System.out.println(permutation.toString());
    }
  }
}