
/**
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * { var_description }.
     */
    private boolean[] marked;        // marked[v] = has vertex v been marked?
    /**
     * { var_description }.
     */
    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
    /**
     * { var_description }.
     */
    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
    /**
     * { var_description }.
     */
    private Stack<Integer> cycle;
    // directed cycle (or null if no such cycle)

    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param dgph the digraph
     */
    public DirectedCycle(final Digraph dgph) {
        marked  = new boolean[dgph.ver()];
        onStack = new boolean[dgph.ver()];
        edgeTo  = new int[dgph.ver()];
        for (int v = 0; v < dgph.ver(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(dgph, v);
            }
        }
    }

    /**
     * time complexity - O(V + E).
     * { function_description }.
     *
     * @param      gph     { parameter_description }
     * @param      v     { parameter_description }
     */
    // check that algorithm computes either the topological
    //order or finds a directed cycle
    private void dfs(final Digraph gph, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : gph.arr(v)) {
            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(gph, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }
    /**
     * time complexity - O(1).
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph has a directed cycle,
     * {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Returns a directed cycle if the digraph has a directed cycle,
     * and {@code null} otherwise.
     * @return a directed cycle (as an iterable) if the digraph
     * has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                }
                last = v;
            }
            if (first != last) {
System.err.printf("cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }
        return true;
    }
}
