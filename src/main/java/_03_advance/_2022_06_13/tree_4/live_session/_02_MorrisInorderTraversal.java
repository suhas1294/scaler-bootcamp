package _03_advance._2022_06_13.tree_4.live_session;

public class _02_MorrisInorderTraversal {
    public static void morrisInorder(TreeNode root){
        TreeNode cur = root;
        while (cur != null){
            if (cur.left == null){
                System.out.println(cur.val);
                cur = cur.right;
            }else {
                TreeNode tmp = cur.left;
                while (tmp.right != null && tmp.right != cur){
                    tmp = tmp.right;
                }
                if (tmp.right == null){ // connect right most node of LST to cur
                    tmp.right = cur;
                    cur = cur.left;
                }
                if (tmp.right == cur){ // we are visiting second time, creak the cycle
                    tmp.right = null;
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }
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
