package _03_advance._2022_06_06.tree_1.live_session;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _04_GetPathToNodeFromRoot {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    public int[] getPath(TreeNode A, int B) {
        boolean flag = true;
        recursion(A, B);
        return arr.stream().mapToInt(i -> i).toArray();
    }
    public boolean recursion(TreeNode A, int B) {
        if(A==null) return false;
        arr.add(A.val);
        if(A.val==B)return true;
        if(recursion(A.left, B) || recursion(A.right, B)) return true;
        arr.remove(arr.size()-1);
        return false;
    }

    // using stacks
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    public List<Integer> getPath2(TreeNode A, int B) {
        boolean flag = traverse(A,B);
        while(!stack.empty()){
            result.add(stack.peek());
            stack.pop();
        }
        return result;
    }
    public boolean traverse(TreeNode A, int B){
        if(A == null) return false;
        if(A.val == B || traverse(A.left,B) || traverse(A.right,B)){
            stack.push(A.val);
            return true;
        }
        return false;
    }

    class TreeNode {
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

// given a BT which contains all the unique values, get the path of node k (assume its always present)

/*
Given a Binary Tree A containing N nodes, you need to find the path from Root to a given node B.

NOTE:
No two nodes in the tree have the same data values.
You can assume that B is present in tree A and a path always exists.

Problem Constraints
1 <= N <= 10⁵
1 <= Data Values of Each Node <= N
1 <= B <= N

Input Format
First Argument represents pointer to the root of binary tree A.
Second Argument is an integer B denoting the node number.
Explanation 1:
 We need to find the path from root node to node with data value 5.
 So the path is 1 -> 2 -> 5 so we will return [1, 2, 5]

Output Format
Return an one-dimensional array denoting the path from Root to the node B in order.

Input 1:
 A =
           1
         /   \
        2     3
       / \   / \
      4   5 6   7

B = 5
Output 1: [1, 2, 5]

Input 2:
 A =
            1
          /   \
         2     3
        / \ .   \
       4   5 .   6

B = 1
Output 2: [1]

Explanation 2:
 We need to find the path from root node to node with data value 1.
 As node with data value 1 is the root so there is only one node in the path.
 So we will return [1]
 */