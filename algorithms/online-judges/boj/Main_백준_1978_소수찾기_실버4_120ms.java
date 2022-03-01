

import java.util.Scanner;

/**
 * Main_백준_1978_소수찾기_난이도미정_120ms
 */
public class Main_백준_1978_소수찾기_실버4_120ms {
	public static void main(String[] args) {
		// 스캐너 객체 생성, 시스템 인풋
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ~100
		int cnt = 0; // 소수의 개수
		// N개의 수 입력받기
		in: for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			// 소수 판별 알고리즘
			switch (num) {
			case 1:
				continue in;
			case 2:
				cnt++;
				continue in;
			default:
				if (num % 2 == 0) continue in;
				for (int x = 3; x <= (int) Math.sqrt(num); x+=2) {
					if (num % x == 0) continue in;
				}
				cnt++;
				break;
			} // end of switch
		} // end of for N
		System.out.println(cnt);
	} // end of main
} // end of class
