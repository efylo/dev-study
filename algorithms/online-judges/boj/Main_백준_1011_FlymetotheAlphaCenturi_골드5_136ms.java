
import java.lang.Math;
import java.util.Scanner;

/**
 * Main_백준_1011_FlymetotheAlphaCenturi_골드5_136ms
 */
public class Main_백준_1011_FlymetotheAlphaCenturi_골드5_136ms {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int testcase = scanner.nextInt();

		for (int i = 0; i < testcase; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			int dist = y - x;

			int n = (int) Math.sqrt(dist);

			if (dist == n * n) {
				System.out.println(2 * n - 1);
			} else if (dist <= n * n + n) {
				System.out.println(2 * n);
			} else {
				System.out.println(2 * n + 1);
			}
		} // end of for
	} // end of main
} // end of class
