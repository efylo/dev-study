

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main_백준_2615_오목_실버2_128ms
 */
public class Main_백준_2615_오목_실버2_128ms {

	public static void main(String[] args) throws FileNotFoundException {
		// 입력 설정
		Scanner sc = new Scanner(System.in);
		// 바둑판 (0 ~ 19 인덱스), 0은 쓰이지 않음
		char[][] board = new char[20][20];
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				board[i][j] = sc.next().charAt(0);
			}
		}
		// 4방 배열
		int[] di = {1, 1, 0,-1};
		int[] dj = {1, 0, 1, 1};
		// 바둑판 탐색
		char result = '0';
		int coordinate = 0;
		outermost: for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				// '0'일 경우 continue
				if (board[i][j] == '0') continue;
				// '1' 혹은 '2'일 경우 count
				char bw = board[i][j];
				// 4방 탐색
				for (int k = 0; k < 4; k++) {
					int count = 1;
					int ti = i + di[k];
					int tj = j + dj[k];
					// 진행 방향 바둑알 세기
					while (ti >= 1 && ti <= 19 && tj >= 1 && tj <= 19) {
						if (board[ti][tj] == bw) count++;
						else break;
						ti = ti + di[k];
						tj = tj + dj[k];
					}
					if (count == 5) {
						// 반대 진행 방향 바둑알 세기 - 6목 이상 검출
						ti = i - di[k];
						tj = j - dj[k];
						while (ti >= 1 && ti <= 19 && tj >= 1 && tj <= 19) {
							if (board[ti][tj] == bw) count--;
							else break;
							ti = ti - di[k];
							tj = tj - dj[k];
						}
						if (count == 5) { // 5목 검출
							result = bw;
							coordinate = i*20 + j;
							break outermost;
						}
					}
				}
			}
		}
		// 결과 출력
		System.out.println(result);
		if (result != '0') {
			int x = coordinate / 20;
			int y = coordinate % 20;
			System.out.println(x+" "+y);
		}
		
		sc.close();
		
	}

}
