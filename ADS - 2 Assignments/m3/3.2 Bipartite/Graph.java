/**
 * Interface for graph.
 */
interface Graph {
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    int ver();
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    int ed();
    /**
     * Adds an edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     */
    void addEdge(int v, int w);
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    Iterable<Integer> arr(int v);
    /**
     * Determines if it has edge.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     True if has edge, False otherwise.
     */
    boolean hasEdge(int v, int w);
}
/**
 * Class for graph rep.
 */
class GraphRep implements Graph {
    /**
     * { var_description }.
     */
    private int vertex;
    /**
     * { var_description }.
     */
    private int edge;
    /**
     * { var_description }.
     */
    private Bag<Integer>[] arr;
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
    GraphRep(final int ver) {
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
    public int ver() {
        return vertex;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int ed() {
        return edge;
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> arr(final int v) {
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
    public boolean hasEdge(final int v, final int w) {
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
    public void addEdge(final int v, final int w) {
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


