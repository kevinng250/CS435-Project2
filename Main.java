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
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                int num = rand.nextInt(10);
                if(num < 3){
                    dag.addDirectedEdge(dag.nodes.get(i), dag.nodes.get(j));
                }
            }
        }

        return dag;
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
    public static void main(String[] args){


        Graph g = createRandomUnweightedGraphIter(6);
        //Create a graph node with 6 edges
        System.out.println("Start: " + g.nodes.get(0).name);
        System.out.println("End: " + g.nodes.get(5).name);

        ArrayList<Node> dfsRec = GraphSearch.DFSRec(g.nodes.get(0), g.nodes.get(5));
        //DFS Iteratively

        //Prints out DFS
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
        ArrayList<Node> ns = GraphSearch.DFSIter(l.nodes.get(0), l.nodes.get(9));
        printList(ns);
        // Testing 100000
        Graph graph1 = createLinkedList(10000);
        ArrayList<Node> linkedList = BFTIterLinkedList(graph1);
        printList(linkedList);

        ArrayList<Node> linkedList1 = BFTRecLinkedList(graph1);
        printList(linkedList1);

    }
}
