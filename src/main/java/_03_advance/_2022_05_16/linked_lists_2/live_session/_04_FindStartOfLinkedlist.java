package _03_advance._2022_05_16.linked_lists_2.live_session;

import _03_advance._2022_05_13.linked_lists_1.ListNode;

public class _04_FindStartOfLinkedlist {

    public static ListNode findStartOfCycleInLL(ListNode head){
        ListNode slow = head, fast = head, tmp = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) { // there is cycle
                while (slow != tmp){
                    slow = slow.next;
                    tmp = tmp.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode tmp = listNode;

        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = tmp.next;

        System.out.println(findStartOfCycleInLL(tmp).val);
    }
}
