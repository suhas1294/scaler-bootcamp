package _03_advance._2022_08_12.graphs_3.assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PossibilityOfFinishing {
    public int solve(int A, int[] B, int[] C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        adj = createAdj(B, C, A);
        boolean ans = taskSchedule(A, adj);
        return ans == true ? 1 : 0;
    }

    public ArrayList<ArrayList<Integer>> createAdj(int[] A, int[] B, int N) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = A[i];
            int v = B[i];
            adj.get(u).add(v);
        }
        return adj;

    }

    public boolean taskSchedule(int N, ArrayList<ArrayList<Integer>> adj) {
        // int topo[] = new int[N];
        int indeg[] = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            for (Integer it : adj.get(i)) {
                indeg[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>(); // add only those with 0 indegree
        // because 0 indeg means no prerequired course to be done for that
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i); // add to queue
            }
        }
        int count = 0; // count
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i : adj.get(u)) {
                if (--indeg[i] == 0) { // traverse every node connected with 0 indegree
                    q.add(i);// add to q iff indegree becomes 0
                }
            }
            count++;
        }
        return count == indeg.length;
    }
}

/*
There are a total of A courses you have to take, labeled from 1 to A.
Some courses may have prerequisites, for example to take course 2 you have to
first take course 1, which is expressed as a pair: [1,2].
So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
Given the total number of courses and a list of prerequisite pairs, is it possible
for you to finish all courses?
Return 1 if it is possible to finish all the courses, or 0 if it is not possible
to finish all the courses.


Problem Constraints
1 <= A <= 6*10^4
1 <= length(B) = length(C) <= 105
1 <= B[i], C[i] <= A

Input Format
The first argument of input contains an integer A, representing the number of courses.
The second argument of input contains an integer array, B.
The third argument of input contains an integer array, C.

Output Format
Return 1 if it is possible to finish all the courses, or 0 if it is not possible
to finish all the courses.

Input 1: A = 3 B = [1, 2] C = [2, 3] Output 1: 1
Explanation 1: It is possible to complete the courses in the following order: 1 -> 2 -> 3

Input 2: A = 2 B = [1, 2] C = [2, 1] Output 2: 0
Explanation 2: It is not possible to complete all the courses.

 */