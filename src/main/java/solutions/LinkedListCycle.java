package src.main.java.solutions;

import src.main.java.model.ListNode;

public class LinkedListCycle {

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
