import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedNode {
    String name;
    Map<WeightedNode, Integer> children;
    public WeightedNode(String nodeVal){
        this.name = nodeVal;
        children = new HashMap<WeightedNode, Integer>();
    }
}
