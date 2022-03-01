import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_16926_배열돌리기1_실2_592ms
 */
public class Main_백준_16926_배열돌리기1_실2_592ms {
	
	public static void rotate(int[][] arr, int N, int M, int R) {
		// 회전
		int offset = 0;
		int offsetMax = Math.min(N, M) / 2;
		
		for (int loop = 0; loop < R; loop++) {
			offset = 0;
			
			while(offset < offsetMax) {
				int cDist = (M-1) - 2*offset; // 행 이동
				int rDist = (N-1) - 2*offset; // 열 이동
				
				int temp = arr[offset][offset];
				int r = offset;
				int c = offset;
				for (int i = 0; i < cDist; i++) { // ←
					arr[r][c] = arr[r][++c];
				}
				for (int i = 0; i < rDist; i++) { // ↑
					arr[r][c] = arr[++r][c];
				}
				for (int i = 0; i < cDist; i++) { // →
					arr[r][c] = arr[r][--c];
				}
				for (int i = 0; i < rDist; i++) { // ↓
					arr[r][c] = arr[--r][c];
				}
				arr[++r][c] = temp;
				
				offset++;
			} // end of while offset
		} // end of for loop
	} // end of rotate
	
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) { // NxM 배열 입력 처리
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 회전 함수 호출
		rotate(arr, N, M, R);
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	} // end of main
} // end of class
