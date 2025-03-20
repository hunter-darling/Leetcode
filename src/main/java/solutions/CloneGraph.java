package src.main.java.solutions;

import java.util.HashMap;
import java.util.Map;

import src.main.java.model.Node;

/**
 * LC 133. Clone Graph
 */
public class CloneGraph {
  public Node cloneGraph(Node node) {
    Map<Node, Node> oldToNew = new HashMap<Node, Node>();
    if (node == null) {
      return null;
    }
    return dfs(node, oldToNew);
  }

  private Node dfs(Node curr, Map<Node, Node> oldToNew) {
    if (oldToNew.get(curr) != null) {
      // Means we already made a clone of curr node
      return oldToNew.get(curr);
    } else {
      Node copyNode = new Node(curr.val);
      oldToNew.put(curr, copyNode);
      for (Node neighbor : curr.neighbors) {
        // Running dfs on a neighbor of curr creates a copy of the neighbor, so we want
        // to add it to the list of neighbors on the copy
        copyNode.neighbors.add(dfs(neighbor, oldToNew));
      }
      return copyNode;
    }
  }
}
