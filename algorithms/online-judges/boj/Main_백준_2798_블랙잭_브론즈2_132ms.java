
import java.util.Scanner;

/**
 * Main_백준_2798_블랙잭_브론즈2_132ms
 */
public class Main_백준_2798_블랙잭_브론즈2_132ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cards = new int[N]; // 3 ~ 100
		
		for (int i = 0; i < cards.length; i++) {
			cards[i] = sc.nextInt();
		}
		// 브루트포스 - 최대 98x98x98번 loop
		int iMax = N - 2;
		int jMax = N - 1;
		int kMax = N;
		int sum = 0;
		for (int i = 0; i < iMax; i++) {
			int temp = cards[i];
			for (int j = i+1; j < jMax; j++) {
				temp += cards[j];
				for (int k = j+1; k < kMax; k++) {
					temp += cards[k];
					// temp 비교
					if (temp <= M) {
						if (M - sum > M - temp) {
							sum = temp;
						}
					}
					// temp 원상복귀
					temp -= cards[k];
				}
				temp -= cards[j];
			}
		}
		System.out.println(sum);
		
	} // end of main
} // end of class
