package _03_advance._2022_06_17.tree_6.live_session;

// given a perfect BST, link the node side ways (as if level order exists)
// a perfect BST is a tree - except whose last level, all other level has both children for a node.
public class _04_SideLinkPerfectBST {
    // idea-1  : can be done using level order traversal and queue
    // idea-2 : without using extra space, TC: O(n), sc: O(1)
    void connectSides(Node root) {
        Node cur = root;
        while (cur.left != null) {
            Node tmp = cur;
            while (tmp != null) {
                tmp.left.side = tmp.right;
                if (tmp.side != null) {
                    tmp.right.side = tmp.side.left;
                }
                tmp = tmp.side;
            }
            cur = cur.left;
        }
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        Node side;

        Node(int x) {
            val = x;
            left = null;
            right = null;
            side = null;
        }
    }
}
