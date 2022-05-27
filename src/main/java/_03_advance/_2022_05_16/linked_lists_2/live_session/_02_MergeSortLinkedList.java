package _03_advance._2022_05_16.linked_lists_2.live_session;

import _03_advance._2022_05_13.linked_lists_1.ListNode;
import _03_advance._2022_05_13.linked_lists_1.assignment.MiddleOfLinkedList;

// TC: O(n Log n)
public class _02_MergeSortLinkedList {
    public static ListNode mergeSortLinkedlist(ListNode head){
        if (head == null || head.next == null) return head; // base case
        ListNode h1 = head;
        ListNode mid = MiddleOfLinkedList.getMiddle(head); // O(n)
        ListNode h2 = mid.next;
        mid.next = null; // else we cant break the list into half
        h1 = mergeSortLinkedlist(h1); // log(n)
        h2 = mergeSortLinkedlist(h2);  // log(n)
        return _01_MergeTwoSortedLinkedlists.mergeLL(h1, h2); // O(n)
    }
}
