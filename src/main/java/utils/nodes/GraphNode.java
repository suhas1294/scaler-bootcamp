package utils.nodes;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int value;
    public GraphNode parent;
    public int level;
    public boolean visited;
    public List<GraphNode> connections;

    public GraphNode(int value){
        this.value = value;
        this.visited = false;
        this.level = 0;
        this.parent = null;
        connections = new ArrayList<>();
    }
}
