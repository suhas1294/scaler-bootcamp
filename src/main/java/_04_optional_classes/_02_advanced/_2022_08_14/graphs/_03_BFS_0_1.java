package _04_optional_classes._02_advanced._2022_08_14.graphs;

import utils.nodes.WeightedGraphNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _03_BFS_0_1 {
    // TC :O(e), sc : O(N + N +E) = O(e)
    boolean bfs01(WeightedGraphNode[] g, int n, int s, int d){
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] blasted = new boolean[n+1]; // if node is already blasted or not
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addFirst(s);
        dist[s] = 0;
        blasted[s] = false; // we have visited but not blasted

        while (!dq.isEmpty()){
            int u = dq.pollFirst(); // front
            dq.removeFirst();
            if (blasted[u]) continue;
            blasted[u] = true; // we removed from deque

            for (int i = 0; i < g[u].connections.size(); i++) {
                int v = g[u].connections.get(i).nodeValue;
                int w = g[u].connections.get(i).weight;
                if (dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                    if (w == 0){
                        dq.addFirst(v);
                    }else{
                        dq.addLast(v);
                    }
                }
            }
        }

        return blasted[d];
    }
}

/*
given a weighted graph, where weight can either be 1 or 0
find the cost of shortest path from source to destination
If we apply Dijkstra's algo, tc : O(E log E) , sc : O(e)
So we reduce sc, we make some tweek in Dijkstra and instead of min heap we will use Deqeue
all lesser number we insert it at queue front and larges number we insert at queue back
observations related to dequeue :
1. at any given point of time, we can have only 2 distances
2. at every node pick node with min distance

deque steps :
1.remove node from front.
2.check its adjacent nodes
    If we update distance of adjacent nodes,
        if edge w = 0, add front
        if edge w = 1, add back
    if already node is deleted, we wont iterate on node's connections


 */