import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String token = sc.nextLine();
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		String[] n1 = sc.nextLine().split(",");
		GraphRep obj = new GraphRep(v);
		while(sc.hasNext()) {
			String[] n2 = sc.nextLine().split(" ");
			obj.addEdge(Integer.parseInt(n2[0]), Integer.parseInt(n2[1]));
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
