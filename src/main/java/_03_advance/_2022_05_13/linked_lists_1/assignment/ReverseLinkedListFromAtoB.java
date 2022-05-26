package _03_advance._2022_05_13.linked_lists_1.assignment;

import static _03_advance._2022_05_13.linked_lists_1.assignment.MiddleOfLinkedList.ListNode;

public class ReverseLinkedListFromAtoB {
    public ListNode reverseBetween(ListNode list, int a, int b) {
        ListNode newHead = list;
        int b1 = a - 1;
        ListNode prev = null;
        ListNode temp = null;
        ListNode before = null;
        ListNode NN = list;
        a--;
        b = b - a;
        while (a > 0) {
            before = NN;
            NN = NN.next;
            a--;
        }

        while (b > 0 && NN != null) {
            temp = NN;
            NN = NN.next;
            temp.next = prev;
            prev = temp;
            b--;
        }

        if (b1 > 0) {
            before.next = prev;
            newHead = list;
        } else {
            newHead = prev;
        }
        while (prev.next != null) {
            prev = prev.next;
        }
        prev.next = NN;
        return newHead;
    }
}

/*
Reverse a linked list A from position B to C.
NOTE: Do it in-place and in one-pass. consider linkedlist as 1-based indexing.

Problem Constraints
1 <= |A| <= 10^6
1 <= B <= C <= |A|

Input Format The first argument contains a pointer to the head of the given linked list, A.
The second arugment contains an integer, B.
The third argument contains an integer C.

Output Format : Return a pointer to the head of the modified linked list.

Input 1: A = 1 -> 2 -> 3 -> 4 -> 5 B = 2 C = 4
Input 2: A = 1 -> 2 -> 3 -> 4 -> 5 B = 1 C = 5

Output 1: 1 -> 4 -> 3 -> 2 -> 5
Output 2: 5 -> 4 -> 3 -> 2 -> 1

Explanation 1:
 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5

Explanation 2:
 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
 */