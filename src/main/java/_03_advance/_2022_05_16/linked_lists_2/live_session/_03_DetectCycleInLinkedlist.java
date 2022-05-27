package _03_advance._2022_05_16.linked_lists_2.live_session;
import _03_advance._2022_05_13.linked_lists_1.ListNode;

// Floyd cycle
public class _03_DetectCycleInLinkedlist {
    // efficient solution : use slow and fast pointers
    public static boolean isThereLoopInLinkedlist(ListNode head){
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) return true;
        }
        return false;
    }

    // idea-1: loop through linkedlist and add nodes to hashset,
    // while adding check if its already present, if yes, return true.
}
