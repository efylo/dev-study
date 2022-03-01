import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_16926_배열돌리기1_실2_360ms
 */
public class Main_백준_16926_배열돌리기1_실버2_360ms {
	private static int gcd(int a, int b) {
		if (a == 0) return b;
		
		return gcd(b%a, a);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 테두리 별로 분리, 각 테두리를 1차원 배열에 저장
		int borderCount = Math.min(N, M) / 2;
		int borderSize = 2*(M-1) + 2*(N-1);
		int[][] borders = new int[borderCount][];
		
		for (int i = 0; i < borderCount; i++) {
			borders[i] = new int[borderSize];
			borderSize -= 8;
		}
		
		int borderIndex;
		int borderCol;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				borderIndex = Math.min(Math.min(i, j), Math.min(N-1-i, M-1-j));
				
				int cMax = M-1-2*borderIndex; // 열은, 0 ~ cMax까지
				int rMax = N-1-2*borderIndex; // 행은, 0 ~ rMax까지
				
				borderCol = (borderIndex == i)? j-i: 
					(borderIndex == M-1-j)? cMax + (i-borderIndex):
						(borderIndex == N-1-i)? (cMax + rMax) + (M-1-borderIndex - j):
							(2*cMax + rMax) + (N-1-borderIndex - i);
				borders[borderIndex][borderCol] =  Integer.parseInt(st.nextToken());
			}
		}
		
		// R만큼 회전
		for (int i = 0; i < borders.length; i++) {
			int size = borders[i].length;
			int r = R % size;
			int k = gcd(size, r);
			
			for (int set = 0; set < k; set++) {
				int start = set;
				int temp = borders[i][start];
				
				int loop = size / k;
				for (int j = 0; j < loop-1; j++) {
					borders[i][(start + j*r) % size] = borders[i][(start + (j+1)*r) % size];
				}
				
				borders[i][(start + (loop-1)*r) % size] = temp;
			}
		}
		
		// 출력합시다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				borderIndex = Math.min(Math.min(i, j), Math.min(N-1-i, M-1-j));
				
				borderCol = (borderIndex == i)? j-i: 
					(borderIndex == M-1-j)? M-1+i-3*borderIndex: 
						(borderIndex == N-1-i)? 2*M+N-3-j-borderIndex*5:
							2*(M+N)-4-i-borderIndex*7;
				
				sb.append(borders[borderIndex][borderCol]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	} // end of main
} // end of class
