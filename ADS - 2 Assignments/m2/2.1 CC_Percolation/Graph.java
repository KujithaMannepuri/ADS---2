/**
 * Interface for graph.
 */
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> arr(int v);
    public boolean hasEdge(int v, int w);
}
/**
 * Class for graph rep.
 */
class GraphRep implements Graph {
    /**
     * { var_description }.
     */
    int vertex;
    /**
     * { var_description }.
     */
    int edge;
    /**
     * { var_description }.
     */
    Bag<Integer>[] arr;
    /**
     * Constructs the object.
     */
    GraphRep() {

    }
    /**
     * Constructs the object.
     *
     * @param      ver   The version
     */
    GraphRep(int ver) {
        this.vertex = ver;
        this.edge = 0;
        arr = (Bag<Integer>[]) new Bag[ver];
        for (int i = 0; i < vertex; i++) {
            arr[i] = new Bag<Integer>();
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int V() {
        return vertex;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int E() {
        return edge;
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> arr(int v) {
        return arr[v];
    }
    /**
     * Determines if it has edge.
     * time complexity O(E).
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    public boolean hasEdge(int v, int w) {
        for (int k : arr[v]) {
            if (k == w) {
                return true;
            }
        }
        return false;
    }
    /**
     * Adds an edge.
     * Time complexity O(1).
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    public void addEdge(int v, int w) {
        if (v == w) {
            return;
        }
        if (!hasEdge(v, w)) {
            edge++;
            arr[v].add(w);
            arr[w].add(v);
        }
    }

    /**
     * matrix representation.
     * time complexity O(v).
     *
     * @param      v          { parameter_description }
     * @param      e          { parameter_description }
     *
     * @throws     Exception  { exception_description }
     */
    public void matrixRep(int v, int e) throws Exception {
        if (e <= 1 && v <= 1) {
            System.out.println(V() + " vertices" + ", " + E() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(V() + " vertices" + ", " + E() + " edges");
            int[][] mat = new int[v][v];
            for (int i = 0; i  < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (hasEdge(i, j)) {
                        mat[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    /**
     * list represenation.
     * time complexity O(V+E).
     *
     * @param      v          { parameter_description }
     * @param      e          { parameter_description }
     * @param      n1         The n 1
     *
     * @throws     Exception  { exception_description }
     */
    public void listRep(int v, int e, String[] n1) throws Exception {
        if (e <= 1 && v <= 1) {
            System.out.println(V() + " vertices" + ", " + E() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(V() + " vertices" + ", " + E() + " edges");
            for (int i = 0; i < n1.length; i++) {
            String str = "";
            str = n1[i] + ": ";
            for (int k : arr(i)) {
                str = str + n1[k] + " ";
            }
            System.out.println(str);
            }
        }
    }
}

