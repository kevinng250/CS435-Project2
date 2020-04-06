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
            Node node = graph.nodes.get(i);
            for(int j = i+1; j < n; j++){
                if(i == j){
                    continue;
                }
                int num = rand.nextInt(10);
                if(num < 3){
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
            Node node = dag.nodes.get(i);
            for(int j = i+1; j < n; j++){
                if(i == j){
                    continue;
                }
                int num = rand.nextInt(10);
                if(num < 4){
                    dag.addDirectedEdge(dag.nodes.get(i), dag.nodes.get(j));
                    System.out.println(dag.nodes.get(i).name + ", " + dag.nodes.get(j).name);
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
            WeightedGraph.Node node = graph.nodes.get(i);
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                int num = rand.nextInt(10);
                graph.addWeightedEdge(graph.nodes.get(i), graph.nodes.get(j), num);
//                System.out.println(graph.nodes.get(i).name + ", " + graph.nodes.get(j).name);

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
            int m = Integer.MAX_VALUE;
            for(int i = 0; i < unvisited.size(); i++){
                if(distances.get(unvisited.get(i)) < m){
                    m = distances.get(unvisited.get(i));
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
                if (0 <= x - 1) {
                    int ran = rand.nextInt(2);
                    if(ran == 1) {
                        graph.addUndirectedEdge(graph.nodes.get(x).get(y), graph.nodes.get(x - 1).get(y));
//                        System.out.println("Distance: " + GridGraph.areNeighbors(graph.nodes.get(x).get(y), graph.nodes.get(x - 1).get(y)));
                        System.out.println(graph.nodes.get(x).get(y).name + " (" + graph.nodes.get(x).get(y).x + ", " + graph.nodes.get(x).get(y).y + ") " +
                                graph.nodes.get(x - 1).get(y).name + " (" + graph.nodes.get(x - 1).get(y).x + ", " + graph.nodes.get(x - 1).get(y).y + ") ");
                    }
                }
                if(x + 1 < n ) {
                    int ran = rand.nextInt(2);
                    if (ran == 1) {
                        graph.addUndirectedEdge(graph.nodes.get(x).get(y), graph.nodes.get(x + 1).get(y));
//                        System.out.println("Distance: " + GridGraph.areNeighbors(graph.nodes.get(x).get(y), graph.nodes.get(x + 1).get(y)));
                        System.out.println(graph.nodes.get(x).get(y).name + " (" + graph.nodes.get(x).get(y).x + ", " + graph.nodes.get(x).get(y).y + ") " +
                                graph.nodes.get(x + 1).get(y).name + " (" + graph.nodes.get(x + 1).get(y).x + ", " + graph.nodes.get(x + 1).get(y).y + ") ");
                    }
                }
                if(0 <= y - 1) {
                    int ran = rand.nextInt(2);
                    if (ran == 1) {
                        graph.addUndirectedEdge(graph.nodes.get(x).get(y), graph.nodes.get(x).get(y - 1));
//                        System.out.println("Distance: " + GridGraph.areNeighbors(graph.nodes.get(x).get(y), graph.nodes.get(x).get(y - 1)));
                        System.out.println(graph.nodes.get(x).get(y).name + " (" + graph.nodes.get(x).get(y).x + ", " + graph.nodes.get(x).get(y).y + ") " +
                                graph.nodes.get(x).get(y - 1).name + " (" + graph.nodes.get(x).get(y - 1).x + ", " + graph.nodes.get(x).get(y - 1).y + ") ");
                    }
                }
                if(y+1 < n) {
                    int ran = rand.nextInt(2);
                    if (ran == 1) {
                        graph.addUndirectedEdge(graph.nodes.get(x).get(y), graph.nodes.get(x).get(y + 1));
//                        System.out.println("Distance: " + GridGraph.areNeighbors(graph.nodes.get(x).get(y), graph.nodes.get(x).get(y + 1)));
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
//            System.out.println(curr.name);
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
            int m = Integer.MAX_VALUE;
//            System.out.println("Size " + unvisited.size());
            for(int i = 0; i < unvisited.size(); i++){
//                System.out.println(unvisited.get(i));
                if(distances.get(unvisited.get(i)) + heuristic(unvisited.get(i), destNode) < m){
                    m = distances.get(unvisited.get(i)) + heuristic(unvisited.get(i), destNode);
                    curr = unvisited.get(i);
                }
            }
            if(unvisited.size() == 0){
                break;
            }
        }
        Stack<GridGraph.GridNode> stack = new Stack<>();

        while(curr != null){
            stack.push(curr);
            curr = parents.get(curr);
        }
        while(!stack.isEmpty()){
            ret.add(stack.pop());
        }
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
        else{
            System.out.println("null");
        }
    }
    public static void main(String[] args){
        //Problem 3: Traverse This Town
        Graph g = createRandomUnweightedGraphIter(6);
        ArrayList<Node> dfsRec = GraphSearch.DFSRec(g.nodes.get(0), g.nodes.get(5));
        System.out.println("DFS Recursive: ");
        printList(dfsRec);
        ArrayList<Node> dfsIter = GraphSearch.DFSIter(g.nodes.get(0), g.nodes.get(5));
        System.out.println("DFS Iterative: ");
        printList(dfsIter);
        ArrayList<Node> bftRec = GraphSearch.BFTRec(g);
        System.out.println("BFT Recursive: ");
        printList(bftRec);
        ArrayList<Node> bftIter = GraphSearch.BFTIter(g);
        System.out.println("BFT Iterative: ");
        printList(bftIter);

        Graph l = createLinkedList(10);
        System.out.println("DFS Iterative LinkedList: ");
        l = createLinkedList(1000);
        ArrayList<Node> linkedList = BFTIterLinkedList(l);
        printList(linkedList);
//        linkedList = BFTRecLinkedList(l); // commented out for testing purposes


        //Problem 4: Thank U, Vertext
        DirectedGraph dag = new DirectedGraph();
        dag.addNode("0");
        dag.addNode("1");
        dag.addNode("2");
        dag.addNode("3");
        dag.addNode("4");
        dag.addNode("5");
        List<Node> nodes = dag.nodes;
        dag.addDirectedEdge(nodes.get(3), nodes.get(1));
        dag.addDirectedEdge(nodes.get(2), nodes.get(3));
        dag.addDirectedEdge(nodes.get(4), nodes.get(1));
        dag.addDirectedEdge(nodes.get(4), nodes.get(0));
        dag.addDirectedEdge(nodes.get(5), nodes.get(2));
        dag.addDirectedEdge(nodes.get(5), nodes.get(0));
        ArrayList<Node> ns = TopSort.mDFS(dag);
        System.out.println("mDFS:");
        printList(ns);
        ns = TopSort.Kahns(dag);
        System.out.println("Kahns:");
        printList(ns);

        DirectedGraph d = createRandomDAGIter(5);
        ArrayList<Node> mDFS = TopSort.mDFS(d);
        ArrayList<Node> kahns = TopSort.Kahns(d);
        System.out.println("mDFS on Random DAG:");
        printList(mDFS);
        System.out.println("Kahns on Random DAG:");
        printList(kahns);

        //Problem 5: Uno, Do', Tre', Cuatro, I Node You Want Me (WeightedGraph)

        //Manually Created Graph - See WeightedGraphDijkstra'sVisualization.jpeg for picture of graph
        System.out.println("\nWeightedGraph:");
        WeightedGraph weightedGraph = new WeightedGraph();
        weightedGraph.addNode("A");//0
        weightedGraph.addNode("B");//1
        weightedGraph.addNode("C");//2
        weightedGraph.addNode("D");//3
        weightedGraph.addNode("E");//4
        weightedGraph.addNode("F");//5
        weightedGraph.addNode("G");//6
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(0), weightedGraph.nodes.get(1), 2);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(0), weightedGraph.nodes.get(3), 7);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(0), weightedGraph.nodes.get(5), 5);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(0), weightedGraph.nodes.get(2), 4);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(1), weightedGraph.nodes.get(0), 2);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(1), weightedGraph.nodes.get(3), 6);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(1), weightedGraph.nodes.get(4), 3);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(1), weightedGraph.nodes.get(6), 8);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(2), weightedGraph.nodes.get(0), 4);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(2), weightedGraph.nodes.get(5), 6);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(3), weightedGraph.nodes.get(0), 7);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(3), weightedGraph.nodes.get(1), 6);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(3), weightedGraph.nodes.get(5), 10);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(3), weightedGraph.nodes.get(6), 6);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(4), weightedGraph.nodes.get(1), 3);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(4), weightedGraph.nodes.get(6), 7);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(5), weightedGraph.nodes.get(2), 6);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(5), weightedGraph.nodes.get(0), 5);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(5), weightedGraph.nodes.get(3), 10);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(5), weightedGraph.nodes.get(6), 6);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(6), weightedGraph.nodes.get(1), 8);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(6), weightedGraph.nodes.get(3), 6);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(6), weightedGraph.nodes.get(4), 7);
        weightedGraph.addWeightedEdge(weightedGraph.nodes.get(6), weightedGraph.nodes.get(5), 6);

        //Randomly Created WeightedGraph
        WeightedGraph weightedGraph2 = createRandomCompleteWeightedGraph(5);
        System.out.println("Node :: {child : weight}");     //shows node child weight pairings
        for(int i = 0; i < weightedGraph2.nodes.size(); i++){
            WeightedGraph.Node node = weightedGraph2.nodes.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append("Node " + node.name + " :: ");
            for(WeightedGraph.Node child : node.children.keySet()){
                sb.append(child.name +":" + node.children.get(child) + " ");
            }
            System.out.println(sb.toString());
        }

        HashMap<WeightedGraph.Node, Integer> dijkstra = dijkstras(weightedGraph2.nodes.get(0));
        System.out.println("Dijkstra's Algorithm to each node: ");
        for(WeightedGraph.Node node : dijkstra.keySet()){
            System.out.println(node.name + ": " + dijkstra.get(node));
        }


        //Problem 6: When You Wish Upon A* (GridGraph)
        System.out.println("\nGridGraph:\nConnected Edges Coordinates: ");
        //Randomly created GridGraph
        int n = 5;
        GridGraph random = createRandomGridGraph(n);
        GridGraph.GridNode sourceNode = random.nodes.get(0).get(0);
        GridGraph.GridNode destNode = random.nodes.get(n-1).get(n-1);
        ArrayList<GridGraph.GridNode> list = astar(sourceNode, destNode);
        printGridNodeList(list);

        //Manually created GridGraph - See GridGraphA*Visualization.jpeg for picture of graph
        GridGraph graph = new GridGraph();
        //Adds a bunch a grid of nodes
        int count = 0;
        for(int x = 0; x < 5; x++){
            for(int y = 0; y < 5; y++){
                graph.addGridNode(x,y,Integer.toString(count));
                count++;
            }
        }
        GridGraph.GridNode source = graph.nodes.get(0).get(0);
        GridGraph.GridNode dest = graph.nodes.get(2).get(1);{
        graph.addUndirectedEdge(graph.nodes.get(0).get(0), graph.nodes.get(0).get(1));
        graph.addUndirectedEdge(graph.nodes.get(0).get(1), graph.nodes.get(0).get(2));
        graph.addUndirectedEdge(graph.nodes.get(0).get(2), graph.nodes.get(0).get(3));
        graph.addUndirectedEdge(graph.nodes.get(0).get(3), graph.nodes.get(0).get(4));
        graph.addUndirectedEdge(graph.nodes.get(0).get(3), graph.nodes.get(1).get(3));
        graph.addUndirectedEdge(graph.nodes.get(1).get(3), graph.nodes.get(1).get(2));
        graph.addUndirectedEdge(graph.nodes.get(1).get(2), graph.nodes.get(1).get(1));
        graph.addUndirectedEdge(graph.nodes.get(1).get(1), graph.nodes.get(1).get(0));
        graph.addUndirectedEdge(graph.nodes.get(1).get(3), graph.nodes.get(2).get(3));
        graph.addUndirectedEdge(graph.nodes.get(2).get(3), graph.nodes.get(3).get(3));
        graph.addUndirectedEdge(graph.nodes.get(1).get(3), graph.nodes.get(1).get(4));
        graph.addUndirectedEdge(graph.nodes.get(1).get(4), graph.nodes.get(2).get(4));
        graph.addUndirectedEdge(graph.nodes.get(2).get(4), graph.nodes.get(3).get(4));
        graph.addUndirectedEdge(graph.nodes.get(3).get(4), graph.nodes.get(4).get(4));
        graph.addUndirectedEdge(graph.nodes.get(1).get(0), graph.nodes.get(2).get(0));
        graph.addUndirectedEdge(graph.nodes.get(2).get(0), graph.nodes.get(3).get(0));
        graph.addUndirectedEdge(graph.nodes.get(3).get(0), graph.nodes.get(3).get(1));
        graph.addUndirectedEdge(graph.nodes.get(3).get(1), graph.nodes.get(3).get(2));
        graph.addUndirectedEdge(graph.nodes.get(3).get(2), graph.nodes.get(2).get(2));
        graph.addUndirectedEdge(graph.nodes.get(2).get(2), graph.nodes.get(2).get(1));
        graph.addUndirectedEdge(graph.nodes.get(4).get(4), graph.nodes.get(4).get(3));
        graph.addUndirectedEdge(graph.nodes.get(4).get(3), graph.nodes.get(4).get(2));
        graph.addUndirectedEdge(graph.nodes.get(4).get(2), graph.nodes.get(4).get(1));
        graph.addUndirectedEdge(graph.nodes.get(4).get(1), graph.nodes.get(4).get(0));
        graph.addUndirectedEdge(graph.nodes.get(4).get(2), graph.nodes.get(3).get(2));}
        System.out.println("A* Algorithm Path");
        ArrayList<GridGraph.GridNode> astar = astar(source, dest);
        printGridNodeList(astar);

        //Extra Credit
        System.out.println("\nDijkstra's finalized amount vs A* finalized amount");
        WeightedGraph weightedGraph3 = createRandomCompleteWeightedGraph(16);
        GridGraph gridGraph1 = createRandomGridGraph(4);
        dijkstras(weightedGraph3.nodes.get(0));
        astar(gridGraph1.nodes.get(0).get(0), gridGraph1.nodes.get(3).get(3));
        System.out.println("A* is generally lower");

    }
}
