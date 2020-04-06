import java.util.*;

public class WeightedGraph {
    Map<String, Map<Node, Integer>> adjList;
    List<Node> nodes;
    static class Node{
        String name;
        Map<Node, Integer> children;
        public Node(String nodeVal){
            this.name = nodeVal;
            children = new HashMap<Node, Integer>();
        }
    }
    public WeightedGraph(){
        this.adjList = new HashMap<String, Map<Node, Integer>>();
        this.nodes = new ArrayList<Node>();
    }
    public void addNode(final String nodeVal){
        Node node = new Node(nodeVal);
        adjList.put(nodeVal, new HashMap<Node, Integer>());
        nodes.add(node);
    }
    public void addWeightedEdge(final Node first, final Node second, final int edgeWeight){

        adjList.get(first.name).put(second, edgeWeight);
        first.children.put(second, edgeWeight);
    }
    public void removeDirectedEdge(final Node first, final Node second){
        adjList.get(first.name).remove(second);
        first.children.remove(second);
    }
    HashSet<Node> getAllNodes(){
        return new HashSet<Node>(nodes);
    }
}
