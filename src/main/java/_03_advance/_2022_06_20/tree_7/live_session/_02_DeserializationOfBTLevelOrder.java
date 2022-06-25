package _03_advance._2022_06_20.tree_7.live_session;

import java.util.ArrayDeque;
import java.util.Queue;

// Serialization of BT using level order traversal
public class _02_DeserializationOfBTLevelOrder {
    public TreeNode deserialize(int[] a){
       TreeNode root = new TreeNode(a[0]);
       int i = 1;
       Queue<TreeNode> queue = new ArrayDeque<>();
       queue.add(root);
       while (!queue.isEmpty()){
           TreeNode t = queue.peek();
           queue.remove();
           if (a[i] != -1){
               t.left = new TreeNode(a[i]);
               queue.add(t.left);
           }
           i++;
           if (a[i] != -1){
               t.right = new TreeNode(a[i]);
               queue.add(t.right);
           }
           i++;
       }
       return root;
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

/*
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1. For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 10^5
-1 <= A[i] <= 10^5

Input Format : Only argument is an integer array A denoting the Level Order Traversal of the Binary Tree.
Output Format : Return the root node of the Binary Tree.

Input 1:  A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Output 1:

           1
         /   \
        2     3
       / \
      4   5
Explanation 1:
Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
Since 3, 4 and 5 each has both NULL child we had represented that using -1.

Input 2: A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
Output 2:

            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

Explanation 2:
Each element of the array denotes the value of the node. If the val is -1 then it is the NULL/None child.
Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */