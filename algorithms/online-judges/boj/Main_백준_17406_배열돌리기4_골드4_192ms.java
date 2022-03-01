import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_17406_배열돌리기4_골드4_192ms
 */
public class Main_백준_17406_배열돌리기4_골드4_192ms {
	
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[][] commands;
	private static int K;
	
	/**
	 * @return 배열의 행 합의 최솟값을 리턴
	 */
	public static int minRow() {
		int result = Integer.MAX_VALUE;
		
		for (int r = 1; r <= N; r++) {
			int temp = 0;
			for (int c = 1; c <= M; c++) {
				temp += arr[r][c];
			}
			if (temp < result) result = temp;
		}
		
		return result;
	}
	
	/**
	 * @param command
	 * 커맨드의 입력값에 따라 배열을 오른쪽으로 회전
	 * command = {r, c, s}
	 */
	public static void rotateRight(int[] command) {
		// 명령 값 복사
		int r = command[0];
		int c = command[1];
		int s = command[2];
		
		for (int i = s; i > 0; i--) {
			// (r-s ~ r+s), (c-s ~ c+s) 회전
			int row = r - i;
			int col = c - i;
			int temp = arr[row][col];
			
			for (int j = 0; j < 2*i; j++) { // ↓
				arr[row][col] = arr[++row][col];
			}
			for (int j = 0; j < 2*i; j++) { // ←
				arr[row][col] = arr[row][++col];
			}
			for (int j = 0; j < 2*i; j++) { // ↑
				arr[row][col] = arr[--row][col];
			}
			for (int j = 0; j < 2*i; j++) { // →
				arr[row][col] = arr[row][--col];
			}
			
			arr[row][++col] = temp;
		}
	}
	
	/**
	 * @param command
	 * 커맨드의 입력값에 따라 배열을 왼쪽으로 회전
	 * command = {r, c, s}
	 */
	public static void rotateLeft(int[] command) {
		// 
		int r = command[0];
		int c = command[1];
		int s = command[2];
		
		for (int i = s; i > 0; i--) {
			// (r-s ~ r+s), (c-s ~ c+s) 회전
			int row = r - i;
			int col = c - i;
			int temp = arr[row][col];
			
			for (int j = 0; j < 2*i; j++) { // →
				arr[row][col] = arr[row][++col];
			}
			for (int j = 0; j < 2*i; j++) { // ↓
				arr[row][col] = arr[++row][col];
			}
			for (int j = 0; j < 2*i; j++) { // ←
				arr[row][col] = arr[row][--col];
			}
			for (int j = 0; j < 2*i; j++) { // ↑
				arr[row][col] = arr[--row][col];
			}
			
			arr[++row][col] = temp;
		}
	}
	
	/**
	 * @param cnt, visited
	 * cnt번째 연산을 수행, cnt가 끝까지 진행됐을 경우 최소값을 리턴
	 * 매 방문시마다 visited를 업데이트?
	 */
	public static int perm(int cnt, boolean[] visited) {
		// basis part - K개의 순열을 다 채웠을 때
		if (cnt == K) return minRow();
		
		int result = 987654321;
		// cnt번째 자리를 탐색
		for (int i = 0; i < K; i++) {
			if (visited[i]) continue;
			
			// i번째 연산 진행
			rotateRight(commands[i]);
			visited[i] = true;
			result = Math.min(result, perm(cnt+1, visited));
			
			// i번째 연산 초기화
			rotateLeft(commands[i]);
			visited[i] = false;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1-based index
		arr = new int[N+1][M+1];
		
		// 입력 처리
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		// r, c, s
		commands = new int[K][3];
		
		// 연산 입력
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			commands[i][0] = Integer.parseInt(st.nextToken());
			commands[i][1] = Integer.parseInt(st.nextToken());
			commands[i][2] = Integer.parseInt(st.nextToken());			
		}
		
		sb.append(perm(0, new boolean[K])).append("\n");
		
		// 출력 처리
		System.out.print(sb.toString());
	}
}
