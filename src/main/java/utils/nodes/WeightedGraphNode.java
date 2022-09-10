package utils.nodes;

import java.util.ArrayList;
import java.util.List;


public class WeightedGraphNode  {
    public int value;
    public WeightedGraphNode parent;
    public int level;
    public boolean visited;
    public List<PairNodeWeight> connections;

    public static class PairNodeWeight {
        public int nodeValue;
        public int weight;

        public PairNodeWeight(int nodeValue, int weight) {
            this.nodeValue = nodeValue;
            this.weight = weight;
        }
    }

    public WeightedGraphNode(int value){
        this.value = value;
        this.visited = false;
        this.level = 0;
        this.parent = null;
        connections = new ArrayList<>();
    }
}
