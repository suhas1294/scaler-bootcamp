package _02_intermediate._2022_02_28.trees.assignments;

public class FindTreeHeight {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static int solve(TreeNode A) {
        if (A == null) return -1;
        System.out.println("current node : " + A.val);
        int leftSubtreeHeight = solve(A.left);
        int rightSubtreeHeight = solve(A.right);
        return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode(9);
        tn.left = new TreeNode(1);
        tn.right = new TreeNode(0);
        tn.left.left = new TreeNode(0);
        tn.left.right = new TreeNode(1);
        System.out.println(solve(tn));
    }
}

/*
You are given the root node of a binary tree A, You have to find the height of the given tree.
A binary tree's height is the number of nodes along the longest path from the root node down
to the farthest leaf node.

1 <= Number of nodes in the tree <= 10^5
0 <= Value of each node <= 10^9

input format: First and only argument is a tree node A.
output format: Return an integer denoting the height of the tree.

Input 1:
 Values =  1
          / \
         4   3
output : 2
exp:  Distance of node having value 1 from root node = 1
Distance of node having value 4 from root node = 2 (max)
Distance of node having value 3 from root node = 2 (max)

Input 2:
 Values =  1
          / \
         4   3
        /
       2
output : 3
exp:
Distance of node having value 1 from root node = 1
Distance of node having value 4 from root node = 2
Distance of node having value 3 from root node = 2
Distance of node having value 2 from root node = 3 (max)
 */