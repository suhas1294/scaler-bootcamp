package _03_advance._2022_06_15.tree_5.live_session;

public class _01_MergeTwoCDLL {
    // TC: O(1), SC: O(1)
    public CDLLNode combineCDLL(CDLLNode h1, CDLLNode h2){ // h1 = head, t1 = tail1
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        CDLLNode t1 = h1.prev;
        CDLLNode t2 = h2.prev;
        t1.next = h2;
        h2.prev = t1;
        h1.prev = t2;
        t2.next = h1;
        return h1;
    }

    private class CDLLNode{
        int val;
        CDLLNode next;
        CDLLNode prev;
        public CDLLNode(int val, CDLLNode next, CDLLNode prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
