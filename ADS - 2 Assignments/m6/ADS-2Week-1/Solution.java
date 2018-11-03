import java.util.Scanner;
import java.util.Arrays;
class PageRank {
	Digraph graph;
	PageRank(Digraph dg) {
		this.graph = dg;
	}
	public Double getPR(int v) {
		int iv = 1 / graph.V();
		System.out.println(iv);
		return 0.0;
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
