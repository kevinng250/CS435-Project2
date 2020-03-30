import java.util.*;
interface Graphs{
    void addNode(final String nodeVal);
    HashSet<Node> getAllNodes();
}

class Graph{
    Map<String, List<Node>> adjList;
    List<Node> nodes;
    public Graph(){
        this.adjList = new HashMap<String, List<Node>>();
        this.nodes = new ArrayList<Node>();
    }
    void addNode(final String nodeVal){
        Node node = new Node(nodeVal);
        adjList.put(nodeVal, null);
        nodes.add(node);
    }
    void addUndirectedEdge(final Node first, final Node second){
        if(adjList.get(first.name) == null){
            List<Node> ns = new ArrayList<Node>();
            first.children = ns;
            adjList.put(first.name, ns);
        }
        if(adjList.get(second.name) == null){
            List<Node> ns = new ArrayList<Node>();
            second.children = ns;
            adjList.put(second.name, ns);
        }
        if(adjList.get(first.name).contains(second)){
            return;
        }
        adjList.get(first.name).add(second);
        adjList.get(second.name).add(first);
    }
    void removeUndirectedEdge(final Node first, final Node second){
        adjList.get(first.name).remove(second);
        adjList.get(second.name).remove(first);
    }
    HashSet<Node> getAllNodes(){
        return new HashSet<Node>(nodes);
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
//        first.children.add(second);
    }
}


