package _03_advance._2022_05_13.linked_lists_1.assignment;

import static _03_advance._2022_05_13.linked_lists_1.assignment.MiddleOfLinkedList.ListNode;

public class ReverseLinkedlistInKGroups {
    // recursive solution
    public ListNode reverseListRecursive(ListNode A, int B) {
        if (A == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = 0;
        while (curr != null && B > count) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            A.next = reverseListRecursive(curr, B);
        }
        return prev;
    }

    // iterative solution:
    public ListNode reverseListIterative(ListNode A, int B) {
        ListNode ans = null;
        ListNode last_node = null;
        ListNode pre = null;
        ListNode next = null;
        ListNode start = A;
        int flag = 0;
        int count = 0;

        while (start != null) {
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
            count++;

            if (count == B) {
                if (flag == 0) {
                    ans = pre;
                    while (pre.next != null) {
                        pre = pre.next;
                    }
                    last_node = pre;
                    pre = null;
                    count = 0;
                    flag = 1;
                } else {
                    last_node.next = pre;
                    while (pre.next != null) {
                        pre = pre.next;
                    }
                    last_node = pre;
                    pre = null;
                    count = 0;
                }
            }
        }
        return ans;
    }
}

/*
Given a singly linked list A and an integer B, reverse the nodes of the list B
at a time and return the modified linked list.

Problem Constraints
1 <= |A| <= 10^3
B always divides A

Input Format
The first argument of input contains a pointer to the head of the linked list.
The second arugment of input contains the integer, B.

Output Format : Return a pointer to the head of the modified linked list.

Input 1: A = [1, 2, 3, 4, 5, 6]  B = 2 Output 1: [2, 1, 4, 3, 6, 5]
Explanation 1:
 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]

Input 2: A = [1, 2, 3, 4, 5, 6] B = 3 Output 2: [3, 2, 1, 6, 5, 4]
Explanation 2:
 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]
 */