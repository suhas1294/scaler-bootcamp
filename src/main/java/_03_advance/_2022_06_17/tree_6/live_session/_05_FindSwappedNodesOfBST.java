package _03_advance._2022_06_17.tree_6.live_session;

import java.util.ArrayList;
import java.util.List;

// given a BST, two of the node are wrongly swapped, find them.
// note : inorder of a BST is a sorted array.
public class _05_FindSwappedNodesOfBST {

    int[] findSwapedNodes(TreeNode root){
        int[] ans = {-1, -1};
        int[] a = inorderTraversal(root);
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) ans[0] = a[i];
        }
        for (int i = a.length-1; i >= 1 ; i--) {
            if (a[i] < a[i-1]) ans[1] = a[i];
        }
        return ans;
    }

    public int[] inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    public void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
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
