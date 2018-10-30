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

            arr[v].add(w);
            arr[w].add(v); 
        }
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