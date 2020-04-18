import java.util.*;

class DirectedGraph implements Graphs{

    Map<String, List<Node>> adjList;
    List<Node> nodes;

    public DirectedGraph(){
        this.adjList = new HashMap<String, List<Node>>();
        this.nodes = new ArrayList<Node>();
    }
    public void addNode(final String nodeVal){
        Node node = new Node(nodeVal);
        adjList.put(nodeVal, null);
        nodes.add(node);
    }
    public void addDirectedEdge(final Node first, final Node second){
        if(adjList.get(first.name) == null){
            List<Node> ns = new ArrayList<Node>();
            first.children = ns;
            adjList.put(first.name, ns);
        }
        if(adjList.get(first.name).contains(second.name)){
            return;
        }
        adjList.get(first.name).add(second);
    }
    public void removeDirectedEdge(final Node first, final Node second){
        if(adjList.get(first.name) == null || !adjList.get(first.name).contains(second)){
            return;
        }
        adjList.get(first.name).remove(second);
        first.children.remove(second);
    }
    public HashSet<Node> getAllNodes(){
        return new HashSet<Node>(nodes);
    }


}
