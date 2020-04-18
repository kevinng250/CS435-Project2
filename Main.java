import java.util.*;

public class Main {
    static Graph createRandomUnweightedGraphIter(int n){
        Graph graph = new Graph();
        for(int i = 0; i < n; i++){
            graph.addNode(Integer.toString(i));
        }
        Random rand = new Random();
        System.out.println("Edges: ");
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(i == j){
                    continue;
                }
                int num = rand.nextInt(10);
                if(num < 4){
                    graph.addUndirectedEdge(graph.nodes.get(i), graph.nodes.get(j));
                    System.out.println(graph.nodes.get(i).name + ", " + graph.nodes.get(j).name);
                    //Prints out the pair of connected vertices
                }
            }
        }
        return graph;
    }
    static Graph createLinkedList(int n){
        Graph g = new Graph();
        g.addNode("1");
        for(int i = 2; i < n + 1; i++){
            g.addNode(Integer.toString(i));
            g.addDirectedEdge(g.nodes.get(i - 2), g.nodes.get(i - 1));
        }
        return g;
    }
    static ArrayList<Node> BFTRecLinkedList(final Graph graph){
        return GraphSearch.BFTRec(graph);
    }
    static ArrayList<Node> BFTIterLinkedList(final Graph graph){
        return GraphSearch.BFTIter(graph);
    }
    static DirectedGraph createRandomDAGIter(final int n){
        DirectedGraph dag = new DirectedGraph();
        for(int i = 0; i < n; i++){
            dag.addNode(Integer.toString(i));
        }
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(i == j){
                    continue;
                }
                int num = rand.nextInt(10);
                if(num < 4){
                    dag.addDirectedEdge(dag.nodes.get(i), dag.nodes.get(j));
                }
            }
        }
        return dag;
    }


    static WeightedGraph createRandomCompleteWeightedGraph(final int n){
        WeightedGraph graph = new WeightedGraph();
        for(int i = 0; i < n; i++){
            graph.addNode(Integer.toString(i));
        }
        Random rand = new Random();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                int num = rand.nextInt(10);
                graph.addWeightedEdge(graph.nodes.get(i), graph.nodes.get(j), num);

            }
        }
        return graph;
    }
    static WeightedGraph createWeightedLinkedList(final int n){
        WeightedGraph graph = new WeightedGraph();
        for(int i = 0; i < n; i++){
            graph.addNode(Integer.toString(i));
        }
        for(int i = 1; i < n; i++){
            graph.addWeightedEdge(graph.nodes.get(i-1), graph.nodes.get(i), 1);
        }
        return graph;
    }
    static HashMap<WeightedGraph.Node, Integer> dijkstras(final WeightedGraph.Node start){
        HashMap<WeightedGraph.Node, Integer> distances = new HashMap<WeightedGraph.Node, Integer>();
        List<WeightedGraph.Node> visited = new ArrayList<WeightedGraph.Node>();
        List<WeightedGraph.Node> unvisited = new ArrayList<WeightedGraph.Node>();
        distances.put(start, 0);
        WeightedGraph.Node curr = start;
        while(curr != null && distances.get(curr) != Integer.MAX_VALUE){
            visited.add(curr);
            unvisited.remove(curr);
            for(WeightedGraph.Node node : curr.children.keySet()){
                if(!visited.contains(node)){
                    if(!distances.containsKey(node)){
                        distances.put(node, Integer.MAX_VALUE);
                    }
                    if((distances.get(curr) + curr.children.get(node)) < distances.get(node)){
                        distances.put(node, distances.get(curr) + curr.children.get(node));
                        if(!unvisited.contains(node)) {
                            unvisited.add(node);
                        }
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < unvisited.size(); i++){
                if(distances.get(unvisited.get(i)) < min){
                    min = distances.get(unvisited.get(i));
                    curr = unvisited.get(i);
                }
            }
            if(unvisited.size() == 0){
                curr = null;
            }

        }
        System.out.println("Dijkstra's # of Nodes Finalized: " + visited.size());
        return distances;
    }
    static GridGraph createRandomGridGraph(int n){
        GridGraph graph = new GridGraph();
        int count = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                graph.addGridNode(x,y, Integer.toString(count));
                count++;
            }
        }
        Random rand = new Random();
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++) {
                graph.nodes.get(x).get(y);
                if(x + 1 < n ) {
                    int ran = rand.nextInt(4);
                    if (ran <= 2) {
                        graph.addUndirectedEdge(graph.nodes.get(x).get(y), graph.nodes.get(x + 1).get(y));
                        System.out.println(graph.nodes.get(x).get(y).name + " (" + graph.nodes.get(x).get(y).x + ", " + graph.nodes.get(x).get(y).y + ") " +
                                graph.nodes.get(x + 1).get(y).name + " (" + graph.nodes.get(x + 1).get(y).x + ", " + graph.nodes.get(x + 1).get(y).y + ") ");
                    }
                }
                if(y+1 < n) {
                    int ran = rand.nextInt(4);
                    if (ran <= 2) {
                        graph.addUndirectedEdge(graph.nodes.get(x).get(y), graph.nodes.get(x).get(y + 1));
                        System.out.println(graph.nodes.get(x).get(y).name + " (" + graph.nodes.get(x).get(y).x + ", " + graph.nodes.get(x).get(y).y + ") " +
                                graph.nodes.get(x).get(y + 1).name + " (" + graph.nodes.get(x).get(y + 1).x + ", " + graph.nodes.get(x).get(y + 1).y + ") ");
                    }
                }
            }
        }
        return graph;
    }
    static ArrayList<GridGraph.GridNode> astar(final GridGraph.GridNode sourceNode, final GridGraph.GridNode destNode){
        ArrayList<GridGraph.GridNode> ret = new ArrayList<GridGraph.GridNode>();
        HashMap<GridGraph.GridNode, Integer> distances = new HashMap<>();
        HashMap<GridGraph.GridNode, GridGraph.GridNode> parents = new HashMap<>();
        List<GridGraph.GridNode> visited = new ArrayList<>();
        List<GridGraph.GridNode> unvisited = new ArrayList<>();
        distances.put(sourceNode, 0);
        parents.put(sourceNode, null);
        GridGraph.GridNode curr = sourceNode;
        while(curr != null && distances.get(curr) != Integer.MAX_VALUE){
            if(curr == destNode){
                break;
            }
            visited.add(curr);
            unvisited.remove(curr);
            for(int i = 0; i < curr.children.size(); i++){
                GridGraph.GridNode node = curr.children.get(i);
                if(!visited.contains(node)){
                    if(!distances.containsKey(node)){
                        distances.put(node, Integer.MAX_VALUE);
                    }
                    if(distances.get(curr) + 1 < distances.get(node)){
                        distances.put(node, distances.get(curr) + 1);
                        if(!unvisited.contains(node)){
                            unvisited.add(node);
                        }
                        parents.put(node, curr);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < unvisited.size(); i++){
                if(distances.get(unvisited.get(i)) + heuristic(unvisited.get(i), destNode) < min){
                    min = distances.get(unvisited.get(i)) + heuristic(unvisited.get(i), destNode);
                    curr = unvisited.get(i);
                }
            }
            if(unvisited.size() == 0){
                break;
            }
        }
        while(curr != null){
            ret.add(curr);
            curr = parents.get(curr);
        }
        Collections.reverse(ret);
        System.out.println("A* # of Nodes Finalized: " + visited.size());
        if(ret.get(ret.size()-1).name != destNode.name){
            return new ArrayList<>();
        }
        return ret;
    }
    static int heuristic(final GridGraph.GridNode node, final GridGraph.GridNode destNode){
        return Math.abs(destNode.x - node.x) + Math.abs(destNode.y - node.y);
    }
    static void printList(ArrayList<Node> nodes){
        StringBuilder sb = new StringBuilder();
        if(nodes != null){
            sb.append(nodes.get(0).name);
            for(int i = 1; i < nodes.size(); i++){
                sb.append(" -> " + nodes.get(i).name);
            }
            System.out.println(sb.toString());
        }
        else{
            System.out.println("null");
        }

    }
    static void printGridNodeList(ArrayList<GridGraph.GridNode> nodes){
        if(nodes.size() == 0){
            System.out.println("Path Not Found");
            return;
        }
        StringBuilder sb = new StringBuilder();
        if(nodes != null){
            sb.append(nodes.get(0).name);
            for(int i = 1; i < nodes.size(); i++){
                sb.append(" -> " + nodes.get(i).name);
            }
            System.out.println(sb.toString());
        }
    }


    public static void main(String[] args){

        //Problem 3: Traverse This Town
        TestCases.Problem3();
        //Problem 4: Thank U, Vertext
        TestCases.Problem4();
        //Problem 5: Uno, Do', Tre', Cuatro, I Node You Want Me (WeightedGraph)
        TestCases.Problem5();
        //Problem 6: When You Wish Upon A* (GridGraph)
        TestCases.Problem6();
        //Extra Credit
        TestCases.ExtraCredit();

    }
}
