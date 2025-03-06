package src.main.java.solutions;

import src.main.java.model.ListNode;

public class MiddleOfLinkedList {
  // Initial brute force monkey brain solution
  // public ListNode middleNode(ListNode head) {
  // ListNode nose = head;
  // ListNode tail = head;
  // int count = 0;
  // while (nose.next != null) {
  // count++;
  // nose = nose.next;
  // }
  // System.out.println(count);
  // int middleNodeIndex = count % 2 == 0 ? count / 2 : (count / 2) + 1;
  // for (int i = 0; i < middleNodeIndex; i++) {
  // tail = tail.next;
  // }
  // return tail;
  // }

  // New solution using full power of evolved homo-sapien brain (tortoise and hare
  // type
  // algo)
  public ListNode middleNode(ListNode head) {
    ListNode nose = head;
    ListNode tail = head;
    while (nose != null && nose.next != null) {
      nose = nose.next.next;
      tail = tail.next;
    }
    return tail;
  }
}
