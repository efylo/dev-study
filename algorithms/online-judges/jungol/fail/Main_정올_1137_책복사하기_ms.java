import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main_정올_1137_책복사하기_ms
 */
public class Main_정올_1137_책복사하기_ms {
	
	static int M;
	static int K;
	static ArrayList<int[]> until;
	static int[][] dp;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			M = Integer.parseInt(st.nextToken()); // m <= 500, 책 권수
			K = Integer.parseInt(st.nextToken()); // k <= 500, 서기공 명수
			
			int[] books = new int[M]; // 책 배열
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < M; i++) {
				books[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
		} // end of for testCase
		
	} // end of main
	
	public static int find(int m, int k, int[] books, int[] marks) {
		
		
		// m 중에서, 현재 서기공이 작성 가능한 권수
		int max = m-k+1;
		
		for (int i = 1; i <= max; i++) {
			marks[K-k] = (k==K)? i: marks[K-k-1]+i;
			find(m-i, k-1, books, marks);
		}
		
		
		
		return 0;
	}
	
} // end of class
