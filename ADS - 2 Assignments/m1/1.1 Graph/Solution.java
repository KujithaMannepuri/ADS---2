import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constrcutor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String token = sc.nextLine();
        sc.nextLine();
        int v = sc.nextInt();
        int e = sc.nextInt();
        String[] n1 = sc.nextLine().split(",");
        GraphRep obj = new GraphRep(v);
        while (sc.hasNext()) {
            String[] n2 = sc.nextLine().split(" ");
            obj.addEdge(Integer.parseInt(n2[0]),
                Integer.parseInt(n2[1]));
        }
        switch (token) {
            case "Matrix":
            try {
                obj.matrixRep(v, e);
            } catch (Exception z) {
                System.out.println(z.getMessage());
            }
            break;
            case "List":
            try {
                obj.listRep(v, e, n1);
            } catch (Exception z) {
                System.out.println(z.getMessage());
            }
            break;
            default :
            break;
        }
    }
}


