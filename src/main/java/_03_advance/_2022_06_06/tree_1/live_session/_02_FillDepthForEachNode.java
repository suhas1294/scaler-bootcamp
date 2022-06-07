package _03_advance._2022_06_06.tree_1.live_session;

// fill the depth for each node given a binary tree.
public class _02_FillDepthForEachNode {
    public static void fillDepth(TreeNode root, int d){ // d is initial depth.
        if (root == null) return;
        root.depth = d;
        fillDepth(root.left, d+1 );
        fillDepth(root.right, d+1 );
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int depth;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args) {
        fillDepth(new TreeNode(3), 0);
    }
}
