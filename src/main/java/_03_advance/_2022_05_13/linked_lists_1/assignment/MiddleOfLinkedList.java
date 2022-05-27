package _03_advance._2022_05_13.linked_lists_1.assignment;

import _03_advance._2022_05_13.linked_lists_1.ListNode;

public class MiddleOfLinkedList {
    // efficient solution using slow and fast pointers
    // it will take single iteration unlike other solutions.
    public static ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static int getMiddle1(ListNode A) {
        int length = 0;
        if (A.next == null) return A.val;
        ListNode tmp = A;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }
        length++; // When we are on last node, we dont enter while loop, but it has to be counted.

        //System.out.println("length: " + length);
        int jumpCounter = 0;
        tmp = A;
        while (jumpCounter < length / 2) {
            tmp = tmp.next;
            jumpCounter++;
        }
        return tmp.val;
    }

    public static ListNode deleteMiddle(ListNode A) {
        int length = 0;
        if (A.next == null) return null;
        ListNode tmp = A;
        while (tmp.next != null) {
            length++;
            tmp = tmp.next;
        }
        length++; // When we are on last node, we dont enter while loop, but it has to be counted.

        //System.out.println("length: " + length);
        int jumpCounter = 1;
        tmp = A;
        while (jumpCounter < length / 2) {
            tmp = tmp.next;
            jumpCounter++;
        }

        tmp.next = tmp.next.next;
        return A;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println(deleteMiddle(head));
    }

}

/*
Given a linked list of integers, find and return the middle element of the linked list.
NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

Problem Constraints
1 <= length of the linked list <= 100000
1 <= Node value <= 10^9

Input Format : The only argument given head pointer of linked list.
Output Format : Return the middle element of the linked list.

Input 1: 1 -> 2 -> 3 -> 4 -> 5 Output 1: 3
Input 2: 1 -> 5 -> 6 -> 2 -> 3 -> 4 Output 2: 2

Explanation 1: The middle element is 3.
Explanation 2: The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.
 */