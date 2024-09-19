package solutions;

import model.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode start = new ListNode(0);
    ListNode current = start;
    int carryover = 0;

    while (l1 != null || l2 != null || carryover > 0) {
      if (l1 != null) {
        carryover += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        carryover += l2.val;
        l2 = l2.next;
      }
      current.next = new ListNode(carryover % 10);
      carryover /= 10;
      current = current.next;
    }
    return start.next;
  }
}
