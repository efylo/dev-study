import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Main_백준_1941_소문난칠공주_골드3_ms
 * 
 *  - 아이디어
 *    : N-Queen 느낌으로..
 * 
 */
public class Main_백준_1941_소문난칠공주_골드3_ms {
	
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] selected = new int[5][2]; // {start, persons};
		char[][] map = new char[5][];
		
		for (int r = 0; r < 5; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		int result = dfs(0, 0, map, selected);
		
		System.out.println(result);
		
	} // end of main
	
	/** 현재 행 r에서부터 가능한 인원수만큼 선택 -> 다음 행으로 재귀 */
	public static int dfs(int r, int cnt, char[][] map, int[][] selected) {
		if (r==5) {
			if (cnt == 7) {
				int dasom = 0;
				for (int i = 0; i < 5; i++) {
					int s = selected[i][0];
					int p = selected[i][1];
					for (int j = s; j < s+p; j++) {
						if (map[i][j] == 'S') dasom++;
					}
				}
				for (int i = 0; i < selected.length; i++) {
					System.out.print(Arrays.toString(selected[i])+", ");
				}
				System.out.println(dasom);
				if (dasom >= 4) {
					return 1;
				}
				return 0;
			}
			else {
				return 0;
			}
		}
		
		
		int result = 0;
		
		if (cnt == 0) {
			for (int p = 0; p <= 5; p++) {
				
			}
			result += dfs(r+1, cnt, map, selected);
		}
		
		// r행에서, s열부터 p명을 뽑는 모든 경우
		for (int s = 0; s < 5; s++) {
			
			for (int p = 1; p <= 5-s; p++) {
				selected[r][0] = s;
				selected[r][1] = p;
				if (r == 0) result += dfs(r+1, cnt+p, map, selected);
				else if (selected[r-1][0] < s+p && s < selected[r-1][0]+selected[r-1][1]) {
					result += dfs(r+1, cnt+p, map, selected);					
				}
			} // end of p
		} // end of s
		
		// 초기화
		selected[r][0] = 0;
		selected[r][1] = 0;
		
		return result;
	} // end of dfs
	
} // end of class
