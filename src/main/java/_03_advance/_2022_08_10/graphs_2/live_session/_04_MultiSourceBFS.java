package _03_advance._2022_08_10.graphs_2.live_session;

import utils.GraphUtil;
import utils.nodes.GraphNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class _04_MultiSourceBFS {
    // only change is push all source nodes (initialize in queue) and apply bfs
    public void bfsAlso(int n, int[][] edges, int[] source, int dest){
        GraphNode[] nodeList = GraphUtil.getGraph(n, edges);
        // Using queue, we are checking if are establishing problem requirements
        Queue<GraphNode> queue = new ArrayDeque<>();
        for (int s: source) {
            queue.add(nodeList[s]);
            nodeList[s].visited = true;
        }
        while(!queue.isEmpty()){
            // step-1 : get front of queue
            GraphNode cu = queue.poll(); // returns front of queue
            // step-2 : traverse adjacency list of cu
            for (GraphNode cv : cu.connections) {
                if (!cv.visited){
                    cv.visited = true;
                    queue.add(cv);
                    cv.level = cu.level + 1;
                    cv.parent = cu;
                }
            }
        }
    }

}

/*
given n nodes and multiple source s1, s2, s3, find the length of shortest
path for all the nodes to any of the source nodes
 */