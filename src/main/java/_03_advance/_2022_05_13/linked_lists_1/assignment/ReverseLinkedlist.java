package _03_advance._2022_05_13.linked_lists_1.assignment;

import static _03_advance._2022_05_13.linked_lists_1.assignment.MiddleOfLinkedList.ListNode;

public class ReverseLinkedlist {
    public ListNode reverseList(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode curr = A;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // taught in live sessoin, refer self made notes for easy understanding.
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h1 = head, tmp = head, h2 = null;
        // use tmp as a cursor to copy value, move h2 in backward direction.
        while (h1 != null) {
            tmp = h1;
            h1 = h1.next;
            tmp.next = h2;
            h2 = tmp;
        }
        return h2;
    }
}

/*
You are given a singly linked list having head node A. You have to reverse the
linked list and return the head node of that reversed list.
NOTE: You have to do it in-place and in one-pass.

Problem Constraints
1 <= Length of linked list <= 10^5
Value of each node is within the range of a 32-bit integer.

Input Format : First and only argument is a linked-list node A.
Output Format : Return a linked-list node denoting the head of the reversed linked list.

Input 1: A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL, Output 1: 5 -> 4 -> 3 -> 2 -> 1 -> NULL
Input 2: A = 3 -> NULL Output 2: 3 -> NULL

Explanation 1:The linked list has 5 nodes. After reversing them,
 the list becomes : 5 -> 4 -> 3 -> 2 -> 1 -> NULL
Expalantion 2: The linked list consists of only a single node.
    After reversing it, the list becomes : 3 -> NULL
 */