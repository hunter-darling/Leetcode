package src.main.java.solutions;

import src.main.java.model.ListNode;

public class FloydsTortoiseAndHare {
  public boolean hasCycle(ListNode head) {
    // Naive solution - Time: O(n), Space: O(n)
    // There must be a better way!
    // if (head == null) return false;
    // HashSet<ListNode> visitedNodes = new HashSet<ListNode>();
    // ListNode currentNode = head;
    // visitedNodes.add(currentNode);
    // while (currentNode.next != null) {
    // if (visitedNodes.contains(currentNode.next)) {
    // return true;
    // } else {
    // visitedNodes.add(currentNode);
    // }
    // currentNode = currentNode.next;
    // }
    // return false;

    /**
     * The fast node will always catch the slow node if there is a cycle in the
     * linked list, and it will only ever take n iterations for a linked list of
     * size n, because the gap between the two closes faster than it opens (slow
     * moves +1, fast moves +2)
     */
    ListNode firstNode = head;
    ListNode secondNode = head;
    while (firstNode != null && firstNode.next != null) {
      if (firstNode.next == secondNode) {
        return true;
      }
      firstNode = firstNode.next.next;
      secondNode = secondNode.next;
    }
    return false;
  }
}
