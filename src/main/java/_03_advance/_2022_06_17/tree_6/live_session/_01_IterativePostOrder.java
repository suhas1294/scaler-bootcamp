package _03_advance._2022_06_17.tree_6.live_session;

import java.util.ArrayList;
import java.util.Stack;

//TC : O(N), SC : O(N)
public class _01_IterativePostOrder {
    // we need to use 2 stacks to achieve the solution
    void postOrderIterative(TreeNode root){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode t = s1.peek();
            s1.pop();
            s2.push(t);
            // if we change below order, we get iterative pre-prorder
            if (t.left != null) s1.push(t.left);
            if (t.right != null) s1.push(t.right);
        }
        // now ans is stored in s2 in reverse order, just pop it to print in correct order
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val);
        }
    }

    // assignment problem
    public int[] postorderTraversal(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<>();
        if(A == null) return new int[]{};
        TreeNode pre=null;
        Stack<TreeNode> stk = new Stack<>();
        while(A != null || !stk.empty()){
            if(A != null){
                stk.push(A);
                A = A.left;
            } else{
                A = stk.peek();
                if(A.right == null || A.right == pre){        // means we have traversed right subtree already
                    res.add(A.val);
                    stk.pop();
                    pre = A;
                    A = null;             // we dont go down to left child again
                } else{
                    A = A.right;     // Traverse the right subtree before adding root
                }
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
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
