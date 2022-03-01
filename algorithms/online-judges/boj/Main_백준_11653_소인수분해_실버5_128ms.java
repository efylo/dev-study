
import java.util.Scanner;

/**
 * Main_백준_11653_소인수분해_실버5_128ms
 */
public class Main_백준_11653_소인수분해_실버5_128ms {

	public static void main(String[] args) {
		// 입력 처리
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1 ~ 10e7
		int p = 2;
		
		// p == 2일 때
		while(N % p == 0) {
			System.out.println(p);
			N /= p;
		}
		p++;
		
		// p에 대한 처리
		/*
		 * p로 나누고 넘기기만 해도 되는 이유?
		 * N을 소수가 아닌 p로 나누었을 때, 나누어 떨어질 수 없다. 
		 * p를 소인수분해하는 p1, p2 등이 이미 N을 나누었기 때문이다. 
		 */
		while(p <= N) {
			while(N % p == 0) {
				System.out.println(p);
				N /= p;
			}
			// 다음 p
			p += 2;
		}
		

	} // end of main
} // end of class
