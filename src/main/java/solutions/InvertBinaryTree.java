package src.main.java.solutions;

import src.main.java.model.TreeNode;

public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    // Catch edge case
    if (root == null) {
      return null;
    }
    // Temp variables to hold left and right nodes of current node
    TreeNode tempLeft;
    TreeNode tempRight;
    tempLeft = root.left;
    tempRight = root.right;
    // Recursion!
    root.left = invertTree(tempRight);
    root.right = invertTree(tempLeft);
    // The above process will repeatedly call the method until it reaches a null
    // root (i.e. the end of the tree)
    return root;
  }
}
