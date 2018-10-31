import java.util.Scanner;
import java.util.Stack;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * { var_description }.
     */
    private boolean[][] grid;
    /**
     * { var_description }.
     */
    private int first = 0;
    /**
     * { var_description }.
     */
    private int last;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * { var_description }.
     */
    private GraphRep gph;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Percolation(final int n) {
        size = n;
        last = size * size + 1;
        gph = new GraphRep(size * size + 2);
        grid = new boolean[size][size];
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void open(final int i, final int j) {
        grid[i - 1][j - 1] = true;
        if (i == 1) {
            gph.addEdge(component(i, j), first);
        }
        if (i == size) {
            gph.addEdge(component(i, j), last);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            gph.addEdge(component(i, j), component(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            gph.addEdge(component(i, j), component(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            gph.addEdge(component(i, j), component(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            gph.addEdge(component(i, j), component(i + 1, j));
        }
    }
    /**
     * Determines if open.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int i, final int j) {
        return grid[i - 1][j - 1];
    }
    /**
     * Determines if full.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     True if full, False otherwise.
     */
    public boolean isFull(final int i, final int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return gph.hasEdge(first, component(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
    ConnectedComponent obj = new ConnectedComponent(gph, first);
        return obj.hasPathTo(last);
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private int component(final int i, final int j) {
        return size * (i - 1) + j;
    }
}
/**
 * Class for connected component.
 */
class ConnectedComponent {
    /**
     * { var_description }.
     */
    private int[] edge;
    /**
     * { var_description }.
     */
    private final int sv;         // source vertex
    /**
     * { var_description }.
     */
    private boolean[] mark;
    /**
     * Constructs the object.
     *
     * @param      graph     { parameter_description }
     * @param      s     { parameter_description }
     */
    ConnectedComponent(final GraphRep graph, final int s) {
        this.sv = s;
        edge = new int[graph.ver()];
        mark = new boolean[graph.ver()];
        validateVertex(sv);
        dfs(graph, sv);
    }
    /**
     * { function_description }.
     *
     * @param      graph     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final GraphRep graph, final int v) {
        mark[v] = true;
        for (int w : graph.arr(v)) {
            if (!mark[w]) {
                edge[w] = v;
                dfs(graph, w);
            }
        }
    }
    /**
     * Determines if it has path to.
     *
     * @param      v     { parameter_description }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return mark[v];
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<Integer> pathTo(final int v) {
        validateVertex(v);
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != sv; x = edge[x]) {
            path.push(x);
        }
        path.push(sv);
        return path;
    }
    /**
     * { function_description }.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        int ver = mark.length;
        if (v < 0 || v >= ver) {
        throw new IllegalArgumentException("vertex "
                + v + " is not between 0 and " + (ver - 1));
    }
}
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Percolation p = new Percolation(size);
        while (sc.hasNext()) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            p.open(n1, n2);
        }
        System.out.println(p.percolates());
    }
}
