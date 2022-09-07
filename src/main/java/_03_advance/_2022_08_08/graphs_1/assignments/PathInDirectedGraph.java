package _03_advance._2022_08_08.graphs_1.assignments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {
        //preparing adjacency list
        ArrayList<Integer>[] g = buildAdjacencyList(A, B);
        boolean[] vis = new boolean[A + 1];
        for (int i = 1; i <= A; i++) {
            if (!vis[i]) {
                BFS(g, 1, A, vis);
            }
        }

        boolean isPath = vis[A];
        return isPath ? 1 : 0;
    }

    private void BFS(ArrayList<Integer>[] g, int s, int d, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        while (q.size() > 0) {
            int u = q.poll();

            for (int i = 0; i < g[u].size(); i++) {
                int v = g[u].get(i);
                if (!vis[v]) {
                    q.add(v);
                    vis[v] = true;
                }
            }
        }
    }

    private ArrayList<Integer>[] buildAdjacencyList(int A, int[][] B) {
        ArrayList<Integer>[] g = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            g[u].add(v);
        }
        return g;
    }
}

/*
Given an directed graph having A nodes labelled from 1 to A containing M edges
given by matrix B of size M x 2such that there is a edge directed from node
B[i][0] to node B[i][1].
Find whether a path exists from node 1 to node A.
Return 1 if path exists else return 0.

NOTE:
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables
make sure to clear them.


Problem Constraints
2 <= A <= 10^5
1 <= M <= min(200000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M edges such
that there is a edge directed from node B[i][0] to node B[i][1].

Output Format : Return 1 if path exists between node 1 to node A else return 0.

Input 1:

 A = 5
 B = [  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]

Output 1: 0
Explanation 1: The given doens't contain any path from node 1 to node 5 so we will return 0.

Input 2:
 A = 5
 B = [  [1, 2]
        [2, 3]
        [3, 4]
        [4, 5] ]
Output 2: 1
Explanation 2: Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.
 */