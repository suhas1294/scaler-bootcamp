package _02_intermediate._2022_03_02.tree_2.homework;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
public class PathToGivenNode {

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (hasPath(A, arr, B)){ // if required node 'x' is present then print the path
            return arr;
        }else{
            return new ArrayList<>();
        }
    }

    public static boolean hasPath(TreeNode root, ArrayList<Integer> arr, int x){
        if (root==null) return false; // there is no path
        arr.add(root.val);
        if (root.val == x) return true; // if it is the required node

        // check whether the required node lies in the left subtree or right subtree of the current node
        if (hasPath(root.left, arr, x) || hasPath(root.right, arr, x)) return true;

        // target does not lie either in the left or right subtree of the current node
        // Thus, remove current node's value from 'arr' and then return false
        arr.remove(arr.size()-1);
        return false;
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
Given a Binary Tree A containing N nodes, you need to find the path from Root to a given node B.

NOTE:
No two nodes in the tree have the same data values.
You can assume that B is present in tree A and a path always exists.

Problem Constraints
    1 <= N <= 105
    1 <= Data Values of Each Node <= N
    1 <= B <= N

Input Format :
First Argument represents pointer to the root of binary tree A.
Second Argument is an integer B denoting the node number.

Output Format : Return an one-dimensional array denoting the path from Root to the node B in order.

Input 1:
 A =
           1
         /   \
        2     3
       / \   / \
      4   5 6   7

B = 5

Input 2:
 A =
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

 B = 1

Output 1: [1, 2, 5]
Output 2: [1]

Explanation 1:
 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]

Explanation 2:
 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]
 */