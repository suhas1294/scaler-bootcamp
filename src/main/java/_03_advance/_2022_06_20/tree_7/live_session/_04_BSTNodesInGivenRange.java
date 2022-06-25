package _03_advance._2022_06_20.tree_7.live_session;

// Given BST make sure all nodes are in given range [L R]
public class _04_BSTNodesInGivenRange {
    public TreeNode trim(TreeNode root, int l, int r){
        if (root == null) return null;
        if(root.val >= l && root.val <= r){
            root.left = trim(root.left, l, r);
            root.right = trim(root.right, l, r);
            return root;
        }else if(root.val < l){
            return trim(root.right, l, r);
        }else{
            return trim(root.left, l, r);
        }
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
