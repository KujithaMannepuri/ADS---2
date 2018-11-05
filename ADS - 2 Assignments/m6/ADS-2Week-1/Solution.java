import java.util.*;
import java.util.Arrays;
class PageRank {
	Digraph graph;
	Digraph graph2;// reverse graph
	double[] pRank;
	PageRank(Digraph dg) {
		this.graph = dg;
		pRank = new double[dg.V()];
	}
	public double getPR(int v) {
		for (int i = 0; i < graph.V(); i++) {
			if (graph.outdegree(i) == 0) {
				for (int j = 0; j < graph.V(); j++) {
					if (i != j) {
						graph.addEdge(i, j);
					}
				}
			}
		}
		graph2 = graph.reverse();
		for (int i = 0; i < pRank.length; i++) {
			pRank[i] = 1 / graph.V();
		}
		double[] temparr = new double[graph.V()];
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < graph.V(); j++) {
				double pr = 0.0; 
				for (int x : graph2.adj(j)) {
					pr = pr + pRank[x] / (double )graph.outdegree(x);
				}
				temparr[j] = pr;
			}
			pRank = Arrays.copyOf(temparr, temparr.length);
			// if (i == 0) {
			// 	pr = 1.0 / graph.V();
			// } else {
			// 	pr += pr / graph.outdegree(v);
			// }
		}
		return pRank[v];
	}
	public String toString() {
		double t = getPR(0);
		String str = "";
		for (int i = 0; i < pRank.length; i++) {
			str = str + i + " - " + pRank[i]+"\n";
		}
		return str;
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner sc = new Scanner(System.in);
		int ver = Integer.parseInt(sc.nextLine());
		Digraph dg = new Digraph(ver);
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		while (sc.hasNextLine()) {
			String[] token = sc.nextLine().split(" ");
			for (int i = 1; i < token.length; i++) {
				dg.addEdge(Integer.parseInt(token[0]), Integer.parseInt(token[i]));
			}
		}
		System.out.println(dg.toString());
		
		// Create page rank object and pass the graph object to the constructor
		PageRank pr = new PageRank(dg);
		// print the page rank object
		System.out.println(pr);
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
