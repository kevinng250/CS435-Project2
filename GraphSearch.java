import java.util.*;

public class GraphSearch {
    static ArrayList<Node> DFSRec(final Node start, final Node end){
        ArrayList<Node> visited = new ArrayList<>();
        DFSRecHelper(start, end, visited);
        if(visited.get(visited.size() - 1).name != end.name){
            return null;
        }
        return visited;
    }
    static void DFSRecHelper(final Node start, final Node end, ArrayList<Node> visited){
        int n = visited.size();
        if(visited.size() != 0){
            if(visited.get(n - 1).name == end.name){
                return;
            }
        }
        if(start == null){
            return;
        }
        visited.add(start);

        if(start == end){
            return;
        }
        List<Node> list = start.children;
        if(list == null){
            return;
        }
        for(int i = 0; i < list.size(); i++){
            if(!visited.contains(list.get(i))){
                DFSRecHelper(list.get(i), end, visited);
            }
        }
    }
    static ArrayList<Node> DFSIter(final Node start, final Node end){
        ArrayList<Node> nodes = new ArrayList<Node>();
        Stack<Node> stack = new Stack<>();
        ArrayList<Node> visited = new ArrayList<>();
        stack.push(start);
        while(stack.size()!= 0){
            Node n = stack.pop();
            nodes.add(n);
            visited.add(n);
            if(n.name == end.name){
                break;
            }
            List<Node> list = n.children;
            if(list == null){
                continue;
            }
            for(int i = 0; i < list.size(); i++){
                Node child = n.children.get(i);
                if(!visited.contains(child)){
                    stack.push(child);
                }
            }
        }
        if(nodes.get(nodes.size() - 1).name != end.name){
            return null;
        }
        return nodes;
    }
    static ArrayList<Node> BFTRec(final Graph graph){
        ArrayList<Node> visited = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        for(int i = 0; i < graph.nodes.size(); i++) {
            Node n = graph.nodes.get(i);
            if(!visited.contains(n)) {
                queue.add(n);
                visited.add(n);
                BFTRecHelper(graph, queue, visited);
            }
        }
        return visited;
    }
    static void BFTRecHelper(Graph graph, Queue<Node> queue, ArrayList<Node> visited){
        if(queue.size() == 0){
            return;
        }
        Node n = queue.poll();
        if(graph.adjList.get(n.name) !=  null){
            for(Node node : graph.adjList.get(n.name)){
                if(!visited.contains(node)){
                    queue.add(node);
                    visited.add(node);
                }
            }
        }
        BFTRecHelper(graph, queue, visited);
    }
    static ArrayList<Node> BFTIter(final Graph graph){
        ArrayList<Node> nodes = new ArrayList<Node>();
        Queue<Node> queue = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<>();
        for(int j = 0; j < graph.nodes.size(); j++) {
            Node node = graph.nodes.get(j);
            if(!visited.contains(node)){
                queue.add(node);
                visited.add(node);
                nodes.add(node);
                while (queue.size() != 0) {
                    Node n = queue.poll();
                    List<Node> adjList = graph.adjList.get(n.name);
                    if(adjList == null){
                        continue;
                    }
                    for (int i = 0; i < adjList.size(); i++) {
                        if (!visited.contains(adjList.get(i))) {
                            queue.add(adjList.get(i));
                            visited.add(adjList.get(i));
                            nodes.add(adjList.get(i));
                        }
                    }
                }
            }
        }
        return nodes;
    }


}
