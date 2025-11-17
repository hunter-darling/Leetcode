package src.main.java.solutions;

import src.main.java.model.TreeNode;

public class LowestCommonAncestor {
  /**
  * LC 235. Lowest Common Ancestor of a Binary Search Tree
  */
  public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode lca = root;
    while (lca != null) {
      if (p.val > lca.val && q.val > lca.val) {
        lca = lca.right;
      } else if (p.val < lca.val && q.val < lca.val) {
        lca = lca.left;
      } else {
        return lca;
      }
    }
    return lca;
  }
  // Time: O(h) where h is the height of the BST
  // Space: constant

  /**
  * LC 236. Lowest Common Ancestor of a Binary Tree
  */
  public TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
    // No odering like a BST, need recursion

    // Base case
    if (root == null || root == q || root == p) {
      return root;
    }

    // Seach left and right subtrees
    TreeNode left = lowestCommonAncestorBT(root.left, p, q);
    TreeNode right = lowestCommonAncestorBT(root.right, p, q);

    // Both sides not null, current node is LCA
    if (left != null && right != null) {
      return root;
    }

    // Else, return non-null side
    return left != null ? left : right;
  }
  // Time: O(n) where n is the number of nodes - worst case we visit all of them
  // Space: O(h) where h is the height of the BT - due to recursion
}
