import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Main_백준_2239_스도쿠_골드4_408ms
 * 
 * 아이디어
 *  - DFS: 
 *    1. 현재 (r, c) 노드에서 가능한 모든 값을 try
 *      - 가능한 모든 값을 구해야 함
 *    2. 다음(r, c+1) 값에 대해 재귀 호출
 *    3. 현재 (r, c) 값에 대해, 다음 값이 가능하다면 true 반환
 *    4. 모든 값이 가능하지 않다면, false 반환
 *      - (r, c)의 값을 초기화하여, 정답이 아님을 이전 호출에 알려줘야함
 *      - 현재 가능한 값 또한, 배열이 변한다면 바뀌기 때문에 초기화해줘야함 
 *      
 *  - 배열의 초기화: Arrays.fill(array, value) 를 통해 빠르게 초기화 가능
 *  
 *  - 메모리 최적화: 가능한 값을 구할 배열의 사이즈를 미리 정하여, 메모리 최적화 가능
 *  
 * 왜 DFS?
 *  - 현재 좌표 (r, c)에 A 값을 대입한다면, sudoku 배열이 하나의 node가 된다. 
 *  - A 값이 대입된 sudoku 노드에 대하여, 가능한 다음 node를 계속하여 탐색하기 때문에 DFS이다. 
 *  
 */
public class Main_백준_2239_스도쿠_골드4_408ms {
	
	private static int[][] sudoku;
	private static boolean[][][] isImpossible;
		
	public static void update(int r, int c) {
		boolean[] temp = isImpossible[r][c];
		for (int ctemp = 0; ctemp < sudoku.length; ctemp++) {
			temp[sudoku[r][ctemp]] = true;
		}
		for (int rtemp = 0; rtemp < sudoku.length; rtemp++) {
			temp[sudoku[rtemp][c]] = true;
		}
		int rtemp = (r/3)*3;
		int ctemp = (c/3)*3;
		for (int dr = 0; dr < 3; dr++) {
			for (int dc = 0; dc < 3; dc++) {
				temp[sudoku[rtemp+dr][ctemp+dc]] = true;
			}
		}
	}
	
	public static void init(boolean[] brr) {
		Arrays.fill(brr, false);
	}
		
	// 0,0 -> 0,1 -> 0,2 
	
	public static boolean dfs(int r, int c) {
		// 인덱스 업데이트
		if (c == 9) {
			r++;
			c = 0;
			// r이 9일 경우, sudoku 배열 전체를 순회했을 때 뿐
			if (r == 9) return true;
		}
		
		// 기저 조건 - r, c 원소에 값이 있을 경우 다음 r, c를 탐색한다. 
		if (sudoku[r][c] != 0) {
			return dfs(r, c+1);
		}
		
		// isImpossible 배열을 현재 r, c에 맞게 업데이트해준다. 
		update(r, c);
		
		boolean[] temp = isImpossible[r][c];
		// 1부터 9까지 중, 가능한 모든 원소들에 대하여 시도한다. 
		for (int no = 1; no < 10; no++) {
			if (temp[no]) continue;
			sudoku[r][c] = no;
			// (r, c)에 no가 가능한지 판별 - 가능하다면 즉시 반환
			if (dfs(r, c+1)) return true;
		}
		
		// 현재 주어진 sudoku 배열에 대하여 (r, c)의 모든 값들이 불가능하다. 
		// 사용한 (r, c)의 값 및 배열을 초기화해주고 false를 반환한다. 
		sudoku[r][c] = 0;
		init(temp);
		
		return false;
	} // end of update

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 전역 변수 초기화
		sudoku = new int[9][9];
		isImpossible = new boolean[9][9][10]; // 0, [true, true, false, 
		
		// 입력 처리
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = str.charAt(j) - '0';
			}
		}
		
		// DFS - 재귀 함수 호출
		dfs(0, 0);
		
		// 출력 처리
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku.length; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	} // end of main
} // end of class
