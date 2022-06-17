package _03_advance._2022_06_15.tree_5.live_session;

//Given Bst, convert into sorted circular DLL (cant use array to store BST)
public class _02_CDLLtoBST {
    // TC: O(N), SC: O(H), space we can optimize to O(1) if we use morris inorder algo
    CDLLNode convert(CDLLNode root){
        if (root == null) return null;
        CDLLNode h1 = convert(root.prev);
        CDLLNode h2 = convert(root.next);
        root.prev = root;
        root.next = root;
        return combineCDLL(combineCDLL(h1, root), h2);
    }

    public CDLLNode combineCDLL(CDLLNode h1, CDLLNode h2){
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
        CDLLNode prev; // left
        CDLLNode next; // right
        public CDLLNode(int val, CDLLNode next, CDLLNode prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
