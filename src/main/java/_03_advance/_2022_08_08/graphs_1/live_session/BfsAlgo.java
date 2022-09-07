package _03_advance._2022_08_08.graphs_1.live_session;

import java.util.*;

class GraphNode{
    int value;
    GraphNode parent;
    int level;
    boolean visited;
    List<GraphNode> connections;

    public GraphNode(int value){
        this.value = value;
        this.visited = false;
        this.level = 0;
        this.parent = null;
        connections = new ArrayList<>();
    }
}

class WeightedGraphNode extends GraphNode{
    Map<GraphNode, Integer> weightMap;
    public WeightedGraphNode(int value){
        super(value);
        this.weightMap = new HashMap<>();
    }
}

class Result{
    boolean canBereachedFromGivenSource;
    int level;
    List<Integer> pathToReachFromGivenSrc;

    public Result(boolean canBereachedFromGivenSource, int level){
        this.canBereachedFromGivenSource = canBereachedFromGivenSource;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Result{" +
                "canBereachedFromGivenSource=" + canBereachedFromGivenSource +
                ", level=" + level +
                ", pathToReachFromGivenSrc=" + pathToReachFromGivenSrc +
                '}';
    }
}

public class BfsAlgo {
    // here edges[i][j] represents edge from edges to j
    // n represents number of nodes
    public Result bfsAlso(int n, int[][] edges, int source, int dest){
        // initialization of adjacency list array without edges
        GraphNode[] nodeList = new GraphNode[n+1];
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new GraphNode(i);
        }

        // adding edges between given nodes
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            nodeList[u].connections.add(nodeList[v]);
            nodeList[v].connections.add(nodeList[u]);
        }

        // Using queue, we are checking if are establishing problem requirements
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.add(nodeList[source]);
        nodeList[source].visited = true;
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

        boolean canTargetBeReached = nodeList[dest].visited;
        int level = nodeList[dest].level;
        Result result = new Result(canTargetBeReached, level);
        List<Integer> path = new ArrayList<>();

        GraphNode parent = nodeList[dest].parent;
        path.add(dest);
        while (parent != null && parent.level != 0){
            path.add(parent.value);
            parent = parent.parent;
        }
        path.add(source);
        Collections.reverse(path);
        result.pathToReachFromGivenSrc = path;
        return result;
    }

    public static void main(String[] args) {
        int n = 6; // number of nodes
        int[][] edges = new int[][] {
                {1, 2},
                {1, 4},
                {2, 4},
                {2, 3},
                {3, 5},
                {5, 6},
                {4, 5},
        };
        int source = 1;
        int dest = 6;
        Result result = new BfsAlgo().bfsAlso(n, edges, source, dest);
        System.out.println(result);
    }
}

/*
1. construct a graph using adjacency list
2. find whether a path exists between two given nodes
3. find the shortest path between two nodes / the least edges required to travel between two nodes.
4. When you find the shortest path, also list out the path on how to traverse.
 */