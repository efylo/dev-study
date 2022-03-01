
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Main_백준_4948_베르트랑공준_실버2_672ms
 */
public class Main_백준_4948_베르트랑공준_실버2_672ms {
	public static void main(String[] args) throws IOException {
		// 입출력 처리
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		int maxPrime = 2;
				
		int n = sc.nextInt();
		while (n != 0) { // n < x <= 2*n인 소수 판별 알고리즘 구현
			// primes 업데이트
			int cnt = 0;
			int n2 = 2 * n;
			int rootn2 = (int) Math.sqrt(n2);
			// flag
			boolean isPrime = true;
			// sqrt(2n)이 maxPrime보다 크다면, primes update
			if (rootn2 > maxPrime) {
				int start = (maxPrime % 2 == 0)? maxPrime + 1: maxPrime + 2; 
				for (int num = start; num <= rootn2; num += 2) {
					isPrime = true;
					for (Integer prime : primes) {
						if (num % prime == 0) {
							isPrime = false;
							break;
						}
					}
					if (isPrime) primes.add(num);
				}
			}
			// n < ... <= 2*n에 대한 소수 판별 구현
			if (n == 1) n = 2;
			else if (n % 2 == 0) n++;
			else n += 2;
			for(int num = n; num <= n2; num += 2) {
				isPrime = true;
				for (Integer prime : primes) {
					if (prime > rootn2) break;
					if (num % prime == 0) {
						isPrime = false;
						break;
					}
				}
				if (isPrime) cnt++;
			} // end of for
			bw.write(cnt + "\n");
			// update n
			n = sc.nextInt();
		} // end of while
		bw.flush();
		bw.close();
		sc.close();
	} // end of main

} // end of class
