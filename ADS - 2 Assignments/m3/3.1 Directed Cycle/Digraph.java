
/**
 * Interface for digraph.
 */
interface Digraph {
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
 * Class for DiGraphRep.
 */
class DiGraphRep implements Digraph {
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
    DiGraphRep() {

    }
    /**
     * Constructs the object.
     *
     * @param      ver   The version
     */
    DiGraphRep(final int ver) {
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
        // if (v == w) {
        //     return;
        // }
       // if (!hasEdge(v, w)) {
            edge++;
            arr[v].add(w);
            //arr[w].add(v);
        //}
    }

    // /**
    //  * matrix representation.
    //  * time complexity O(v).
    //  *
    //  * @param      v          { parameter_description }
    //  * @param      e          { parameter_description }
    //  *
    //  * @throws     Exception  { exception_description }
    //  */
    // public void matrixRep(final int v, final int e) throws Exception {
    //     if (e <= 1 && v <= 1) {
    //         System.out.println(ver() + " vertices" + ", " + ed() + " edges");
    //         throw new Exception("No edges");
    //     } else {
    //         System.out.println(ver() + " vertices" + ", " + ed() + " edges");
    //         int[][] mat = new int[v][v];
    //         for (int i = 0; i  < v; i++) {
    //             for (int j = 0; j < v; j++) {
    //                 if (hasEdge(i, j)) {
    //                     mat[i][j] = 1;
    //                 }
    //             }
    //         }
    //         for (int i = 0; i < v; i++) {
    //             for (int j = 0; j < v; j++) {
    //                 System.out.print(mat[i][j] + " ");
    //             }
    //             System.out.println();
    //         }
    //     }
    // }

    // /**
    //  * list represenation.
    //  * time complexity O(V+E).
    //  *
    //  * @param      v          { parameter_description }
    //  * @param      e          { parameter_description }
    //  * @param      n1         The n 1
    //  *
    //  * @throws     Exception  { exception_description }
    //  */
    // public void listRep(final int v,
    // final int e, final String[] n1) throws Exception {
    //     if (e <= 1 && v <= 1) {
    //         System.out.println(ver() + " vertices" + ", " + ed() + " edges");
    //         throw new Exception("No edges");
    //     } else {
    //         System.out.println(ver() + " vertices" + ", " + ed() + " edges");
    //         for (int i = 0; i < n1.length; i++) {
    //         String str = "";
    //         str = n1[i] + ": ";
    //         for (int k : arr(i)) {
    //             str = str + n1[k] + " ";
    //         }
    //         System.out.println(str);
    //         }
    //     }
    // }
}

