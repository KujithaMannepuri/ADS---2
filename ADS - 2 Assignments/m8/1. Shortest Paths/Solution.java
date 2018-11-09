import java.util.Scanner;
import java.util.HashMap;
/**
 * class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] token = sc.nextLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int m = Integer.parseInt(token[1]);
        String[] str1 = sc.nextLine().split(" ");
        EdgeWeightedGraph edgeWght = new EdgeWeightedGraph(n);
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (int i = 0; i < str1.length; i++) {
            hash.put(str1[i], i);
        }
        while (m > 0) {
            String[] str2 = sc.nextLine().split(" ");
            edgeWght.addEdge(new Edge(
                hash.get(str2[0]),
                 hash.get(str2[1]),
                  Double.parseDouble(str2[2])));
        m--;
        }
        int i = Integer.parseInt(sc.nextLine());
        while (i > 0) {
            String[] str3 = sc.nextLine().split(" ");
            int j = hash.get(str3[0]);
            DijkstraUndirectedSP dij = new DijkstraUndirectedSP(edgeWght, j);
            if (dij.hasPathTo(hash.get(str3[1]))) {
                System.out.println((int) dij.distTo(hash.get(str3[1])));
            }
        i--;
        }
    }
}

