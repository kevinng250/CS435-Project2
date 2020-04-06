import java.util.ArrayList;
import java.util.List;
    class Node{
        String name;
        List<Node> children;
        public Node(String nodeVal){
            this.name = nodeVal;
            children = new ArrayList<Node>();
        }
    }

