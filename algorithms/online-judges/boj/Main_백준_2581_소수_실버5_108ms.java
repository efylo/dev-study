


import java.util.Scanner;

/**
 * Main_백준_2581_소수_실버5_108ms
 */
public class Main_백준_2581_소수_실버5_108ms {

	public static void main(String[] args) {
		// 입력 처리
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		// 구해야 하는 값 초기화
		int psum = 0;
		int pmin = 0;
		// M 처리(1) - M이 1이나 2일 때
		if (M == 1) {
			M++;
		} if (M == 2) {
			if (M <= N) {
				psum = 2;
				pmin = 2;
			}
			M++;
		}
		// M 처리(2) - M을 홀수로 변환
		if (M%2 == 0) M++;
		// M 처리(3) - M이 3 이상일 때에 대해 동일한 로직 적용
		while (M <= N) {
			// 소수 확인
			int max = (int) Math.sqrt(M);
			boolean isPrime = true;
			for(int denom=3; denom<=max; denom+=2) {
				if(M % denom == 0) isPrime = false;
			}
			// 만약 소수라면
			if (isPrime) {
				if (pmin == 0) {
					pmin = M;
				}
				psum += M;
			}
			// 2씩 증가
			M += 2;
		}
		if (psum == 0) {
			System.out.println("-1");
		} else {
			System.out.println(psum);
			System.out.println(pmin);
		}
	}

}
