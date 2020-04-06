import java.util.*;

public class GridGraph {
    class GridNode{
        String name;
        int x;
        int y;
        List<GridNode> children;
        public GridNode(final int x, final int y, String nodeVal){
            this.x = x;
            this.y = y;
            this.name = nodeVal;
            children = new ArrayList<GridNode>();
        }
    }

    Map<String, List<GridNode>> adjList;
    List<List<GridNode>> nodes;
    public GridGraph(){
        this.adjList = new HashMap<String, List<GridNode>>();
        this.nodes = new ArrayList<List<GridNode>>();
    }
    void addGridNode(final int x, final int y, final String nodeVal){
        GridNode node = new GridNode(x,y,nodeVal);
        adjList.put(nodeVal, new ArrayList<GridNode>());
        int size = nodes.size();
        if(x == size){
            nodes.add(x, new ArrayList<GridNode>());
        }
        nodes.get(x).add(y, node);
    }
    void addUndirectedEdge(final GridNode first, final GridNode second){
        if(areNeighbors(first, second)){
            if(first.children.contains(second)){
                return;
            }
            first.children.add(second);
            adjList.put(first.name, first.children);
            second.children.add(first);
            adjList.put(second.name, second.children);
        }
    }
    void removeUndirectedEdge(final GridNode first, final GridNode second){
        if(areNeighbors(first,second)){
            first.children.remove(second);
            adjList.put(first.name, first.children);
            second.children.remove(first);
            adjList.put(second.name, second.children);
        }
    }
    static boolean areNeighbors(final GridNode first, final GridNode second){
        double firstX = first.x;
        double firstY = first.y;
        double secondX = second.x;
        double secondY = second.y;
        double distance = Math.sqrt((Math.pow((firstY - secondY),2) + Math.pow((firstX - secondX),2)));
        if(distance == 1){
            return true;
        }
        return false;
    }
    HashSet<GridNode> getAllNodes(){
        HashSet<GridNode> ret = new HashSet<GridNode>();
        for(int i = 0; i < nodes.size(); i++){
            for(int j = 0; j < nodes.get(i).size(); i++){
                ret.add(nodes.get(i).get(j));
            }
        }
        return ret;
    }
}
