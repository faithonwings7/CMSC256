package cmsc256;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*************************************************
 * File name: MyGraph
 * Name: Anne Szarek
 * Project number: Project 6
 * Course identifier: CMSC 256, Spring Semester, Section 902
 * Brief description: Implement a subclass of the UnweightedGraph
 *                    class to add additional functionality.
 ************************************************/


public class MyGraph<V> extends UnweightedGraph<V> {

    private static UnweightedGraph g;
    static int n = 0; //holds line 1 of file, indicating number of vertices


    /**Constructor: an empty graph */
    public MyGraph(){
    }

    /**Constructor: graph from vertices and edges stored in lists */
    public MyGraph(V[] vertices, int[][] edges){
        super(vertices, edges);
    }

    /** Constructor: a graph from vertices and edges stored in List */
    public MyGraph(List<V> vertices, List<Edge> edges){
        super(vertices, edges);
        this.vertices = vertices;
    }

    /** Constructor: a graph for integer vertices 0, 1, 2 and edge list */
    public MyGraph(List<Edge> edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }

    /** Constructor: a graph from integer vertices 0, 1, and edge array */
    public MyGraph(int[][] edges, int numberOfVertices){
        super (edges, numberOfVertices);
    }

    /**that reads a graph from a file and determines whether the graph is connected**/
    //TODO: make not static
    public static boolean isGraphConnected(String fileName)  throws FileNotFoundException, NullPointerException {
        boolean isConnected = false;

        // accept a file name as a String parameter and if the file is unable to be
        // opened, the method should throw a FileNotFoundException
        File fileIn = null;

        if ((fileName.equals(null)) || (fileName.length() == 0) || (fileName.isEmpty())){
            throw new NullPointerException("File Name is null");
        }
        /**while there are lines in the input file**/
         else if (fileName.length() > 0){
            try {
              /** implement to turn in**/
              if ((fileIn = new File(fileName)).exists()) {
                  fileIn = new File(fileName);
                  isConnected = true;
              }

            }
            /**accept a file name as a String parameter and if the file is unable to
             * be opened, the method should throw a FileNotFoundException*/
            catch (Exception ex) {
                throw new FileNotFoundException("File not found");
            }
        }

        int u = 0; // holds specific vertex for pair
        int v = 0; //holds subsequent edges for pair

        Scanner sc = new Scanner(fileIn);

        //TODO: add <V>
        String nString = "";
        try{
            nString = sc.nextLine();
            if(nString.length() == 1) {
                n = Integer.parseInt(nString);
                System.out.println("value of n: " + n);
            }
            else{
                throw new NumberFormatException("no n value given");
            }
        }
        catch (Exception ex){
            throw new NumberFormatException("no n value given");
        }
        List<Edge> edges = new ArrayList<>();

        while (sc.hasNextLine()) {

            String line = sc.nextLine();
            System.out.println("line: " + line);
            if(!(line.isEmpty())) {
                String[] lineSplit = line.split(" ");
                /**get the origin vertex**/
                u = Integer.parseInt(lineSplit[0]);
                if (lineSplit.length >= 1) {
                    for (int i = 1; i < lineSplit.length; i++) {
                        /**create an Edge object and add it to the edge list**/
                        v = Integer.parseInt(lineSplit[i]);
                        edges.add(new Edge(u, v));
                    }
                }
                else{
                    throw new ArrayIndexOutOfBoundsException("no edges found");
                }
            }
            else {
                throw new ArrayIndexOutOfBoundsException("no edges found");
            }
        }
        g = new UnweightedGraph(edges, n);
        /**Invoke g.printEdges() to display all edges**/
         g.printEdges();
        /**Invoke dfs() to obtain an instance tree of UnweightedGraph.SearchTree**/
        UnweightedGraph.SearchTree tree = g.dfs(u);
        /**If tree.getNumberOfVerticesFound() is the same as the number of
         * vertices in the graph, the graph is connected.*/
         if (n == tree.getNumberOfVerticesFound()){
            isConnected = true;
        }
        //System.out.println("isConnected:  " + isConnected);
        return isConnected;
    }

    /** finds all connected components in this graph instance **/
    public List<List<Integer>> getConnectedComponents(){
        /**create a List object to hold each component list as the result list**/
        List<List<Integer>> componentsList = new ArrayList<>();
        /**create a temporary list of all the vertices in the graph**/
         List<Integer> a = new ArrayList<>(vertices.size());

        /** adds each vertices to list a **/
        for (int i = 0; i < vertices.size(); i++)
            a.add(i);

        /** Call getConnectedComponents recursive method**/
        getConnectedComponents(a, componentsList);
        return componentsList;
    }

