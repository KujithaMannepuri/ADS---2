import java.util.Scanner;
interface Graph {
    public int V();
    public int E();
    public void addEdge(int v, int w);
    public Iterable<Integer> arr(int v);
    public boolean hasEdge(int v, int w);
}
class GraphRep implements Graph {
	int vertex;
    int edge;
    Bag<Integer>[] arr;
    GraphRep() {

    }
    public GraphRep(int ver) {
        this.vertex = ver;
        this.edge = 0;
        arr = (Bag<Integer>[]) new Bag[ver];
        for (int i = 0; i < vertex; i++) {
            arr[i] = new Bag<Integer>();
        }
    }
	public int V() {
		return vertex;
    }
	public int E() {
		return edge;
    }

    public Iterable<Integer> arr(int v) {
        return arr[v];
    }

	public void addEdge(int v, int w) {
		if (v == w) {
        	return;
        }
		if (!hasEdge(v,w)) {
            edge++; 
        }
        arr[v].add(w);
        arr[w].add(v);
    }
	
	public boolean hasEdge(int v, int w) {
		for(int k :arr[v]) {
				if (k==w) {
					return true;
				}
		}
		return false;
    }
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
    public void listRep(int v, int e, String[] n2) throws Exception {
    	if (e <= 1 && v <= 1) {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		throw new Exception("No edges");
    	} else {
    		System.out.println(V() + " vertices" + ", " + E() + " edges");
    		for (int i = 0; i < n2.length; i++) {
			String str = "";
			str = n2[i] + ": ";
			for (int k : arr(i)) {
				str = str + n2[k] + " ";
			}
			System.out.println(str);
			}
    	}
    }
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//GraphRep obj = new GraphRep();
		String n1 = sc.nextLine();
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		String[] n2 = sc.nextLine().split(",");
		GraphRep obj = new GraphRep(v);
		while(sc.hasNext()) {
			String[] token = sc.nextLine().split(" ");
			obj.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
		}
		switch (n1) {
			case "Matrix":
			try {
				obj.matrixRep(v, e);
			} catch (Exception z) {
				System.out.println(z.getMessage());
			}
			break;
			case "List":
			try {
				obj.listRep(v, e, n2);
			} catch (Exception z) {
				System.out.println(z.getMessage());
			}
			break;
			default :
			break;
		}
	}
}
