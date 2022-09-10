package _03_advance._2022_08_10.graphs_2.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {
    //TC: O(n + m) => n = no of nodes, m = no of edges
    //SC: O(n + m) adjacency list + O(n) for color array
    public int solve(int A, int[][] B) {
        int n = A;
        // initialize colors array with -1
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // step 1- build adjacency list
        List<List<Integer>> list = buildAdjacencyList(n, B);


        for (int i = 0; i < n; i++) {
            // this loop is required if there are multiple connected components
            if (color[i] == -1) {
                // mark source as visited and give one of the color
                color[i] = 1;
                if (!isBipartiteGraph(i, list, color)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    // DFS traversal to check if given graph is Bipartite
    private boolean isBipartiteGraph(int source, List<List<Integer>> list, int[] color) {

        List<Integer> neighbors = list.get(source);
        for (int i = 0; i < neighbors.size(); i++) {
            int currNode = neighbors.get(i);
            if (color[currNode] == -1) {
                // if not already visited, give opposite color to neighbor
                color[currNode] = color[source] ^ 1;
                if (!isBipartiteGraph(currNode, list, color)) {
                    return false;
                }
            }
            if (color[currNode] == color[source]) {
                // if any of the neighbors have same color, then it is not bipartite graph
                return false;
            }
        }
        return true;
    }

    // build adjacency list for undirected graph
    private List<List<Integer>> buildAdjacencyList(int n, int[][] B) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return list;
    }
}

/*
Given a undirected graph having A nodes. A matrix B of size M x 2 is
given which represents the edges such that there is an edge between B[i][0] and B[i][1].
Find whether the given graph is bipartite or not.
A graph is bipartite if we can split it's set of nodes into two independent
subsets A and B such that every edge in the graph has one node in A and another node in B

Note:
There are no self-loops in the graph.
No multiple edges between two pair of vertices.
The graph may or may not be connected.
Nodes are Numbered from 0 to A-1.
Your solution will run on multiple testcases. If you are using global
variables make sure to clear them.

Problem Constraints
1 <= A <= 100000
1 <= M <= min(A*(A-1)/2,200000)
0 <= B[i][0],B[i][1] < A

Input Format
The first argument given is an integer A.
The second argument given is the matrix B.

Output Format : Return 1 if the given graph is bipartide else return 0.

Input 1:  A = 2 B = [ [0, 1] ]
Output 1: 1
Explanation 1: Put 0 and 1 into 2 different subsets.

Input 2: A = 3 B = [ [0, 1], [0, 2], [1, 2] ]
Output 2: 0
Explanation 2: It is impossible to break the graph down to make two different subsets for bipartite matching
 */