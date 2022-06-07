package _03_advance._2022_06_06.tree_1.live_session;

public class _01_SizeOfTreeNodeCount {
    public static int sizeOfATree(TreeNode root){
        if (root == null) return 0;
        int sizeLeft = sizeOfATree(root.left);
        int sizeRight = sizeOfATree(root.right);
        return 1 + sizeLeft + sizeRight;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
}
