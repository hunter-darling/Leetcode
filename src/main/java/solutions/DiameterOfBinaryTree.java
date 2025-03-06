package src.main.java.solutions;

import src.main.java.model.TreeNode;

public class DiameterOfBinaryTree {
  // global variable, accessible by each function in the class
  private int result = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);
    return result;
  }

  private int maxDepth(TreeNode root) {
    if (root == null)
      return 0;
    int rightSubtreeDepth = maxDepth(root.right);
    int leftSubtreeDepth = maxDepth(root.left);
    result = Math.max(result, rightSubtreeDepth + leftSubtreeDepth);
    return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
  }
}
