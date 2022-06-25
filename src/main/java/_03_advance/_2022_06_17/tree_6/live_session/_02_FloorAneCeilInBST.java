package _03_advance._2022_06_17.tree_6.live_session;

/*
Floor of given node  : 1 step left, right-right-right-right .... to last right
Ceil of given node  : 1 step right, left-left-left-left .... to last left

Floor  : largest value <= given node
ceil  : smallest value >= given node
 */
public class _02_FloorAneCeilInBST {
    int floor(TreeNode node){
        if (node == null || node.left == null) return -1;
        TreeNode tmp = node.left;
        while (tmp.right != null){
            tmp = tmp.right;
        }
        return tmp.val;
    }

    int ceil(TreeNode node){
        if (node == null || node.right == null) return -1;
        TreeNode tmp = node.right;
        while (tmp.left != null){
            tmp = tmp.left;
        }
        return tmp.val;
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
