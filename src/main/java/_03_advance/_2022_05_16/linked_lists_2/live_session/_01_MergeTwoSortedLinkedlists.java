package _03_advance._2022_05_16.linked_lists_2.live_session;
import _03_advance._2022_05_13.linked_lists_1.ListNode;

// merge two SORTED linked lists,TC: O(N+m), sc:O(1)
public class _01_MergeTwoSortedLinkedlists {
    public static ListNode mergeLL(ListNode h1, ListNode h2){
        ListNode h3, last;
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        if (h1.val <= h2.val){
            h3 = h1;
            last = h1;
            h1 = h1.next;
        }else{
            h3 = h2;
            last = h2;
            h2 = h2.next;
        }

        // alternatively to above h3 and last initialization, we can do it like below as well.
        //ListNode h3 = new ListNode(-1);
        //last = h3

        while (h1 != null && h2 != null){
            if (h1.val <= h2.val){
                last.next = h1;
                h1 = h1.next;
            }else{
                last.next = h2;
                h2 = h2.next;
            }
            last = last.next;
        }
        if (h1 == null) last.next = h2;
        if (h2 == null) last.next = h1;
        return h3;
        // return h3.next; if u have followed alternative initialization
    }
}

/*
Here we are keeping 4 pointers:

h1 : pointing to head of one linkedlist
h2 : pointing to head of another linkedlist
h3 : head of new linkedlist we are building (i.e., after merging, we need to return head of merged linkedlist)
last : tail of new linkedlist we are building

initially we initialize both h3 and last nodes to Min(h1, h2)
After we will keep moving our last pointer to which ever node has less value out of h1 and h2
h3 will be fixed as head of merged linkedlist
last pointer will move from left to right (forward)
last pointer is the transporter of data here

 */