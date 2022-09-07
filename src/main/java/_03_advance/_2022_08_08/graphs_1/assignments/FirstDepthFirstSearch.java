package _03_advance._2022_08_08.graphs_1.assignments;

import java.util.ArrayList;
import java.util.Stack;

public class FirstDepthFirstSearch {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(int[] A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A.length; i++) {
            adj.add(new ArrayList<>());
        }
        //form a edge
        for (int i = 1; i < A.length; i++) {
            adj.get(A[i]).add(i + 1);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(C);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == B) return 1;
            for (Integer child : adj.get(node)) {
                stack.push(child);
            }
        }
        return 0;
    }
}

/*
You are given N towns (1 to N). All towns are connected via unique directed
path as mentioned in the input.Given 2 towns find whether you can reach the
first town from the second without repeating any edge.
B C : query to find whether B is reachable from C.
Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
There exist a directed edge from A[i] to i+1 for every 1 <= i < N.
Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.

Problem Constraints : 1 <= N <= 100000

Input Format
First argument is vector A
Second argument is integer B
Third argument is integer C

Output Format: Return 1 if reachable, 0 otherwise.

Input 1:
 A = [1, 1, 2]
 B = 1
 C = 2
Output 1:  0
Explanation 1: Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.

Input 2:
 A = [1, 1, 2]
 B = 2
 C = 1
Output 2: 1
Explanation 2: Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */