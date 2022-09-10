package utils;

import utils.nodes.GraphNode;
import utils.nodes.WeightedGraphNode;

public class GraphUtil {
    public static GraphNode[] getGraph(int nodes, int[][] edges, boolean...isDirected) {
        // initialization of adjacency list array without edges
        GraphNode[] nodeList = new GraphNode[nodes + 1];
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new GraphNode(i);
        }

        // adding edges between given nodes
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            nodeList[u].connections.add(nodeList[v]);
            if(!isDirected[0]){
                nodeList[v].connections.add(nodeList[u]);
            }
        }
        return nodeList;
    }

    public static GraphNode[] getGraph(int nodes, int edges, int[] u, int[] v, boolean...isDirected) {
        // initialization of adjacency list array without edges
        GraphNode[] nodeList = new GraphNode[nodes + 1];
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new GraphNode(i);
        }

        // adding edges between given nodes
        for (int i = 0; i < edges; i++) {
            int start = u[i];
            int end = v[i];
            nodeList[start].connections.add(nodeList[end]);
            if(!isDirected[0]){
                nodeList[end].connections.add(nodeList[start]);
            }
        }
        return nodeList;
    }


    public static WeightedGraphNode[] getWeightedGraph(int nodes, int[][] edges, boolean...isDirected) {
        // initialization of adjacency list array without edges
        WeightedGraphNode[] nodeList = new WeightedGraphNode[nodes + 1];
        for (int i = 0; i < nodeList.length; i++) {
            nodeList[i] = new WeightedGraphNode(i);
        }

        // adding edges between given nodes
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            nodeList[u].connections.add(new WeightedGraphNode.PairNodeWeight(v, w));
            if(!isDirected[0]){
                nodeList[v].connections.add(new WeightedGraphNode.PairNodeWeight(u, w));
            }
        }
        return nodeList;
    }
}
