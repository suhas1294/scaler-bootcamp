package _03_advance._2022_08_12.graphs_3.live_session;

import utils.nodes.GraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _02_TopologicalSort {
    // TC : O(N +E +E) = O(E), sc : O(E+N)
    void TopoSort(GraphNode[] g, int n) {
        int[] incomingEdges = new int[n + 1];
        for (int i = 1; i <= n; i++) { // TC : O(E)
            for (int j = 0; j < g[i].connections.size(); j++) {
                int v = g[i].connections.get(j).value;
                incomingEdges[v]++; // increase incoming edge count
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) { // TC : O(N)
            if (incomingEdges[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) { // TC : O(E)
            int u = queue.poll(); // get node u
            System.out.println(u);
            queue.remove(); // remove front node from queue
            for (int i = 0; i < g[u].connections.size(); i++) {
                int v = g[u].connections.get(i).value;
                incomingEdges[v]--;// reduce incoming edge count by 1
                if (incomingEdges[v] == 0) queue.add(v);
            }
        }
    }

    // ------------ assignment solution -----------------
    public int[] solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int[] topo = new int[A];
        adj = createAdj(A, B);
        int indeg[] = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            for (Integer it : adj.get(i)) {
                indeg[it]++;
            }
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        int ind = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[ind++] = u;
            for (int i : adj.get(u)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
            count++;
        }
        if (count < A) {
            return new int[0];
        }
        return topo;
    }

    public ArrayList<ArrayList<Integer>> createAdj(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            adj.get(B[i][0]).add(B[i][1]);
        }
        return adj;
    }
}

/*
Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given
which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such
that for every directed edge uv, vertex u comes before v in the ordering. Topological
Sorting for a graph is not possible if the graph is not a DAG.
Return the topological ordering of the graph and if it doesn't exist then return an empty array.
If there is a solution return the correct ordering. If there are multiple solutions print the
lexographically smallest one.
Ordering (a, b, c) is said to be lexographically smaller than
ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:
There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global
variables make sure to clear them.


Problem Constraints
2 <= A <= 10^4
1 <= M <= min(100000,A*(A-1))
1 <= B[i][0], B[i][1] <= A

Input Format
The first argument given is an integer A representing the number of nodes in the graph.
The second argument given a matrix B of size M x 2 which represents the M
edges such that there is a edge directed from node B[i][0] to node B[i][1].

Output Format
Return a one-dimensional array denoting the topological ordering of the graph and
it it doesn't exist then return empty array.

Input 1:
 A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]
Output 1: [5, 6, 1, 3, 4, 2]
Explanation 1: The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]


Input 2:

 A = 3
 B = [  [1, 2]
        [2, 3]
        [3, 1] ]
Output 2: []
Explanation 2: The given graph contain cycle so topological ordering not possible we will return empty array.
 */
