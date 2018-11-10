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
}