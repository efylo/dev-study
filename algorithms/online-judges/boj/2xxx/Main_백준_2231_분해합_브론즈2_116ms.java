
import java.util.Scanner;

/**
 * Main_백준_2231_분해합_브론즈2_116ms
 */
public class Main_백준_2231_분해합_브론즈2_116ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int answer = 0;
		
		int exp = 1; // 자리수
		int temp = N;
		while(temp / 10 > 0) {
			exp++;
			temp /= 10;
		}
		for (int num = Math.max(N - 9 * exp, 1); num < N; num++) {
			int temp1 = num;
			int temp2 = num;
			while(temp2 > 0) {
				temp1 += temp2 % 10;
				temp2 /= 10;
			}
			if (temp1 == N) {
				answer = num;
				break;
			}
		}
		System.out.println(answer);
	} // end of main
} // end of class
