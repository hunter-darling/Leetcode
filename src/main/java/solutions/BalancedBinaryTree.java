package src.main.java.solutions;

import src.main.java.model.TreeNode;

/**
 * LC 110. Balanced Binary Tree
 */
public class BalancedBinaryTree {
  // Best solution: O(n*log(n))
  public boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;
    return (1 >= Math.abs(maxDepth(root.right) - maxDepth(root.left)) &&
        isBalanced(root.right) &&
        isBalanced(root.left));
  }

  // Goes all the way to the "end", works back up, ensures we only touch each node
  // once
  private int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  // Naive approach, compare the height of the root's two subtrees: O(n^2)
  // private int leftSubTreeDepth(TreeNode root) {
  // int depth = 0;
  // while (root != null) {
  // root = root.left;
  // depth++; }
  // return depth; }
  // private int rightSubTreeDepth(TreeNode root) {
  // int depth = 0;
  // while (root != null) {
  // root = root.right;
  // depth++; }
  // return depth; }
  // This misses the point that each node needs to have subtrees itself that obey
  // the balanced tree condition, done recursively, it leads to O(n^2) - not good!

  // Straightforward approach: O(n)
  // public boolean isBalanced(TreeNode root) {
  // maxDepth(root);
  // return ans; }
  // private boolean ans = true;
  // Returns the height of root and sets ans to false if root unbalanced.
  // public int maxDepth(TreeNode root) {
  // if (root == null || !ans)
  // return 0;
  // final int left = maxDepth(root.left);
  // final int right = maxDepth(root.right);
  // if (Math.abs(left - right) > 1)
  // ans = false;
  // return Math.max(left, right) + 1; }

  // Heuristic approach: O(n)
  // public boolean isBalanced(TreeNode root) {
  // return maxDepth(root) != -1; }
  // Returns the height of root if root is balanced; otherwise, returns -1.
  // private int maxDepth(TreeNode root) {
  // if (root == null)
  // return 0;

  // final int left = maxDepth(root.left);
  // if (left == -1)
  // return -1;
  // final int right = maxDepth(root.right);
  // if (right == -1)
  // return -1;
  // if (Math.abs(left - right) > 1) return -1;
  // return 1 + Math.max(left, right); }
}
