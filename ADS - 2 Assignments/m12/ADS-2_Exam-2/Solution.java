import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	public static void main(final String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph obj = new EdgeWeightedGraph(n);
		for (int i = 0; i < k; i++) {
			String[] token = sc.nextLine().split(" ");
			obj.addEdge(new Edge(Integer.parseInt(token[0]), Integer.parseInt(token[1]), Double.parseDouble(token[2])));
			//System.out.println(Arrays.toString(token));
		}
		String caseToGo = sc.nextLine();
		DijkstraUndirectedSP dijkstra;
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(obj);
			
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			int s = sc.nextInt();
			int d = sc.nextInt();
			dijkstra = new DijkstraUndirectedSP(obj, s);
			if ((dijkstra.distTo(d)) == Double.POSITIVE_INFINITY) {
				System.out.println("No Path Found.");
			} else {
				System.out.println(dijkstra.distTo(d));
			}
			break;
		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			System.out.println("No Path Found. ");
			break;

		default:
			break;
		}

	}
}