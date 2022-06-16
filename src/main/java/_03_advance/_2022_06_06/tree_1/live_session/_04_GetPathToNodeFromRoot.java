package _03_advance._2022_06_06.tree_1.live_session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
funda:
1. if node.data = target, return true
2. else search in while LST
3. else search in while RST
4. if the any of LST/RST is giving true, then path exists, so add current node to ans list
 */
public class _04_GetPathToNodeFromRoot {

    // taught in class
    ArrayList<Integer> ans = new ArrayList<>();
    public int[] findPathFromRoot(TreeNode root, int target) {
        check(root, target);
        Collections.reverse(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    boolean check(TreeNode root, int k){
        if (root == null) return false;
        if(root.val == k){
            ans.add(root.val);
            return true;
        }
        if(check(root.left, k) || check(root.right, k) ){
            ans.add(root.val);
            return true;
        }else{
            return false;
        }
    }

    // external solutions
    ArrayList<Integer> arr = new ArrayList<Integer>();
    public int[] getPath(TreeNode root, int target) {
        recursion(root, target);
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public boolean recursion(TreeNode root, int target) {
        if (root == null) return false;
        arr.add(root.val);
        if (root.val == target) return true;
        if (recursion(root.left, target) || recursion(root.right, target)) return true;
        arr.remove(arr.size() - 1);
        return false;
    }

    // using stacks
    ArrayList<Integer> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<Integer> getPath2(TreeNode root, int target) {
        while (!stack.empty()) {
            result.add(stack.peek());
            stack.pop();
        }
        return result;
    }

    public boolean traverse(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target || traverse(root.left, target) || traverse(root.right, target)) {
            stack.push(root.val);
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
            left = null;
            right = null;
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