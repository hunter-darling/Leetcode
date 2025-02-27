package src.main.java.solutions;

import src.main.java.model.ListNode;

/**
 * LC 206. Reverse Linked List
 */
public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    // Iterative:
    // ListNode previous = null;
    // while (head != null) {
    // ListNode temp = head.next;
    // head.next = previous;
    // previous = head;
    // head = temp;
    // }
    // return previous;

    // Recursive:
    if (head == null || head.next == null) {
      return head;
    }
    ListNode nextHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return nextHead;
  }
}
