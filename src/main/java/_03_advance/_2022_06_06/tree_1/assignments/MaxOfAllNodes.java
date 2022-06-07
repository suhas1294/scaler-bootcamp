package _03_advance._2022_06_06.tree_1.assignments;

public class MaxOfAllNodes {
    int max = Integer.MIN_VALUE;
    public int solve(TreeNode root) {
        if(root == null) return 0;
        max = Integer.max(max , root.val);
        solve(root.left);
        solve(root.right);
        return max;
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
}

/*
You are given the root node of a binary tree A. You have to find the max
value of all node values of this tree.

Problem Constraints
1 <= Number of nodes in the tree <= 10⁵
0 <= Value of each node <= 10⁴

Input Format :  First and only argument is a tree node A.
Output Format : Return an integer denoting the max of all node values of the tree.

Input 1:
 Values =  1
          / \
         4   3
Output 1:  4
Explanation 1:  Clearly, among 1, 4, 3: 4 is maximum.

Input 2:
 Values =  1
          / \
         8   3
        /
       2
Output 2: 8
Explanation 2: Clearly, among 1, 8, 3, 2: 8 is maximum.
 */