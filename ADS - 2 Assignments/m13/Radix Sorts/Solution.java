import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LSD lsd = new LSD();
		int n = Integer.parseInt(sc.nextLine());
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}
		lsd.sort(arr, arr[0].length());
		System.out.println(Arrays.toString(arr));
	}
}