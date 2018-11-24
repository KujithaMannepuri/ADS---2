/**
 * Class for breadth first directed paths.
 */
class BreadthFirstDirectedPaths {
    /**
     * infinity.
     */
    private static final int INFINITY = Integer.MAX_VALUE;
    /**
     * marked array.
     */
    private boolean[] marked;  // marked[v] = is there an s->v path?
    /**
     * edge to array.
     */
    private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
    /**
     * distTo array.
     */
    private int[] distTo;      // distTo[v] = length of shortest s->v path

    /** 
     * time complexity - O(V + E).
     * Computes the shortest path from
     *  {@code s} and every other vertex in graph {@code G}.
     * @param g the digraph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public BreadthFirstDirectedPaths(final Digraph g, final int s) {
        marked = new boolean[g.V()];
        distTo = new int[g.V()];
        edgeTo = new int[g.V()];
        for (int v = 0; v < g.V(); v++) {
            distTo[v] = INFINITY;
        }
        validateVertex(s);
        bfs(g, s);
    }

    /** 
     * time complexity - O(V + E).
     * Computes the shortest path from
     * any one of the source vertices in {@code sources}
     * to every other vertex in graph {@code G}.
     * @param g the digraph
     * @param sources the source vertices
     * @throws IllegalArgumentException unless each vertex {@code v} in
     *         {@code sources} satisfies {@code 0 <= v < V}
     */
    public BreadthFirstDirectedPaths(final
        Digraph g, final Iterable<Integer> sources) {
        marked = new boolean[g.V()];
        distTo = new int[g.V()];
        edgeTo = new int[g.V()];
        for (int v = 0; v < g.V(); v++) {
            distTo[v] = INFINITY;
        }
        validateVertices(sources);
        bfs(g, sources);
    }
    /** 
     * time complexity - O(V + E).
     * bfs method.
     * @param      g    digraph.
     * @param      s    integer variable.
     */
    private void bfs(final Digraph g, final int s) {
        Queue<Integer> q = new Queue<Integer>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
    /** 
     * time complexity - O(V + E).
     * bfs method.
     * @param      g  digraph.
     * @param      sources  The sources
     */
    private void bfs(final Digraph g,
                     final Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    /**
     * time complexity - O(1).
     * Is there a directed path from the
     * source {@code s} (or sources) to vertex {@code v}?
     * @param v the vertex
     * @return {@code true} if there is a directed path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * time complexity - O(V).
     * Returns the number of edges in a shortest path from the source {@code s}
     * (or sources) to vertex {@code v}?
     * @param v the vertex
     * @return the number of edges in a shortest path
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int distTo(final int v) {
        validateVertex(v);
        return distTo[v];
    }

    /**
     * Returns a shortest path from {@code s} (or sources) to {@code v}, or
     * {@code null} if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> pathTo(final int v) {
        validateVertex(v);

        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(x);
        return path;
    }

    /**
     * time complexity - O(1).
     * validate vertex method.
     * @param      v   integer variable.
     */
    private void validateVertex(final int v) {
        int ve = marked.length;
        if (v < 0 || v >= ve) {
            throw new IllegalArgumentException("vertex "
             + v + " is not between 0 and " + (v - 1));
        }
    }
    /**
     * time complexity - O(V).
     * validate vertices.
     * @param      vertices  The vertices
     */
    private void validateVertices(final Iterable<Integer> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int ve = marked.length;
        for (int v : vertices) {
            if (v < 0 || v >= v) {
                throw new IllegalArgumentException("vertex "
                 + v + " is not between 0 and " + (ve - 1));
            }
        }
    }
}
/**
 * Class for sap.
 */
public class SAP {
    /**
     * digraph.
     */
    private Digraph dg;
    /**
     * distance.
     */
    private int distance = Integer.MAX_VALUE;
    /**
     * ancestor.
     */
    private int ancestor1 = -1;
    /**
     * Constructs the object.
     *
     * @param      digraph  The digraph
     */
    public SAP(final Digraph digraph) {
        dg = digraph;
    }
    /** 
     * time complexity - O(1).
     * length.
     * @param      v    integer variable.
     * @param      w    integer variable.
     * @return  distance.
     */
    public int length(final int v, final int w) {
        ancestor(v, w);
        return distance;
    }
    /** 
     * time complexity - O(V + E).
     * ancestor.
     * @param      v  integer variable.
     * @param      w  integer variable.
     * @return    ancestor.
     */
    public int ancestor(final int v, final int w) {
        BreadthFirstDirectedPaths b1 = new BreadthFirstDirectedPaths(dg, v);
        BreadthFirstDirectedPaths b2 = new BreadthFirstDirectedPaths(dg, w);
        for (int vertices = 0; vertices < dg.V(); vertices++) {
            if (b1.hasPathTo(vertices) && b2.hasPathTo(vertices)) {
                int newdistance = b1.distTo(vertices) + b2.distTo(vertices);
                if (newdistance < distance) {
                    distance = newdistance;
                    ancestor1 = vertices;
                }
            }
        }
        return ancestor1;
    }
    /**
     * length.
     *
     * @param      v   integer variable.
     * @param      w   integer variable.
     *
     * @return length.
     */
    public int length(final Iterable<Integer> v, final Iterable<Integer> w) {
        ancestor(v, w);
        return distance;
    }
    /** 
     * time complexity - O(V + E).
     * ancestor.
     * @param      v   integer variable.
     * @param      w   integer variable.
     * @return ancestor.
     */
    public int ancestor(final Iterable<Integer> v, final Iterable<Integer> w) {
        for (int v1 : v) {
            for (int w1 : w) {
                ancestor1 = ancestor(v1, w1);
            }
        }
        return ancestor1;
    }
}

