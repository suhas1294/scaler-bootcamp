package _03_advance._2022_08_17.graphs_5.live_session;

import java.util.Arrays;
import java.util.List;

public class _01_BellmanFordAlgo {
    // dijkstra's algo wont work well with negative edges.
    // bellman ford logic : similar to dijkstra's algo, but instead of
    // iterating through each node , iterate through each edge and update nodes.
    // repear this for n-1 times. n represents number of nodes.
    // Note  : cannot be applied on graphs having negative cycle

    // List<Pair<u, Pair<v, w>>> edges
    // TC : O(EN), sc(N)
    void bellmanFord(List<Pair<Integer, Pair<Integer, Integer>>> edges, int n, int s){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int e = edges.size();
        for (int k = 1; k < n; k++) {
            boolean updated = false; // flag used to check if dist value changed from prev iteration
            for (int i = 0; i < edges.size(); i++) {
                Pair<Integer, Pair<Integer, Integer>> data = edges.get(i);
                int u = data.first;
                int v = data.second.first;
                int w = data.second.second;
                if (dist[u] !=  Integer.MAX_VALUE && (dist[u] + w < dist[v])){ // to make sure we dont add any more to infinity
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }
            if (!updated) break;
        }
    }

    static class Pair<T extends Number, U>{
        public T first;
        public U second;
        public Pair(T first, U second){
            this.first = first;
            this.second = second;
        }
    }
}
