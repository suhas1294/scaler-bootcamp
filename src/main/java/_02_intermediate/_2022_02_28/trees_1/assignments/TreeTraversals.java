package _02_intermediate._2022_02_28.trees_1.assignments;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversals {
    public void inorderTraversal(TreeNode A, List<Integer> list) {
        if (A == null) return;
        inorderTraversal(A.left, list);
        list.add(A.val);
        inorderTraversal(A.right, list);
    }
    public void preOrderTraversal(TreeNode A, List<Integer> list) {
        if (A == null) return;
        list.add(A.val);
        preOrderTraversal(A.left, list);
        preOrderTraversal(A.right, list);
    }
    public void postOrderTraversal(TreeNode A, List<Integer> list) {
        if (A == null) return;
        postOrderTraversal(A.left, list);
        postOrderTraversal(A.right, list);
        list.add(A.val);
    }
    public int[] inorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(A, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
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
