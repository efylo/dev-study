import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_2567_색종이2_실버4_80ms
 */
public class Main_백준_2567_색종이2_실버4_80ms {
	
	final static int WHITE = 0;
	final static int BLACK = 1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		int N = Integer.parseInt(br.readLine()); // N <= 100
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r0 = Integer.parseInt(st.nextToken());
			int c0 = Integer.parseInt(st.nextToken()); // 종이의 방향은 생각할 필요 X
			
			for (int r = r0; r < r0+10; r++) {
				for (int c = c0; c < c0+10; c++) {
					map[r][c] = BLACK;
				}
			}
		}
		
		int result = 0;
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				if (map[r][c] == BLACK) {
					result += dfs(r, c, map);
				}
			}
		}
		
		System.out.println(result);
	} // end of main

	public static int dfs(int r, int c, int[][] map) {
		// 방문 처리
		map[r][c] = -1;
		
		// 둘레의 길이가 추가되는 경우
		//  : 테두리를 마주쳤을 때, 하얀색 부분을 마주쳤을 때
		int border = 0;
		if (r-1 < 0) border++;
		else if (map[r-1][c] == WHITE) border++;
		else if (map[r-1][c] == BLACK) border += dfs(r-1, c, map);
		
		if (c-1 < 0) border++;
		else if (map[r][c-1] == WHITE) border++;
		else if (map[r][c-1] == BLACK) border += dfs(r, c-1, map);
		
		if (r+1 == 100) border++;
		else if (map[r+1][c] == WHITE) border++;
		else if (map[r+1][c] == BLACK) border += dfs(r+1, c, map);
		
		if (c+1 == 100) border++;
		else if (map[r][c+1] == WHITE) border++;
		else if (map[r][c+1] == BLACK) border += dfs(r, c+1, map);
		
		return border;
	} // end of dfs
	
} // end of class
