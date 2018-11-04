/**
 * Class for bipartite.
 */
public class Bipartite {
    /**
     * boolean variable.
     */
    private boolean isBipartite;
    /**
     * boolean array.
     */
    private boolean[] color;
    /**
     * boolean array.
     */
    private boolean[] mark;
    /**
     * Integer array.
     */
    private int[] edgeTo;
    /**
     * Stack.
     */
    private Stack<Integer> cycle;

    /**
     * Determines whether an undirected graph is bipartite and finds either a
     * bipartition or an odd-length cycle.
     *
     * @param  g the graph
     */
    Bipartite(final GraphRep g) {
        isBipartite = true;
        color  = new boolean[g.ver()];
        mark = new boolean[g.ver()];
        edgeTo = new int[g.ver()];

        for (int v = 0; v < g.ver(); v++) {
            if (!mark[v]) {
                dfs(g, v);
            }
        }
    }
    /**
     * Iterable.
     *
     * @return     cycle.
     */
    public Iterable<Integer> oddCycle() {
        return cycle;
    }
    /**
     * Returns true if the graph is bipartite.
     *
     * @return boolean value.
     */
    public boolean isBipartite() {
        return isBipartite;
    }
    /**
     * Returns the side of the bipartite that vertex is on.
     *
     * @param      v     Integer variable,
     *
     * @return     Boolean
     */
    public boolean color(final int v) {
        if (!isBipartite) {
            throw new UnsupportedOperationException("graph is not bipartite");
        }
        return color[v];
    }
    /**
     * Depth First Search.
     * Time complexity of this method is O(V + E).
     * @param      g1     Graph
     * @param      v      Interger variable.
     */
    private void dfs(final GraphRep g1, final int v) {
        mark[v] = true;
        for (int w : g1.arr(v)) {
            if (cycle != null) {
                return;
            }
            if (!mark[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(g1, w);
            } else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }
}
