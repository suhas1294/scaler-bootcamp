package _03_advance._2022_08_10.graphs_2.assignment;

import java.util.ArrayList;

public class CycleInUnDirectedGraph {
    public int solve(int A, int[][] B) {
        ArrayList < Integer > [] g = new ArrayList[A + 1];
        for (int i = 1; i <= A; i++) {
            g[i] = new ArrayList< >();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            g[u].add(v);
            g[v].add(u);
        }

        int C = connectedComponent(A, g);
        int E = B.length;
        int N = A;

        if (E > N - C) return 1;
        else return 0;
    }

    private int connectedComponent(int N, ArrayList < Integer > [] g) {
        int count = 0;
        boolean[] vis = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                DFS(g, vis, i);
                count++;
            }
        }
        return count;
    }

    private void DFS(ArrayList < Integer > [] g, boolean[] vis, int s) {
        if (vis[s]) {
            return;
        }

        vis[s] = true;

        for (int i = 0; i < g[s].size(); i++) {
            int v = g[s].get(i);
            DFS(g, vis, v);
        }
    }
}

/*
Given an undirected graph having A nodes labelled from 1 to A with M edges
given in a form of matrix B of size M x 2 where (B[i][0], B[i][1]) represents
two nodes B[i][0] and B[i][1] connected by an edge.
Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.

NOTE:
The cycle must contain atleast three nodes.
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global
variables make sure to clear them.


Problem Constraints
1 <= A, M <= 3*10^5
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given is an matrix B of size M x 2 which represents the M edges
such that there is a edge between node B[i][0] and node B[i][1].

Output Format : Return 1 if cycle is present else return 0.

Input 1:
 A = 5
 B = [  [1. 2]
        [1, 3]
        [2, 3]
        [1, 4]
        [4, 5]
     ]

Output 1:  1
Explanation 1:  There is a cycle in the graph i.e 1 -> 2 -> 3 -> 1 so we will return 1

Input 2:
 A = 3
 B = [  [1. 2]
        [1, 3]
     ]


Output 2: 0
Explanation 2: No cycle present in the graph so we will return 0.
 */