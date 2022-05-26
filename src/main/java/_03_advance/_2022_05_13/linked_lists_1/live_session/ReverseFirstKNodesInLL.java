package _03_advance._2022_05_13.linked_lists_1.live_session;

import static _03_advance._2022_05_13.linked_lists_1.assignment.MiddleOfLinkedList.ListNode;

public class ReverseFirstKNodesInLL {
    // this program is a slight modification of function :
    // _03_advance._2022_05_13.linked_lists_1.assignment.ReverseLinkedlist.reverseList2
    // here we are having one extra pointer h3 to point to tail of newly created list which
    // will be used to point to remaining elements (n-k) in original list.
    // i.e., after reversing first k elements in Linkedlist, there is still some task left :
    // point ur reversed linkedlist to remaining (n-k) elements of original list. to that,
    // maintain a pointer h3 at tail of reversed list.
    public static ListNode reverseFirstK(ListNode head, int k){
        ListNode h1 = head, h3 = head, tmp = head, h2 = null;
        while (k > 0 && h1 != null){
            tmp = h1;
            h1 = h1.next;
            tmp.next = h2;
            h2 = tmp;
            k--;
        }
        if (h3 != null) h3.next = h1;
        return h2; //return head of newly created (reversed) linkedlist.
    }
}
