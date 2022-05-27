package _03_advance._2022_05_16.linked_lists_2.live_session;

import _03_advance._2022_05_13.linked_lists_1.ListNode;

public class _05_BreakCycleInLinkedlist {
    public static ListNode removeLoopInLinkedlist(ListNode A) {
        if (A == null || A.next == null) return null;
        ListNode slow = A, fast = A, tmp = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // there is a cycle
                while (tmp.next != slow.next){
                    slow = slow.next;
                    tmp = tmp.next;
                }
                slow.next = null;
                return A;
            }
        }
        return A;
    }

    public static ListNode removeLoopInLinkedlist2(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) { // there is head cycle
                slow = head;
                if (slow != fast) {  // if given linkedlist is NOT perfect circle
                    while (slow.next != fast.next) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    fast.next = null; // remove loop
                } else { // if given linkedlist is perfect circle
                    while(fast.next != slow) {
                        fast = fast.next;
                    }
                    fast.next = null;
                }
            }
        }
        return head;
    }
}

