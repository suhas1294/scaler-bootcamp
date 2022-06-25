package _03_advance._2022_06_17.tree_6.assignments;


// same as src/main/java/_03_advance/_2022_06_17/tree_6/live_session/_04_SideLinkPerfectBST.java
public class NextPointer {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        // maintain a variable which can help to get the start of each level
        TreeLinkNode level = root;
        // temp will be used to traverse each node level wise
        TreeLinkNode temp = root;
        while(level!=null) {
            temp = level;
            while(temp!=null) {
                // connect next pointer of temp's left node
                if(temp.left!= null) {
                    temp.left.next = temp.right;
                }
                // connect next pointer of temp's right node
                if(temp.right!=null && temp.next!=null){
                    temp.right.next = temp.next.left;
                }
                // move to next node in current level
                temp = temp.next;
            }
            // move to next level
            level = level.left;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}

/*
Given a binary tree, Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Assume perfect binary tree and try to solve this in constant extra space.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000
0 <= node values <= 10^9

Input Format : First and only argument is head of the binary tree A.
Output Format : Return the head of the binary tree after the changes are made.

Input 1:
     1
    /  \
   2    3

Output 1:
        1 -> NULL
       /  \
      2 -> 3 -> NULL
Explanation 1:  Next pointers are set as given in the output.

Input 2:
        1
       /  \
      2    5
     / \  / \
    3  4  6  7

Output 2:
         1 -> NULL
       /  \
      2 -> 5 -> NULL
     / \  / \
    3->4->6->7 -> NULL

Explanation 2: Next pointers are set as given in the output.
 */