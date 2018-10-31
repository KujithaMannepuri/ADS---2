import java.util.Scanner;
import java.util.Stack;
class Percolation {
	boolean[][] grid;
	int first = 0;
	int last;
	int size;
	GraphRep gph;
	Percolation(int n) {
		size = n;
        last = size * size + 1;
        gph = new GraphRep(size * size + 2);
        grid = new boolean[size][size];
	}
	public void open(int i,int j) {
        grid[i-1][j-1] = true;
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
	public boolean isOpen(int i, int j) {
        return grid[i - 1][j - 1];
	}
	public boolean isFull(int i, int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return gph.hasEdge(first, component(i, j));
        } else {
            throw new IndexOutOfBoundsException();
        }
	}
	public boolean percolates() {
        ConnectedComponent obj = new ConnectedComponent(gph,first);
        return obj.hasPathTo(last);
	}
	private int component(int i, int j) {
        return size * (i - 1) + j;
    }

}
class ConnectedComponent {
	private boolean[] mark;
    private int[] edge;
    private final int sv;         // source vertex
    public ConnectedComponent(GraphRep G, int s) {
        this.sv = s;
        edge = new int[G.V()];
        mark = new boolean[G.V()];
        validateVertex(sv);
        dfs(G, sv);
    }

    private void dfs(GraphRep G, int v) {
        mark[v] = true;
        for (int w : G.arr(v)) {
            if (!mark[w]) {
                edge[w] = v;
                dfs(G, w);
            }
        }
    }
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return mark[v];
    }
    public Iterable<Integer> pathTo(int v) {
        validateVertex(v);
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != sv; x = edge[x])
            path.push(x);
        path.push(sv);
        return path;
    }
    private void validateVertex(int v) {
        int V = mark.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Percolation p = new Percolation(size);
		while(sc.hasNext()) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
			p.open(n1,n2);
		}
		System.out.println(p.percolates());
	}
}