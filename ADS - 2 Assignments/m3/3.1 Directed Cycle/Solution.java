import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
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
        int v = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());
        DiGraphRep dg = new DiGraphRep(v);
        while (e >= 0) {
            String[] token = sc.nextLine().split(" ");
            int n1 = Integer.parseInt(token[0]);
            int n2 = Integer.parseInt(token[1]);
            dg.addEdge(n1, n2);
            e--;
        }
        DirectedCycle dc = new DirectedCycle(dg);
        if (dc.hasCycle()) {
            System.out.println("Cycle exists. ");
        } else {
            System.out.println("Cycle doesn't exists. ");
        }
    }
}