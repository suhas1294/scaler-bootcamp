package _03_advance._2022_08_10.graphs_2.live_session;

import utils.GraphUtil;
import utils.nodes.GraphNode;

import java.util.Arrays;

public class _02_NumberOfConnectedComponents {
    // tc : O(e), sc : O(n+e), e being dominating, sc will be O(E)
    int components(int n, int e, int[] u, int[] v){
        GraphNode[] graph = GraphUtil.getGraph(n, e, u, v);
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        int counter = 0;
        for (int i = 1; i <= n ; i++) {
            if (!visited[i]){
                dfs(graph, visited, i);
            }
        }
        return counter;
    }

    void dfs(GraphNode[] graph, boolean[] visited, int s){
        if (visited[s]) return;
        visited[s] = true;
        for (int i = 0; i < graph[s].connections.size(); i++) {
            int v = graph[s].connections.get(i).value;
            dfs(graph, visited, v);
        }
    }
}

/*
given a undirected graph, find number of connected components. A component is said to be connected if
from single node we can visit all other nodes inside component
 */