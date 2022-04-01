
import java.util.Scanner;

/**
 * Main_백준_1436_영화감독숌_실버5_152ms
 */
public class Main_백준_1436_영화감독숌_실버5_152ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int rank = 0;
		int num = 666;
		
		while (rank < N) {
			int temp = num;
			int sixCount = 0;
			while (temp > 0) {
				if (temp % 10 == 6) sixCount++;
				else sixCount = 0;
				
				if (sixCount >= 3) {
					rank++;
					break;
				}
				temp /= 10;
			} // end of inner while
			if (rank == N) break;
			num++;
		} // end of outer while
		System.out.println(num);
	} // end of main
} // end of class
