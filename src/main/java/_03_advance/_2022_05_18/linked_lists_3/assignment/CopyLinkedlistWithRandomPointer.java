package _03_advance._2022_05_18.linked_lists_3.assignment;

public class CopyLinkedlistWithRandomPointer {

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode curr = head;
        RandomListNode temp;
        //insert next nodes of clone in between
        while (curr != null) {
            temp = curr.next;
            curr.next = new RandomListNode(curr.label);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        while (curr != null) {
            curr.next.random = curr.random != null ? curr.random.next : curr.random;
            curr = curr.next.next;
        }
        RandomListNode original = head;
        RandomListNode copy = head.next;
        temp = copy;
        while (original != null && copy != null) {
            original.next = original.next.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        addDuplicates(head);
        setRandom(head);
        return extractCopy(head);
    }

    private RandomListNode extractCopy(RandomListNode head) {
        RandomListNode res = new RandomListNode(-1);
        RandomListNode ptr = res;
        while (head != null) {
            RandomListNode x = head.next;
            ptr.next = x;
            ptr = ptr.next;
            head.next = x.next;
            x.next = null;
            head = head.next;
        }
        return res.next;
    }

    private void setRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) head.next.random = head.random.next;
            head = head.next.next;
        }
    }

    private void addDuplicates(RandomListNode head) {
        while (head != null) {
            RandomListNode x = new RandomListNode(head.label);
            x.next = head.next;
            head.next = x;
            head = x.next;
        }
    }
}

/*
A linked list A is given such that each node contains an additional random pointer
which could point to any node in the list or NULL.
Return a deep copy of the list.

Problem Constraints : 0 <= |A| <= 10^6

Input Format
The first argument of input contains a pointer to the head of linked list A.

Output Format : Return a pointer to the head of the required linked list.

Example Input

Given list : 1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1

Example Output :  1 -> 2 -> 3
with random pointers going from
  1 -> 3
  2 -> 1
  3 -> 1

Example Explanation
You should return a deep copy of the list. The returned answer should not contain
the same node as the original list, but a copy of them. The pointers in the
returned list should not link to any node in the original input list.
 */