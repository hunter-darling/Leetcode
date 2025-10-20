package src.main.java.solutions;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    // Permutations, that means the result set is the size of the entry set(!)
    List<List<Integer>> permutations = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrackDfs(nums, new ArrayList<>(), permutations, used);
    return permutations;
  }

  private void backtrackDfs(int[] nums, List<Integer> permutation, List<List<Integer>> permutations, boolean[] used) {
    if (permutation.size() == nums.length) {
      permutations.add(new ArrayList<>(permutation));
    }

    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        permutation.add(nums[i]);
        used[i] = true;
        backtrackDfs(nums, permutation, permutations, used);
        permutation.remove(permutation.size() - 1);
        used[i] = false;
        System.out.println(permutation.toString());
    }
  }
}