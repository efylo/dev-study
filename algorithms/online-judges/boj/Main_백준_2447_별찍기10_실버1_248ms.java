
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Main_2447_별찍기10_실버1_248ms
 */
public class Main_백준_2447_별찍기10_실버1_248ms {
	/** NxN 2차원 배열 stars에 재귀적으로 별을 추가해주는 메서드 */
	static void countingStar(char[][] stars, int N, int row, int col) {
		// 종료 구문
		if (N == 1) {
			stars[row][col] = '*';
			return;
		}
		// 재귀 호출 (1, 1)위치에는 Space가 호출되어야 한다. 
		int N3 = N / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					countingSpace(stars, N3, row + N3, col + N3);
				} else {
					countingStar(stars, N3, row + N3 * i, col + N3 * j);
				}
			}
		}
	} // end of method - countingStars
	
	/** NxN 2차원 배열 stars에 재귀적으로 빈칸을 추가해주는 메서드 */
	static void countingSpace(char[][] stars, int N, int row, int col) {
		// 종료 구문
		if (N == 1) {
			stars[row][col] = ' ';
			return;
		}
		// 재귀 호출
		int N3 = N / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				countingSpace(stars, N3, row + N3 * i, col + N3 * j);
			}
		}
	} // end of method - countingSpace
	
	public static void main(String[] args) throws IOException {
		// BufferedWriter를 사용해야 시간초과가 일어나지 않음. 
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		
		char[][] stars = new char[N][N];
		
		countingStar(stars, N, 0, 0);
		
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(stars[i][j]);
//			}
//			System.out.println();
//		}
		for (int i = 0; i < N; i++) {
			bw.write(stars[i]);
			bw.write('\n');
		}
		bw.flush();
		bw.close();
		sc.close();
	} // end of main
} // end of class
