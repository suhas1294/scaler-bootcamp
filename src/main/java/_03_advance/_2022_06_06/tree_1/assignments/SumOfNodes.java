package _03_advance._2022_06_06.tree_1.assignments;

public class SumOfNodes {
    int res = 0;
    public int sumOfNodesinTree(TreeNode root) {
        if(root == null) return 0;
        res +=root.val;
        sumOfNodesinTree(root.left);
        sumOfNodesinTree(root.right);
        return res;
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
You are given the root node of a binary tree A. You have to find the sum of node values of this tree.

Problem Constraints
1 <= Number of nodes in the tree <= 10⁵
0 <= Value of each node <= 10⁴

Input Format : First and only argument is a tree node A.
Output Format : Return an integer denoting the sum of node values of the tree.

Input 1:
 Values =  1
          / \
         4   3
Output 1: 8
Explanation 1: Clearly, 1 + 4 + 3 = 8.

Input 2:
 Values =  1
          / \
         8   3
        /
       2


Output 2: 14
Explanation 2: Clearly, 1 + 8 + 3 + 2 = 14.
 */