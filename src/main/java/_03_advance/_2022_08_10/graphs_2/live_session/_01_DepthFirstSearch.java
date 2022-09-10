package _03_advance._2022_08_10.graphs_2.live_session;

import utils.GraphUtil;
import utils.nodes.GraphNode;

import java.util.Arrays;

public class _01_DepthFirstSearch {
    // depth first search, tc : O(E), sc : O(E + n + n) = last n for stack space
    // note: first shortest path ALWAYS USE BFS, just to check whether source and destination are connected, then use DFS
    void dfs(GraphNode[] graph, boolean[] visited, int s){
        if (visited[s]) return;
        visited[s] = true;
        for (int i = 0; i < graph[s].connections.size(); i++) {
            int v = graph[s].connections.get(i).value;
            dfs(graph, visited, v);
        }
    }

    /**
     *
     * @param n number of nodes
     * @param e number of edges
     * @param u edge start
     * @param v edge end
     * @param s source
     * @param d destination
     * @return whether we can travel from source to destination
     */
    boolean path(int n, int e, int[] u, int[] v, int s , int d){
        GraphNode[] graph = GraphUtil.getGraph(n, e, u, v);
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        dfs(graph, visited, s);
        return visited[d];
    }
}
