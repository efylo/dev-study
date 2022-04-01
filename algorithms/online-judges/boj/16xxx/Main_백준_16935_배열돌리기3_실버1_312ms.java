import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_16935_배열돌리기3_실1_396ms
 * 
 * 카메라 기능들?
 */
public class Main_백준_16935_배열돌리기3_실버1_312ms {
	
	private static int N;
	private static int M;
	private static int R;
	
	private static int[][] arr;
	private static int[][] tempArr;

	/** 1번 연산 - O(NM) */
	private static void upsideDown() { 
		for (int c = 0; c < M; c++) {
			int temp;
			for (int r = 0; r < N/2; r++) {
				temp = arr[r][c];
				arr[r][c] = arr[N-1-r][c];
				arr[N-1-r][c] = temp;
			}
		}
	} // end of upsideDown
	
	/** 2번 연산 - O(NM) */
	private static void mirror() {
		for (int r = 0; r < N; r++) {
			int temp;
			for (int c = 0; c < M/2; c++) {
				temp = arr[r][c];
				arr[r][c] = arr[r][M-1-c];
				arr[r][M-1-c] = temp;
			}
		}
	} // end of mirror
	
	/** 3번 연산 - O(NM) */
	private static void rotateRight() {
		int row = M;
		int col = N;
		tempArr = new int[row][col];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tempArr[c][N-1-r] = arr[r][c];
			}
		}
		// 값 변환
		N = row;
		M = col;
		arr = tempArr;
		tempArr = null;
	}
	
	/** 4번 연산 - O(NM) */
	private static void rotateLeft() {
		int row = M;
		int col = N;
		tempArr = new int[row][col];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				tempArr[M-1-c][r] = arr[r][c];
			}
		}
		// 값 변환
		N = row;
		M = col;
		arr = tempArr;
		tempArr = null;
	}
	
	/** 5번 연산 */
	private static void wholeRotateRight() {
		int temp;		
		int halfN = N/2;
		int halfM = M/2;
		
		for (int r = 0; r < halfN; r++) {
			for (int c = 0; c < halfM; c++) {
				temp = arr[r][c]; 			 			 // temp <- 1번
				arr[r][c] = arr[r+halfN][c]; 			 // 1번 <- 4번
				arr[r+halfN][c] = arr[r+halfN][c+halfM]; // 4번 <- 3번
				arr[r+halfN][c+halfM] = arr[r][c+halfM]; // 3번 <- 2번
				arr[r][c+halfM] = temp;					 // 2번 <- temp
			}
		}
	}
	
	/** 6번 연산 */
	private static void wholeRotateLeft() {
		int temp;		
		int halfN = N/2;
		int halfM = M/2;
		// 1번 서브배열 저장
		for (int r = 0; r < halfN; r++) {
			for (int c = 0; c < halfM; c++) {
				temp = arr[r][c];
				arr[r][c] = arr[r][c+halfM];
				arr[r][c+halfM] = arr[r+halfN][c+halfM];
				arr[r+halfN][c+halfM] = arr[r+halfN][c];
				arr[r+halfN][c] = temp;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) { // 배열 입력처리
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of for array input
		
		// 연산 처리
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			String cmd = st.nextToken();
			switch (cmd) {
			case "1":
				upsideDown();
				break;
			case "2":
				mirror();
				break;
			case "3":
				rotateRight();
				break;
			case "4":
				rotateLeft();
				break;
			case "5":
				wholeRotateRight();
				break;
			case "6":
				wholeRotateLeft();
				break;
			default:
				break;
			} // end of switch cmd
		}
		
		// 출력 처리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
		
	} // end of main
	
} // end of class
