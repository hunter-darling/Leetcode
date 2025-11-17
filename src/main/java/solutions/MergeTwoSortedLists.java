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
  // Time: O(m+n): m and n are the lengths of the two lists, we visit each node at most once
  // Space: O(m+n): from the recusion stack - each recursive call adds a frame to the call stack, in the worst case we recurse once per node, for very long lists we risk stack overflow
  // Recusion is simpler conceptually (imo) but uses more space

  public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1); // temporary starting point
    ListNode current = dummy;          // pointer to build the merged list
    
    while (list1 != null && list2 != null) {
        if (list1.val < list2.val) {
            current.next = list1;  // attach smaller node
            list1 = list1.next;    // move forward
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;    // advance pointer
    }

    // Attach remaining nodes from the non-empty list
    current.next = (list1 != null) ? list1 : list2;

    return dummy.next; // skip the placeholder
    // Time: O(m+n): same as recursive method, visit each node at most once
    // Space: O(1): we use a couple pointers but no additional data structures or method calls, nodes are rearranged in-place
    // A bit more complex conceptually, but more optimal space complexity
}
}