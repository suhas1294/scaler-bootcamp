package _03_advance._2022_05_16.linked_lists_2.assignments;

import _03_advance._2022_05_13.linked_lists_1.ListNode;

public class ReorderLinkedlist {
    // refer solution approach-2 below
    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode slow = head, fast = head, P1 = head, P2 = null, prev = null, nxt = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        P2 = slow;
        nxt = P2.next;
        P2.next = null;

        while (nxt != null) {
            prev = P2;
            P2 = nxt;
            nxt = nxt.next;
            P2.next = prev;
        }

        while (P1.next != P2 && P1 != P2) {
            nxt = P1.next;
            P1.next = P2;
            P1 = nxt;

            prev = P2.next;
            P2.next = P1;
            P2 = prev;
        }

        return head;
    }

    public static ListNode reorderList2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) { //find mid
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow;

        while (curr != null) { //reverse the 2nd Half
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //merge first half with reversed 2nd half
        ListNode n1 = head;
        ListNode n2 = prev;
        while (n2.next != null) {
            ListNode temp = n1.next;
            n1.next = n2;
            n1 = temp;

            temp = n2.next;
            n2.next = n1;
            n2 = temp;
        }
        return head;
    }
}

/*
Given a singly linked list A
 A: A0 → A1 → … → An-1 → An
reorder it to: A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.

Problem Constraints : 1 <= |A| <= 10^6

Input Format
The first and the only argument of input contains a pointer to the head of the linked list A.

Output Format
Return a pointer to the head of the modified linked list.

Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [1, 2, 3, 4]

Output 1: [1, 5, 2, 4, 3]
Output 2: [1, 4, 2, 3]

Explanation 1: The array will be arranged to [A0, An, A1, An-1, A2].
Explanation 2: The array will be arranged to [A0, An, A1, An-1, A2].

________________________________________
Solution approach - 2
1. Reverse the second half of the LL.
2. Maintain 2 pointers: One from head and other from last node.
3. P1.next = P2; P1++ and P2.next =P1; P2++;
4. Repeat 3 till P1 reaches center point.
5. Return head.
 */