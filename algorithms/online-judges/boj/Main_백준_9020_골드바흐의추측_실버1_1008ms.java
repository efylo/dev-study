
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main_백준_9020_골드바흐의추측_실버1_1008ms
 */
public class Main_백준_9020_골드바흐의추측_실버1_1008ms {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2); // 2는 항상 포함한다. (입력이 4보다 크거나 같으므로)
		
		// 입력 처리
		int TC = sc.nextInt();
		int maxN = 0;
		for (int i = 0; i < TC; i++) {
			inputs.add(sc.nextInt()); // 4 ~ 10000, n % 2 == 0
			if(inputs.get(i) > maxN) maxN = inputs.get(i);
		} // end of for - inputs
		
		// primes 리스트 업데이트
		int ulimit = maxN - 1; // maxN - 1은 primes에 포함될 수 없다. 
		boolean isPrime = true;
		for (int num = 3; num < ulimit; num += 2) {
			isPrime = true;
			for (int p : primes) {
				if (num % p == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) primes.add(num);
		}
		// 입력받은 짝수를 두 소수로 나눈다. 
		for (Integer input : inputs) {
			int bm = input / 2; // 기준점
			int dist = (bm % 2 == 0) ? 1: 0;
			if (bm == 2) {
				bw.write("2 2\n");
				continue;
			}
			for (int d = dist; d < bm; d += 2) {
				int p1 = bm - d;
				int p2 = bm + d;
				boolean p1prime = true; // flag up
				for (int p : primes) {
					if (p == p1) break;
					if (p1 % p == 0 || p > p1) {
						p1prime = false;
						break;
					}
				} // end of for - check p1
				if (!p1prime) continue;
				boolean p2prime = true; // flag up
				for (int p : primes) {
					if (p == p2) break;
					if (p2 % p == 0 || p > p2) {
						p2prime = false;
						break;
					}
				} // end of for - check p2
				if (p2prime) {
					bw.write(p1+" "+p2+"\n");
					break;
				}
			} // end of for - check each distances
		} // end of for - loop for the inputs
		bw.flush();
		bw.close();
		sc.close();
	} // end of main
} // end of class
