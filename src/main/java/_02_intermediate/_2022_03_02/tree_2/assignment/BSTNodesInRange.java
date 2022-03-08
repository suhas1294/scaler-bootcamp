package _02_intermediate._2022_03_02.tree_2.assignment;

// https://www.geeksforgeeks.org/count-bst-nodes-that-are-in-a-given-range/
public class BSTNodesInRange {
    public int solve(TreeNode node, int low, int high) {
        if(node == null) return 0;
        // If current node is in range, then include it in count and recur for left and right children of it
        if(node.val >= low && node.val <= high){
            return 1 + this.solve(node.left, low, high) + this.solve(node.right, low, high);
        } else if(node.val < low) { // If current node is smaller than low, then recur for right child
            return this.solve(node.right, low, high);
        }else { // Else recur for left child
            return this.solve(node.left, low, high);
        }
    }

    static class TreeNode {
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

/*
Given a binary search tree of integers. You are given a range B and C.
Return the count of the number of nodes that lie in the given range.

1 <= Number of nodes in binary tree <= 100000
0 <= B < = C <= 109

Input Format :
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.

Output Format : Return the count of the number of nodes that lies in the given range.

Input 1:

            15
          /    \
        12      20
        / \    /  \
       10  14  16  27
      /
     8

     B = 12
     C = 20
Input 2:

            8
           / \
          6  21
         / \
        1   4

     B = 2
     C = 20

Output 1: 5
Output 2: 3

Explanation 1: Nodes which are in range [12, 20] are : [12, 14, 15, 20, 16]
Explanation 2: Nodes which are in range [2, 20] are : [8, 6, 4]
 */