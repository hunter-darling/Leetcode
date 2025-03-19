package src.main.java.solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import src.main.java.model.TreeNode;

/*
* LC 102: Binary Tree Level Order Traversal
* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level)
*/
public class BinaryTreeLevelOrderTraversal {
  // 1st solution: 16/35, failed to catch case with two null nodes on same level
  // in between two non-null nodes
  public List<List<Integer>> levelOrder_Incorrect(TreeNode root) {
    List<List<Integer>> traversal = new ArrayList<>();
    if (root == null) {
      return traversal;
    } else {
      traversal.add(Arrays.asList(root.val));
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      List<Integer> level = new ArrayList<>();
      System.out.print(node.val + "\n");
      if (node.left != null) {
        queue.add(node.left);
        level.add(node.left.val);
      }
      if (node.right != null) {
        queue.add(node.right);
        level.add(node.right.val);
      }
      if (level.size() > 0) {
        traversal.add(level);
      }
    }
    return traversal;
  }

  // Solution 2 - add iteration through added child nodes, remove instantiation of
  // traversal with root node,
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> traversal = new ArrayList<>();
    if (root == null) {
      return traversal;
    }
    Queue<TreeNode> queue = new ArrayDeque<>(List.of(root));
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      for (int sz = queue.size(); sz > 0; --sz) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      }
      traversal.add(level);
    }
    return traversal;
  }
}
