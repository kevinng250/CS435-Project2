import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestCases {

    /*
    There are visual representations for the manually created graphs

        Problem 4
        //Manually Created - See DirectedGraphVisualization.jpeg in Github for picture of graph

        Problem 5
        //Manually Created Graph - See WeightedGraphDijkstra'sVisualization.jpeg in Github for picture of graph

        Problem 6
        //Manually created GridGraph - See GridGraphA*Visualization.jpeg in Github for picture of graph
     */

    static void Problem3(){
        //Problem 3: Traverse This Town
        System.out.println("Problem 3");
        Graph g = Main.createRandomUnweightedGraphIter(6);
        ArrayList<Node> dfsRec = GraphSearch.DFSRec(g.nodes.get(0), g.nodes.get(5));
        System.out.println("DFS Recursive: ");
        Main.printList(dfsRec);
        ArrayList<Node> dfsIter = GraphSearch.DFSIter(g.nodes.get(0), g.nodes.get(5));
        System.out.println("DFS Iterative: ");
        Main.printList(dfsIter);
        ArrayList<Node> bftRec = GraphSearch.BFTRec(g);
        System.out.println("BFT Recursive: ");
        Main.printList(bftRec);
        ArrayList<Node> bftIter = GraphSearch.BFTIter(g);
        System.out.println("BFT Iterative: ");
        Main.printList(bftIter);

        Graph l = Main.createLinkedList(10);
        System.out.println("DFS Iterative LinkedList: ");
        l = Main.createLinkedList(1000);
        ArrayList<Node> linkedList = Main.BFTIterLinkedList(l);
        Main.printList(linkedList);
//        linkedList = BFTRecLinkedList(l); // commented out for testing purposes
//        Main.printList(linkedList);
    }
    static void Problem4(){
        //Manually Created Graph
        System.out.println("\nProblem 4");
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
        System.out.println("mDFS on manually created DAG:");
        Main.printList(ns);
        ns = TopSort.Kahns(dag);
        System.out.println("Kahns on manually created DAG:");
        Main.printList(ns);

        DirectedGraph d = Main.createRandomDAGIter(5);
        ArrayList<Node> mDFS = TopSort.mDFS(d);
        ArrayList<Node> kahns = TopSort.Kahns(d);
        System.out.println("mDFS on Random DAG:");
        Main.printList(mDFS);
        System.out.println("Kahns on Random DAG:");
        Main.printList(kahns);
    }
    static void Problem5(){
        //Manually Created WeightedGraph
        System.out.println("\nProblem 5\nWeightedGraph:");
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
        WeightedGraph weightedGraph2 = Main.createRandomCompleteWeightedGraph(5);
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

        HashMap<WeightedGraph.Node, Integer> dijkstra = Main.dijkstras(weightedGraph2.nodes.get(0));
        System.out.println("Dijkstra's Algorithm to each node: ");
        for(WeightedGraph.Node node : dijkstra.keySet()){
            System.out.println(node.name + ": " + dijkstra.get(node));
        }
    }
    static void Problem6(){
        System.out.println("\nProblem 6\nRandom GridGraph:\nConnected Edges Coordinates: ");
        //Randomly created GridGraph
        int n = 5;
        GridGraph random = Main.createRandomGridGraph(n);
        GridGraph.GridNode sourceNode = random.nodes.get(0).get(0);
        GridGraph.GridNode destNode = random.nodes.get(n-1).get(n-1);
        ArrayList<GridGraph.GridNode> list = Main.astar(sourceNode, destNode);
        Main.printGridNodeList(list);

        //Manually created GridGraph
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
        System.out.println("Manually Created A* Algorithm Path");
        ArrayList<GridGraph.GridNode> astar = Main.astar(source, dest);
        Main.printGridNodeList(astar);
    }
    static void ExtraCredit(){
        System.out.println("\nExtra Credit\nDijkstra's finalized amount vs A* finalized amount");
        WeightedGraph weightedGraph3 = Main.createRandomCompleteWeightedGraph(16);
        GridGraph gridGraph1 = Main.createRandomGridGraph(4);
        Main.dijkstras(weightedGraph3.nodes.get(0));
        Main.astar(gridGraph1.nodes.get(0).get(0), gridGraph1.nodes.get(3).get(3));
        System.out.println("A* is generally lower");
    }
}
