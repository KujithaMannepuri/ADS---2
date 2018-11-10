import java.util.Scanner;
class Graph {

}
public class Solution {
	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < k; i++) {
			String[] token = sc.nextLine().split(" ");
			//System.out.println(Arrays.toString(token));
		}
		String caseToGo = sc.nextLine();

		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.

			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			System.out.println("No Path Found. ");
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