
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main_백준_1929_소수구하기_기본_388ms
 */
public class Main_백준_1929_소수구하기_실버2_388ms {
	public static void main(String[] args) throws IOException {
		// 입력 처리
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 1 <= M <= N <= 1,000,000
		int N = sc.nextInt();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		// primes 리스트 구현
		primes.add(2);
		int rootN = (int) Math.sqrt(N);
		boolean isPrime = true;
		for (int num = 3; num <= rootN; num += 2) {
			isPrime = true;
			for (Integer prime : primes) {
				if (num % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) primes.add(num);
		}
		// 출력 클래스
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// M부터 N까지 primes 확인
		if (M <= 2) {
			bw.write(2+"\n");
			M = 3;
		}
		if (M % 2 == 0) M++;
		for (int num = M; num <= N; num += 2) {
			isPrime = true;
			rootN = (int) Math.sqrt(num);
			for (Integer prime : primes) {
				if (prime > rootN) break;
				if (num % prime == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) bw.write(num+"\n");
		}
		bw.flush();
		bw.close();
		
	} // end of main
} // end of class
