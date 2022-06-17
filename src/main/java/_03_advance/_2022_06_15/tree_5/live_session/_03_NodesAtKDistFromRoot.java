package _03_advance._2022_06_15.tree_5.live_session;

// Calculate no of nodes at a distance K from root node
public class _03_NodesAtKDistFromRoot {
    // tc : O(n), sc : O(H)
    int distance(TreeNode root, int k){
        if (root == null || k< 0) return 0;
        if (k == 0) return 1;
        int left = distance(root.left, k-1);
        int right = distance(root.right, k-1);
        return left + right;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
