import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Main_백준_2667_단지번호붙이기_실버1_84ms
 */
public class Main_백준_2667_단지번호붙이기_실버1_84ms {
	private static boolean[][] map;
	private static int N;
	
	public static int dfs(int r, int c) {
		// 기저 조건
		if (!map[r][c]) return 0;
		
		// 방문 처리
		map[r][c] = false;
		
		// r, c의 집 개수
		int cnt = 1;
		
		// 4방향 탐색
		if (r+1 <  N) cnt += dfs(r+1, c);
		if (r-1 >= 0) cnt += dfs(r-1, c);
		if (c+1 <  N) cnt += dfs(r, c+1);
		if (c-1 >= 0) cnt += dfs(r, c-1);
		
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		
		// 입력 처리
		map = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '1') map[i][j] = true;
			}
		}
		
		// 전체 map을 순회하며 단지 내 집의 수를 저장할 자료구조
		// 우선 순위 큐가 훨씬 빠르다. (리스트보다)
		PriorityQueue<Integer> houses = new PriorityQueue<Integer>();
		
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				int temp = dfs(r, c);
				if (temp > 0) {
					houses.offer(temp);
				}
			}
		}
		
		sb.append(houses.size()).append("\n");
		
		while (!houses.isEmpty()) {
			sb.append(houses.poll()).append("\n");
		}
		
		// 출력 처리
		System.out.print(sb.toString());
		
	} // end of main
} // end of class
