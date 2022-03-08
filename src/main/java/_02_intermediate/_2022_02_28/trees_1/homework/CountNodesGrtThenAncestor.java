package _02_intermediate._2022_02_28.trees_1.homework;

public class CountNodesGrtThenAncestor {
    public static int solve(TreeNode A) {
        return -1;
    }

    static class TreeNode {
        int val;
        IdenticalBinaryTrees.TreeNode left;
        IdenticalBinaryTrees.TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
}

/*
Given the root of a tree A with each node having a certain value,
find the count of nodes with more value than all its ancestor.

1 <= Number of Nodes <= 200000
1 <= Value of Nodes <= 2000000000

Input Format : The first and only argument of input is a tree node.
Output Format : Return a single integer denoting the count of nodes that
have more value than all of its ancestors.

Example Input

Input 1:

     3
Input 2:

    4
   / \
  5   2
     / \
    3   6


Output 1: 1
Output 2: 3

Explanation 1: There's only one node in the tree that is the valid node.
Explanation 2: The valid nodes are 4, 5 and 6.
 */