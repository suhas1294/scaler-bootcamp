package _03_advance._2022_08_10.graphs_2.assignment;

import java.util.*;

// this is repetition of some problem here :
// src/main/java/_04_optional_classes/_02_advanced/_2022_08_14/graphs
public class ConstructRoads {
    public static final int MOD = 1000000007;

    public int bfs(int source, List<List<Integer>> adjList, boolean[] visited, int A) {
        int n = adjList.size();
        boolean ans = true;
        int[] color = new int[n];
        long c1 = 0, c2 = 0; //Color1 count, Color2 count
        Arrays.fill(color, 0);
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(source);
        visited[source] = true;
        color[source] = 1;
        c1++;

        while (!bfs.isEmpty()) {
            int front = bfs.poll();
            int size = adjList.get(front).size();
            for (int u : adjList.get(front)) {
                if (visited[u]) {
                    if (color[u] == color[front]) {
                        ans = false;
                    }
                } else {
                    visited[u] = true;
                    color[u] = color[front] ^ 1;
                    if (color[u] == 1) c1++;
                    else c2++;
                    bfs.add(u);
                }
            }
        }
        if (!ans) return 0;
        //A-1 are already existing edges and from c1 to c2 we will get number of edges as c1 * c2
        //Newly added edges
        return (int) (Math.max(0, (c1 * c2) - (A - 1)) % MOD);
    }

    public int solve(int A, int[][] B) {
        //We will create an adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; ++i) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[A + 1];
        Arrays.fill(visited, false);
        for (int i = 0; i < B.length; ++i) {
            graph.get(B[i][0]).add(B[i][1]);
            graph.get(B[i][1]).add(B[i][0]);
        }
        return bfs(1, graph, visited, A);
    }
}

/*
A country consist of N cities connected by N - 1 roads. King of that country want to
construct maximum number of roads such that the new country formed remains bipartite country.
Bipartite country is a country, whose cities can be partitioned into 2 sets in
such a way, that for each road (u, v) that belongs to the country, u and v belong to
different sets. Also, there should be no multiple roads between two cities and no self loops.
Return the maximum number of roads king can construct. Since the answer could be large
return answer % 10^9 + 7.
NOTE: All cities can be visited from any city.

Problem Constraints
1 <= A <= 10^5
1 <= B[i][0], B[i][1] <= N

Input Format
First argument is an integer A denoting the number of cities, N.
Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e. there is a road between cities B[i][0] and B[1][1] .

Output Format
Return an integer denoting the maximum number of roads king can construct.

Input 1:
 A = 3
 B = [
       [1, 2]
       [1, 3]
     ]

Output 1: 0
Explanation 1: We can't construct any new roads such that the country remains bipartite.

Input 2:
 A = 5
 B = [
       [1, 3]
       [1, 4]
       [3, 2]
       [3, 5]
     ]

Output 2: 2

Explanation 2: We can add two roads between cities (4, 2) and (4, 5).
 */