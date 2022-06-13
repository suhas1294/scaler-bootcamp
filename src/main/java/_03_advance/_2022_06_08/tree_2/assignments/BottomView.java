package _03_advance._2022_06_08.tree_2.assignments;

import java.util.*;

public class BottomView {
    public ArrayList<Integer> solve(TreeNode A) {
        return traversalVerticalOrder(A);
    }

    HashMap<Integer, ArrayList<Integer>> freqMap = new HashMap();
    Queue<Pair> que = new LinkedList();
    int maxl =0; int minl=0;

    public ArrayList<Integer> traversalVerticalOrder(TreeNode root){
        Pair rootPair = new Pair(root, 0);
        que.add(rootPair); // // Add root node to Queue

        while (!que.isEmpty()){
            Pair tempPair = que.remove();
            TreeNode temp = tempPair.treeNode;
            int level = tempPair.level;

            maxl = Math.max(maxl, level);
            minl = Math.min(minl, level);

            //Step 1. insert into HashMap < level , List<Values of TreeNode>>
            if (freqMap.containsKey(level)){
                // add to existing ArrayList
                ArrayList<Integer> currList = freqMap.get(level);
                currList.add(temp.val);
                freqMap.put(level, currList);
            }else {
                //create new new LinkedList
                ArrayList <Integer> newList = new ArrayList();
                newList.add(temp.val);
                freqMap.put(level, newList);
            }

            //Step 2.Put left level child into Queue
            if (temp.left !=null) {
                Pair leftPair = new Pair(temp.left, level - 1);
                que.add(leftPair);
            }

            //Step 3.Put right level child into Queue
            if (temp.right !=null){
                Pair rightPair = new Pair(temp.right, level + 1);
                que.add(rightPair);
            }
        }

        //Iterate frequencyMap starting from minl -->maxl and add to response list
        ArrayList<Integer> responseList = new ArrayList();
        for (int i= minl ;i<=maxl;i++){
            ArrayList<Integer> level = freqMap.get(i);
            responseList.add(level.get(level.size()-1));
        }
        return responseList;
    }

    static class Pair{
        public TreeNode treeNode;
        public Integer level;
        //constructor
        public Pair(TreeNode treeNode, Integer level){
            this.treeNode = treeNode;
            this.level = level;
        }
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
Given a Binary Tree A consisting of N integer nodes, you need to print the bottom
view from left to right. A node x is there in output if x is the bottom-most node
at its horizontal distance. Horizontal distance of left child of a node x is equal to
horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

Note: If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal.

Problem Constraints : 0 <= N <= 10⁵

Input Format : First and only Argument represents the root of binary tree A.
Output Format : Return an one-dimensional integer array denoting the bottom
view of A from left to right.

Input:1

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

Output1 : [5, 10, 3, 14, 25]
Explanation:1
Node 5 has a horizontal distance of -2 and it is the bottom-most node at this distance.
Node 10 has a horizontal distance of -1 and it is the bottom-most node at this distance.
Node 3 has a horizontal distance of 0 and it is the bottom-most node at this distance.
Node 14 has a horizontal distance of 1 and it is the bottom-most node at this distance.
Node 25 has a horizontal distance of 2 and it is the bottom-most node at this distance.

Input:2

                      20
                    /    \
                  8       22
                /   \    /   \
              5      3  4    25
                    / \
                  10    14

Output2 : [5, 10, 4, 14, 25]
Explanation:2
 Node 5 has a horizontal distance of -2 and it is the bottom-most node at this distance.
 Node 10 has a horizontal distance of -1 and it is the bottom-most node at this distance.
 Node 3 and Node 4 has a horizontal distance of 0 and they are the bottom-most node at this distance but we will output the one who comes later in level-order traversal so we output 4.
 Similarly for Node 14 and 25
 */