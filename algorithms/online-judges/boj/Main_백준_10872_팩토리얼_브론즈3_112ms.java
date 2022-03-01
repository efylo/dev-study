
import java.util.Scanner;

/**
 * Main_백준_10872_팩토리얼_브론즈3_112ms
 */
public class Main_백준_10872_팩토리얼_브론즈3_112ms {
	static int factorial(int N) {
		if (N == 0) return 1;
		return N * factorial(N-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(factorial(N));
	} // end of main
} // end of class
