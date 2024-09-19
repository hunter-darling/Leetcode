package src.main.java.solutions;

import src.main.java.model.ListNode;

/**
 * LC 21. Merge Two Sorted Lists
 */
class MergeTwoSortedLists {
  // Definition for singly-linked list.

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // Recursive solution
    /**
     * if (list1 == null || list2 == null){
     * return list1 == null ? list2 : list1;
     * }
     * if (list1.val > list2.val) {
     * ListNode currentNode = list1;
     * list1 = list2;
     * list2 = currentNode;
     * }
     * ListNode nextNode = list1.next;
     * list1.next = mergeTwoLists(nextNode, list2);
     * return list1;
     */

    // Iterative Solution
    ListNode temp = new ListNode();
    ListNode listTail = temp;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        listTail.next = list1;
        list1 = list1.next;
      } else {
        listTail.next = list2;
        list2 = list2.next;
      }
      listTail = listTail.next;
    }

    if (list1 != null) {
      listTail.next = list1;
    } else if (list2 != null) {
      listTail.next = list2;
    }
    return temp.next;
  }
}