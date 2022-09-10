package _04_optional_classes._02_advanced._2022_08_14.graphs;

import utils.nodes.GraphNode;

public class _02_AddEdgesToBiPartieGraph {
    // note : color representation : 0 : not painted, 1 : red 2 : green (as example)
    int maxEdgesThatCanBeAdded(GraphNode[] g,int edges){ // edges represent number of already existing edges
        int[] c = _01_BiPartieGraphs.getColorDataFromBiPartieGraph();
        int c1 = 0, c2 = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 1) c1++; else c2++;
        }
        return ((c1*c2)-edges);
    }

}

/*
given a tree, calculate max no of edges which can be added to tree,
such that graph remains a bipartie graph
note : any tree is by default a bipartie graph
obs :  we can draw edges b/w nodes of two diff color.
 */