package _03_advance._2022_06_20.tree_7.live_session;

import java.util.*;

// Serialization of BT using level order traversal
public class _01_SerializationOfBTLevelOrder { // TC: O(n), sc : O(n)
    public static List<Integer> serialize(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode t = queue.peek();
            queue.remove();
            if (t == null){
                list.add(-1);
                continue;
            }
            list.add(t.val);
            queue.add(t.left);
            queue.add(t.right);
        }
        return list;
    }

    // assignment question signature
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> output = new ArrayList<Integer>();
        queue.add(A);
        while(!queue.isEmpty()) {
            // get the first element from queue
            TreeNode currentNode = queue.poll();
            if(currentNode == null) {
                // if currentNode is null, insert -1 in output
                output.add(-1);
            } else {
                // if currentNode is not null, add left and right to queue
                // insert currentNode value in output
                output.add(currentNode.val);
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }
        return output;
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
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree
in the described format.Serialize means encode it into a integer array denoting the Level Order
Traversal of the given Binary Tree.
NOTE:
In the array, the NULL/None child is denoted by -1. For more clarification check the Example Input.

Problem Constraints
1 <= number of nodes <= 10^5

Input Format : Only argument is a A denoting the root node of a Binary Tree.
Output Format : Return an integer array denoting the Level Order Traversal of the given Binary Tree.

Input 1:

           1
         /   \
        2     3
       / \
      4   5
Output 1: [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
Explanation 1: The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5 , -1, -1, -1, -1, -1, -1].
Since 3, 4 and 5 each has both NULL child we had represented that using -1.

Input 2:
            1
          /   \
         2     3
        / \     \
       4   5     6

Output 2: [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
Explanation 2: The Level Order Traversal of the given tree will be [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1].
 Since 3 has left child as NULL while 4 and 5 each has both NULL child.
 */