    /**Finding connected components - recursive method**/
    public void getConnectedComponents(
            List<Integer> a, List<List<Integer>> componentsList) {
        if (a.size() > 0) {
            /**at a selected vertex, perform a dfs and add the resulting
             * SearchTree to the result list*/
            List<Integer> c = dfs(a.get(0)).getSearchOrder();
            componentsList.add(c);
            /**remove the visited vertices from the temporary vertex list**/
            a.removeAll(c);
            getConnectedComponents(a, componentsList);
        }
    }

    /**finds a path between two vertices **/
    public static List<Integer> getPath(int u, int v){

        /** Use BFS approach to obtain shortest path from u to v **/
        UnweightedGraph.SearchTree tree;
        if (g != null) {
            tree = g.bfs(u);
        }
        else{
            throw new NullPointerException("graph is null");
        }
        ArrayList<Integer> path = new ArrayList<>();

        /**checks to make sure v is a valid/positive number
         * If so adds, to ArrayList path **/
        do {
            path.add(v);
            v = tree.getParent(v);
        } while (v != -1);

        /** Starts at v and counts to u and reverses order **/
        Collections.reverse(path);

        /** checks if ArrayList path is empty and sets to null if so **/
        if(path.isEmpty()){
            throw new NullPointerException();
        }
        return path;
    }

    /** determines whether there is a cycle in the graph **/
    public boolean isCyclic() {
        List<Integer> a = new ArrayList<>(vertices.size());

        /** adds each vertices to list a **/
        for (int i = 0; i < vertices.size(); i++){
            a.add(i);
        }
        for (int i = 0; i < vertices.size(); i++) {
            List<Integer> searchOrder = new ArrayList<>();
            int[] parent = new int[vertices.size()];

            for (int j = 0; j < parent.length; j++) {
                parent[j] = -1;
            }
            boolean[] isVisited = new boolean[vertices.size()];

            /**Recursively search each vertex until a cycle is found**/
            boolean isVertexCyclic = isCyclic(i, parent, a, isVisited);
            if(isVertexCyclic) {
                return true;
            }
        }

        return false;
    }

    private boolean isCyclic(int u, int[] parent, List<Integer> allVertices, boolean[] isVisited){

        /**Remove vertex, u, from the List of vertices**/
         allVertices.remove(u);

        /**Mark isVisited[u] as visited**/
         isVisited[u] = true;

        int[] newParent = java.util.Arrays.copyOf(parent, parent.length);
        boolean[] newIsVisited = java.util.Arrays.copyOf(isVisited, parent.length);
        List<Integer> newAllVertices = (List<Integer>) ((ArrayList<Integer>)allVertices).clone();

        /**Modify the for loop that iterates over the neighbors Edge list**/
         for (Edge e : neighbors.get(u)) { // Note that e.u is v
             /**if not visited, update parent array and recursively call isCyclic**/
             if (!isVisited[e.u]) { // e.u is w in Listing 28.8
                parent[e.u] = u; // The parent of w is v
                isCyclic(e.u, newParent, newAllVertices, newIsVisited); // Recursive search
                return true;
            }
            /**if it is visited and it’s not this vertex’s parent,
             * cycle is found, return true**/

             else if (isVisited[e.u] && !(newParent[e.u] == e.u)){
                return true;
            }
        }
        /**if no cycles found, return false**/
        return false;
    }

    /** find a cycle in this graph that starts at vertex u**/
    public List findCycle(int u){
       List<Integer> vertices = new ArrayList<>(); // Store vertices
        for(int i = 0; i < n; i++){
            vertices.add(i);
        }
       int[] parent = new int[vertices.size()];
       boolean[] isVisited = new boolean[vertices.size()];
       List allVerticesInCycleList = new ArrayList();

       List<Integer> adjEdges = new ArrayList(getNeighbors(u));


       while (isVisited[u] == false) {
           V get = getVertex(u);
           Stack<V> cycleStack = new Stack();
           cycleStack.push(get);
           allVerticesInCycleList.add(get);
           adjEdges.remove(get);
           isVisited[u] = true;
           while (!cycleStack.isEmpty()){
                adjEdges.get(0);

           }
       }

        return allVerticesInCycleList;
    }
}

