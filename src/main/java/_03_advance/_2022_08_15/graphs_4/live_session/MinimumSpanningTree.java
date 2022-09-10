package _03_advance._2022_08_15.graphs_4.live_session;

import java.util.List;
import static _03_advance._2022_08_15.graphs_4.live_session.MinimumSpanningTree.Pair.sort;

public class MinimumSpanningTree{
    // overall TC : E log E (for sorting)
    static class Pair<T extends Number, U>{
        public T first;
        public U second;
        public Pair(T first, U second){
            this.first = first;
            this.second = second;
        }

        static void sort(List<Pair<Integer, Pair<Integer, Integer>>> edges){
            // TODO
        }
    }

    // List< Pair<Weight, Pair<u, v>>
    int kruskalsAlgo(List<Pair<Integer, Pair<Integer, Integer>>> edges, int n){
        sort(edges);
        int[] component = new int[n+1];
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            component[i] = i;
        }
        for (int i = 0; i < edges.size(); i++) {
            Pair<Integer, Pair<Integer, Integer>> data = edges.get(i);
            int w = data.first;
            int u = data.second.first;
            int v = data.second.second;

            // union-find algorithm, TC : O(n)
            // if u and v belongs to 2 different component
            int cu = findSuperCmp(u, component);
            int cv = findSuperCmp(v, component);
            if (cu != cv){
                // assign lower component to higher component
                component[Integer.max(cu, cv)] = component[Integer.min(cu, cv)];
                ans += w; // edge from u to v considered
            }
        }
        return ans;
    }

    private int findSuperCmp(int x, int[] component) {
        if(x == component[x]) return x;
        component[x] = findSuperCmp(component[x], component); // this one steps make avg TC : O(1) for this whole function
        return component[x];
    }

    // less effecient function which takes TC : O(N)
    /*private int findSuperCmp(int x, int[] component) {
        if(x == component[x]) return x;
        return findSuperCmp(component[x], component);
    }*/

}

/*
pre requisite information:
cycle detection in undirected graph
    In a tree with N nodes, there can be max n-1 edges
    Even if one more is there it will form a cycle.

Now lets say u are given a graph which has multiple components (basically its combination of unconnected graphs)
Then,
If N is number of nodes, and C is number of components, Max no of edges we can have so that
there is no cycle is N-C

Q1 : given a undirected graph with N nodes and E edges, check if cycle exists.
Ans : calculate number no of components in graph say c,
then no cycle exists if edges E = N-C, TC : O(n+e)

observation1 : if total edges e >= N, 100% there is a cycle.
psuedo code :
step-1 :if e >= return false
step-2 : calculate no of components e == n-c

---------------------------------

MST question : given a undirected weighted connected graph, convert it  into a tree
with minimum weight.
min weight : sum of overall weights should be min.
Such a tree is called MST.


Kruskal Algo :
s1 : sort all edges
s2 : add edges one by one to form a graph, if a particular edge forms a cycle skip that edge.

checking if there is a cycle or not - "union find algorithm"

 */