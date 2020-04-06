Node.java

    A node has a String attribute for the node's value
    A node also has a List<Node> attribute for the node's child/neighbors

Graph.java

    A graph has List<Node> nodes attribute listing out all the nodes in the graph
    A graph also has an adjList HashMap<String, List < Node > > that has a 
    node value as key and a corresponding list of children
    Methods:
    void addNode(final String nodeVal)
        adds a node to the graph
    void addUndirectedEdge(final Node first, final Node second)
        creates an undirected edge between first and second node and vice versa
        updates the node's respective children list and adjList
    void removeUndirectedEdge(final Node first, final Node second)
        removes an undirected edge between first and second node and vice versa
    HashSet<Node> getAllNodes()
        returns a HashSet<Node> of all nodes in the graph
    void addDirectedEdge(final Node first, final Node second)
        creates a directed edge between first and second node
        **used explicitly for createLinkedList**

GraphSearch.java

    ArrayList<Node> DFSRec(final Node start, final Node end)
        returns an ArrayList of Nodes representing the path given through a DFS Recursively
        returns null if no path found
        Notice in screenshot DFS&BFS that this checks the lowest child first
    void DFSRecHelper(final Node start, final Node end, ArrayList<Node> visited)
        the actual recursive function in DFSRec
    ArrayList<Node> DFSIter(final Node start, final Node end)
        returns an ArrayList of Nodes representing the path given through a DFS Iteratively
        returns null if no path found
        Notice in screenshot DFS&BFS that this checks the greatest child first
    ArrrayList<Node> BFTRec(final Graph graph)
        returns an ArrayList of nodes representing the path given from a BFT recursively
    ArrayListL<Node BFTIter(final graph graph)
        returns an ArrayList of nodes representing the path given from a BFT iteratively
        
DirectedGraph.java

    A DirectedGraph has List<Node> nodes attribute listing out all the nodes in the graph
    A graph also has an adjList HashMap<String, List<Node>> that has a 
    node value as key and a corresponding list of children
    
    Methods:
    void addNode(final String nodeVal)
        adds a node to the graph
    void addDirectedEdge(final Node first, final Node second)
        creates an directed edge from first node to second node
        updates the first nodes children
    void removeDirectedEdge(final Node first, final Node second)
        removes a directed edge from first to second node
    HashSet<Node> getAllNodes()
        returns a HashSet<Node> of all nodes in the graph
    
TopSort.java

    ArrayList<Node> Kahns(final DirectedGraph graph)
    void addNodesWith0(HashMap<Node, Integer> h, Queue<Node> queue)
        adds nodes in h with 0 inInDegrees to queue
    HashMap<Node, Integer> getInDegrees(Directed graph)
        gets InDegree
    ArrayList<Node> mDFS(final DirectedGraph graph)
        returns ArrayList<Node> of mDFS path
    void mDFSHelper(Node node, Stack stack, HashSet<Node> visited)
        recursive helper for mDFS
        
WeightedGraph

    List<Node> nodes attribute listing out all the nodes in the graph
    HashMap<String, Map<Node>> adjList that has a node value as key and a corresponding list of children
    
    class Node
        String name
        Map<Node, Integer> children - a child node and the corresponding weight to that child
    
    Methods:
        void addNode(final String nodeVal)
            adds a node to the graph
        void addDirectedEdge(final Node first, final Node second, final int edgeWeight)
            creates an directed edge from first node to second node with a certain edgeWeight
            updates the first nodes children
        void removeDirectedEdge(final Node first, final Node second)
            removes a directed edge from first to second node
        HashSet<Node> getAllNodes()
            returns a HashSet<Node> of all nodes in the graph
    
GridGraph
    
    Each node can have only a max of four neighbors, they must be a distance 1 away from (x,y) to be considered a neighbor
    
    List<List<GridNode>> nodes attribute listing out all the nodes in the graph
    HashMap<String, List<GridNode>> adjList that has a gridnode value as key and a corresponding list of children
    
    class GridNode
        Attribute:
            String name - node value
            int x - x coordinate
            int y - y coordinate
            List<GridNode> children
        Constructor:
            public GridNode(final int x, final int y, String nodeVal)
        
    Methods:
        void addGridNode(final int x, final int y, final String nodeVal)
            adds a node to the graph
        void addUnDirectedEdge(final Node first, final Node second, final int edgeWeight)
            creates an Undirected edge from first node to second node if they are neighbors
            updates the first nodes children
        void removeDirectedEdge(final Node first, final Node second)
            removes a directed edge from first to second node
        boolean areNeighbors(final GridNode first, final GridNode second)
            returns true if nodes are neighbors
        HashSet<Node> getAllNodes()
            returns a HashSet<Node> of all nodes in the graph
        
        
        
Main.java
    
    Graph createRandomUnweightedGraphIter(int n)
        return random unweightedGraph
    Graph createLinkedList(int n)
        return a graph that is essentially a linked list of size n
    ArrayList<Node> BFTRecLinkedList(final Graph graph)
        returns an ArrayList of Nodes from a BST Recursively
    ArrayList<Node> BFTIterLinkedList(final Graph graph)
        returns an ArrayList of Nodes from a BST Iteratively
        
        
        
        
        
    public static void main(String[] args)
        test code for all four (dfsRec, dfsIter, bftRec, bftIter) using graph
        from createRandomUnweightedGraphIter
        
        commmented out is the test for 10,000 linkedlist nodes for iterative and recursive