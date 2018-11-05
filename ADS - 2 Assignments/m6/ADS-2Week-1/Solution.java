import java.util.*;
import java.util.Arrays;
class PageRank {
	Digraph graph;
	Digraph graph2;
	double ver;
	Double[] pRank;
	PageRank(Digraph dg) {
		this.graph = dg;
		pRank = new Double[dg.V()];
	}
	public Double getPR(int v) {
		graph2 = graph.reverse();
		ver = graph2.V();
		for (int i = 0; i < pRank.length; i++) {
			pRank[i] = 1 / ver;
		}
		for (int i = 1; i < 1000; i++) {
			for (int j = 0; j < graph.V(); j++) {
				Double pr = 0.0; 
				for (int x : graph2.adj(j)) {
					double temp;
					temp = graph.outdegree(x);
					pr = pr + pRank[x] / temp;
				}
				pRank[j] = pr;
			}
			// if (i == 0) {
			// 	pr = 1.0 / graph.V();
			// } else {
			// 	pr += pr / graph.outdegree(v);
			// }
		}
		return pRank[v];
	}
	public String toString() {
		String str = "";
		for (int i = 0; i < pRank.length; i++) {
			str += i + "-" + pRank[i];
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
		System.out.println(pr.toString());
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
