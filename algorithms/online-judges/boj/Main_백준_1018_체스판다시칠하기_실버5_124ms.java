
import java.util.Scanner;

/**
 * Main_백준_1018_체스판다시칠하기_실버5_124ms
 */
public class Main_백준_1018_체스판다시칠하기_실버5_124ms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		String[] board = new String[N];
		
		for (int i = 0; i < board.length; i++) {
			board[i] = sc.next();
		}
		
//		입력 확인
//		System.out.println(N+","+M);
//		System.out.println(Arrays.toString(board));
		
		int answer = 32;
		int N7 = N - 7;
		int M7 = M - 7;
		char[] blackAndWhite = {'B', 'W'};
		// 시작점 - (i, j)
		for (int i = 0; i < N7; i++) {
			for (int j = 0; j < M7; j++) {
				// 8x8 보드 루프
				int iMax = i + 8;
				int jMax = j + 8;
				int blackCnt = 0;
				int blackIdx = 0; // 검은색 시작만 헤아려도, 하얀색 시작도 헤아져린다. 
				for (int i2 = i; i2 < iMax; i2++) {
					for (int j2 = j; j2 < jMax; j2++) {
						// 현재 위치와 비교
						if (board[i2].charAt(j2) != blackAndWhite[blackIdx]) {
							blackCnt++;
						}
						// idx 업데이트
						if (j2 - j != 7) {
							blackIdx = (blackIdx + 1) % 2;
						}
					}
				}
				answer = Math.min(answer, blackCnt);
				answer = Math.min(answer, 64 - blackCnt); // white 시작 개수
			}
		}
		System.out.println(answer);
	}
}
