import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //comstructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int ver = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(ver);
        while (sc.hasNext()) {
            String[] token = sc.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(token[0]),
                Integer.parseInt(token[1]),
                Float.parseFloat(token[2]));
            ewgraph.addEdge(edge);
        }
        LazyPrimMST prim = new LazyPrimMST(ewgraph);
        System.out.format("%.5f", prim.weight());
    }
}




