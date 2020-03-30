Node Class
    A node has a String attribute for the node's value
    A node also has a List<Node> attribute for the node's child/neighbors

Graph Class
    A graph has List<Node> attribute listing out all the nodes in the graph
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

GraphSearch
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
    
Main
    Graph createRandomUnweightedGraphIter(int n)
        returns a graph with nodes with values ranging from 0 to n-1
        Algorithm:
            add all the nodes
            for every node i
                go through other nodes j
                    get a random number
                    if random number is less than 3
                    add an edge between node i and node j
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