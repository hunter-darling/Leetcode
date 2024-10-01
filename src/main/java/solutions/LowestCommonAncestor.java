package src.main.java.solutions;

import src.main.java.model.TreeNode;

/**
 * LC 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
}
