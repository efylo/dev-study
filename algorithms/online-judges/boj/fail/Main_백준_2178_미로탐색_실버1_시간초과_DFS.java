import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main_백준_2178_미로탐색_실버1_ms
 * DFS - 시간 초과 실패
 */
public class Main_백준_2178_미로탐색_실버1_시간초과_DFS {
	
	private static int cnt = 0;
	private static int minDistPossible;
	/** 미로의 크기(NxM) */
	private static int N;
	private static int M;
	/** 미로 정보를 보관할 2차원 boolean 배열 */
	private static boolean[][] maze;
	private static int[][] dist;
	
	
	/**
	 * @param r
	 * @param c
	 * @param visited
	 * @return (r, c)에서 (N-1, M-1)까지의 가능한 최소 거리 / 불가능하다면 -1
	 */
	public static int dfs(int r, int c, boolean[][] visited) {
		// 메모이제이션
		if (dist[r][c] != 0) return dist[r][c];
		
		// 기저 조건 - 탐색 성공
		if (r == N-1 && c == M-1) {
			return 1;
		}
		
		// r, c 방문 처리
		visited[r][c] = true;
		
		// 가지치기 - 가능한 최소 거리를 리턴한다면, 바로 반환
		int minDistrc = minDistPossible - (r + c);
		int result = -1;
		int temp = -1;
		// 현재 호출 스택까지 탐색하지 않았으며, 전진이 가능한 경로
		if (c+1 < M && maze[r][c+1] && !visited[r][c+1]) { // →
			temp = dfs(r, c+1, visited);
			if (temp == minDistrc - 1) { // r, c 부터 N-1, M-1까지 최소 거리
				dist[r][c] = minDistrc;
				return minDistrc;
			}
			if (temp != -1) {
				result = temp;
			}
		}
		if (r+1 < N && maze[r+1][c] && !visited[r+1][c]) { // ↓
			temp = dfs(r+1, c, visited);
			if (temp == minDistrc - 1) { // r, c 부터 N-1, M-1까지 최소 거리
				dist[r][c] = minDistrc;
				return minDistrc;
			}
			if (temp != -1) {
				if (result != -1) {
					result = (temp < result)? temp: result;
				} else {
					result = temp;
				}
			}
		}
		if (c-1 >=0 && maze[r][c-1] && !visited[r][c-1]) { // ←
			temp = dfs(r, c-1, visited);
			if (temp != -1) {
				if (result != -1) {
					result = (temp < result)? temp: result;
				} else {
					result = temp;
				}
			}
		}
		if (r-1 >=0 && maze[r-1][c] && !visited[r-1][c]) { // ↑
			temp = dfs(r-1, c, visited);
			if (temp != -1) {
				if (result != -1) {
					result = (temp < result)? temp: result;
				} else {
					result = temp;
				}
			}
		}
		
		// 현재 호출 스택에서 방문했던 경로 초기화
		visited[r][c] = false;
		
		// 탐색 실패 시, -1 반환
		if (result == -1) return result;
		
		// 탐색 성공 시, 1 + 이후 경로들 중 최소 반환
		dist[r][c] = result + 1;
		return dist[r][c];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		minDistPossible = N + M - 1;
		
		maze = new boolean[N][M];
		dist = new int[N][M];
		
		// 입력 처리
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '1') maze[i][j] = true;
			}
		}

		// (0, 0) -> (N-1, M-1)
		System.out.println(dfs(0, 0, new boolean[N][M]));
				
	} // end of main
} // end of class
