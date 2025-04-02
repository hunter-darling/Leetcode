package src.main.java.solutions;

import src.main.java.model.TreeNode;

/*
 * LC 98. Validate Binary Search Tree
 */
public class ValidateBST {
  // First solution, 77/86 test cases passes
  public boolean isValidBSTv1(TreeNode root) {
    return isValidv1(root);
  }

  private boolean isValidv1(TreeNode root) {
    if (root == null) {
      return true;
    }
    if ((root.right != null && root.right.val <= root.val) ||
        (root.left != null && root.left.val >= root.val)) {
      return false;
    } else {
      return (isValidv1(root.left) && isValidv1(root.right));
    }
  }

  // Second solution, needed to persist the min/max nodes, ensure the BST is valid
  // all the way down
  public boolean isValidBST(TreeNode root) {
    return isValid(root, null, null);
  }

  private boolean isValid(TreeNode root, TreeNode minNode, TreeNode maxNode) {
    if (root == null) {
      return true;
    }
    if (maxNode != null && maxNode.val <= root.val) {
      return false;
    }
    if (minNode != null && minNode.val >= root.val) {
      return false;
    }
    return (isValid(root.left, minNode, root) && isValid(root.right, root, maxNode));
  }

}
