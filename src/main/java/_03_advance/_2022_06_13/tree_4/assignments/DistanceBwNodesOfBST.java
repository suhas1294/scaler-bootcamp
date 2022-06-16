package _03_advance._2022_06_13.tree_4.assignments;

public class DistanceBwNodesOfBST {
    public int distanceBwNodesBST1(TreeNode root, int src, int dest) {
        if (src > dest) {
            int temp = src;
            src = dest;
            dest = temp;
        }
        return distanceBetween2(root, src, dest);
    }

    public int distanceBetween2(TreeNode root, int a, int b) {
        if (root == null) return 0;

        if (root.val > a && root.val > b)
            return distanceBetween2(root.left, a, b);

        if (root.val < a && root.val < b)
            return distanceBetween2(root.right, a, b);

        if (root.val >= a && root.val <= b)
            return (distanceFromRoot(root, a) + distanceFromRoot(root, b));
        return -1;
    }

    public int distanceFromRoot(TreeNode root, int x) {
        if (root.val == x) return 0;
        else if (root.val > x) return 1 + distanceFromRoot(root.left, x);
        return 1 + distanceFromRoot(root.right, x);
    }

    // --------------------------------------------------------------------

    // Simple Solution Without finding LCA
    public int distanceBwNodesBST2(TreeNode root, int src, int dest) {
        return getDistance(root, src, dest);
    }

    public int getDistance(TreeNode root, int src, int dest) {
        if (root == null) return 0;
        if (root.val > src && root.val > dest) return getDistance(root.left, src, dest);
        else if (root.val < src && root.val < dest) return getDistance(root.right, src, dest);
        return height(root, src) + height(root, dest);
    }

    public int height(TreeNode root, int target) {
        if (root == null || root.val == target) return 0;
        if (root.val >= target) return 1 + height(root.left, target);
        else return 1 + height(root.right, target);
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

/*
Given a binary search tree.
Return the distance between two nodes with given two keys B and C.
It may be assumed that both keys exist in BST.
NOTE: Distance between two nodes is number of edges between them.

Problem Constraints
1 <= Number of nodes in binary tree <= 1000000
0 <= node values <= 10⁹

Input Format
First argument is a root node of the binary tree, A.
Second argument is an integer B.
Third argument is an integer C.

Output Format
Return an integer denoting the distance between two nodes with given two keys B and C

Input 1:

         5
       /   \
      2     8
     / \   / \
    1   4 6   11

B = 2
C = 11

Output 1: 3
Explanation 1: Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.

Input 2:
         6
       /   \
      2     9
     / \   / \
    1   4 7   10
B = 2
C = 6

Output 2: 1
Explanation 2: Path between 2 and 6 is: 2 -> 6. Distance will be 1
 */