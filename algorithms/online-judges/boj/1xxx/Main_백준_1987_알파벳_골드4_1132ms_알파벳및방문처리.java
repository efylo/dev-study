import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_1987_알파벳_골드4_1132ms_알파벳및방문처리
 */
public class Main_백준_1987_알파벳_골드4_1132ms_알파벳및방문처리 {
	static int R;
	static int C;
	static int[] dr = {1, 0,-1, 0};
	static int[] dc = {0, 1, 0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 보드의 크기 (RxC)
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 보드
		char[][] board = new char[R][];
		
		
		// 보드 입력
		for (int i = 0; i < board.length; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		boolean[][] visited = new boolean[R][C]; // r, c 방문 처리용 배열
		boolean[] used = new boolean[26]; 		 // 'A' ~ 'Z' 사용 여부 확인용 배열
		// 
		int maxDist = backTrack(0, 0, board, visited, used);
		
		System.out.println(maxDist);
	}
	
	
	/**
	 * @param r = 현재 탐색하고자 하는 행 좌표
	 * @param c = 현재 탐색하고자 하는 열 좌표
	 * @param board = 대문자 알파벳이 존재하는 2차원 char 배열
	 * @param visited = 현재까지 방문한 좌표를 저장할 2차원 boolean 배열
	 * @param used = 현재까지 사용한 알파벳을 저장할 1차원 boolean 배열
	 * 			인덱스로는, c - 'A'를 활용한다. 
	 * @return
	 */
	public static int backTrack(int r, int c, char[][] board, boolean[][] visited, boolean[] used) {
		// 방문 처리 - 1) (r, c) 좌표 방문, 2) board[r][c] 문자 사용 처리
		visited[r][c] = true;
		used[board[r][c] - 'A'] = true;
		
		int dist = 1;
		
		int d = 0;
		
		for (int i = 0; i < 4; i++) { // 4방 탐색
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 탐색 가능 여부 - 1) 이동 가능 여부, 2) 방문 여부, 3) 사용한 문자 여부
			if (nr >= 0 && nr < R && nc >= 0 && nc < C 
					&& !visited[nr][nc] 
							&& !used[board[nr][nc] - 'A']) {
				d = Math.max(d, backTrack(nr, nc, board, visited, used));
			}
		}
		
		// 추가 이동 거리 업데이트
		dist += d;
		
		// 방문 철회 - 1) (r, c) 좌표 방문, 2) board[r][c] 문자 사용 처리
		visited[r][c] = false;
		used[board[r][c] - 'A'] = false;
		
		return dist;
	} // end of backTrack
	
} // end of class
