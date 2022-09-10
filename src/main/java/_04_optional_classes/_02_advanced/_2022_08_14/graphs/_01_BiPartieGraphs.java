package _04_optional_classes._02_advanced._2022_08_14.graphs;

import utils.nodes.GraphNode;

import java.util.ArrayDeque;
import java.util.Queue;
public class _01_BiPartieGraphs {

    // note that the graph given to u may have multiple unconnected components
    boolean isBiPartieGraph(GraphNode[] g, int n){
        int[] c = new int[n+1]; // color represents of each node
        for (int i = 1; i <= n; i++) {
            if (c[i] != 0){ // the component is already covered, continue
                continue;
            }
            c[i] = 1; // starting with coloring of new component, lets take 1st node although we can take any
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);

            while (!queue.isEmpty()){
                int u = queue.poll();
                queue.remove();
                // get adjacent nodes of u and color them
                for (int j = 0; j < g[u].connections.size(); j++) {
                    int v = g[u].connections.get(j).value;
                    // check if its already colored,if not then only color it
                    if (c[u] == c[v]){ // not bipartie
                        return false;
                    }
                    if (c[v] == 0){ // not yet colored
                        c[v] = 3 - c[u];
                        queue.add(v);
                    }
                }
            }
        }
        return true; // note that this color[] also contains how many nodes have color c1 and c2
    }

    public static int[] getColorDataFromBiPartieGraph(){
        return new int[]{}; // return c[] from above function, i.e., from isBiPartieGraph()
    }
}

/*
background :
we can color each node of a graph with different color
Now, if we are able to calculate (minimum number of colors) using which we can
color all adjacent nodes of a graph such that no two adjacent colors are same.
Then such a graph is called chromatic graph and the (min colors required) is called as
chromatic number.
When the chromatic number of a graph is exactly 2, then such a graph is called bipartie graph.
// note : color representation : 0 : not painted, 1 : red 2 : green (as example)
 */