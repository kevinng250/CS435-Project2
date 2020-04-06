import java.util.*;

public class TopSort {
    static ArrayList<Node> Kahns(final DirectedGraph graph){
        ArrayList<Node> visited = new ArrayList<Node>();
        HashMap<Node, Integer> h = getInDegrees(graph);
        Queue<Node> queue = new LinkedList<>();
        addNodesWith0(h, queue);
        while(queue.size()!= 0){
            Node node = queue.poll();
            visited.add(node);
            if(node.children != null){
                for(int i = 0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    h.put(child, h.get(child) -1);
                }
            }
            addNodesWith0(h, queue);
        }

        return visited;
    }
    static void addNodesWith0(HashMap<Node, Integer> h, Queue<Node> queue){
        for(Node n : h.keySet()){
            if(h.get(n) == 0){
                queue.add(n);
                h.put(n, h.get(n) - 1);
            }
        }
    }
    static HashMap<Node, Integer> getInDegrees(DirectedGraph graph){
        HashMap<Node, Integer> h = new HashMap<Node, Integer>();
        for(int i = 0; i < graph.nodes.size();i++){
            h.put(graph.nodes.get(i), 0);
        }
        for(Node node : graph.nodes){
            List<Node> children = node.children;
            if(children != null) {
                for (Node child : children) {
                    h.put(child, h.get(child) + 1);
                }
            }
        }
        return h;
    }

    static ArrayList<Node> mDFS(final DirectedGraph graph){
        HashSet<Node> visited = new HashSet<Node>();
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < graph.nodes.size(); i++){
            if(!visited.contains(graph.nodes.get(i))){
                mDFSHelper(graph.nodes.get(i), stack, visited);
            }
        }
        ArrayList<Node> ret = new ArrayList<Node>();
        while(!stack.empty()){
            ret.add(stack.pop());
        }
        return ret;
    }
    static void mDFSHelper(Node node, Stack stack, HashSet<Node> visited){
        visited.add(node);
        if(node.children != null) {
            for (int i = 0; i < node.children.size(); i++) {
                if (!visited.contains(node.children.get(i))) {
                    mDFSHelper(node.children.get(i), stack, visited);
                }
            }
        }
        stack.push(node);
    }
}

