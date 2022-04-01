
import java.util.Scanner;

/**
 * Main_백준_10870_피보나치수5_브론즈2_116ms
 */
public class Main_백준_10870_피보나치수5_브론즈2_116ms {
	static int fibo(int N) {
		if(N == 0) return 0;
		if(N == 1) return 1;
		return fibo(N-1) + fibo(N-2);
	} // end of fibo
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		System.out.println(fibo(N));
	} // end of main
} // end of class
