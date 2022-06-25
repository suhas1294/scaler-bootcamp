package _03_advance._2022_06_17.tree_6.live_session;

/*
there are 3 cases :
1. when target has no child (leaf node) : arrive to target, make the right/left of (node prev to target) as null
2. when target node has single child : dissolve the target (as if u are bypassing it while traversing)
3. when target node has both child : replace the node to be deleted with its floor (or ceil) value.
 */
public class _03_DeletionInBST {
    // k is value of node to be deleted
    public Node deleteNode(Node root, int k){
        if (root == null) return null;
        if (root.val == k){
            // case-1 : leaf node
            if (root.left == null && root.right == null){
                return null;
            }
            // case-2 : single child
            if (root.left == null || root.right == null){
                if (root.left == null) {
                    return root.right;
                }else{ // root.right is null
                    return root.left;
                }
            }
            // case-3 : has both child
            int x = floor(root);
            root.val = x;
            root.left = deleteNode(root.left, x);
            return root;
        }else if(k < root.val){
            root.left = deleteNode(root.left, k);
        }else{
            root.right = deleteNode(root.right, k);
        }
        return root;
    }

    int floor(Node node){
        if (node == null || node.left == null) return -1;
        Node tmp = node.left;
        while (tmp.right != null){
            tmp = tmp.right;
        }
        return tmp.val;
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
