import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_1992_쿼드트리_실버1_84ms
 */
public class Main_백준_1992_쿼드트리_실버1_84ms {
	
	public static void quadTree(int N, int r, int c, char[][] crr, StringBuilder sb) {
		char x = crr[r][c];
		
		// 기저 조건(1) - 크기가 1일 경우
		if (N == 1) {
			sb.append(x);
			return;
		}
		
		// (r, c) ~ (r+N, c+N)까지의 전체 데이터 확인
		boolean equiv = true;
outer:	for (int i = r, rsize = r+N; i < rsize; i++) { 
			for (int j = c, csize = c+N; j < csize; j++) {
				if (crr[i][j] != x) {
					equiv = false;
					break outer;
				}
			}
		}
		
		// 기저 조건(2) - 만약 전체 데이터가 동일한 경우
		if (equiv) {
			sb.append(x);
			return;
		}
		
		// 데이터가 각각 다를 때 - '(', ')'를 통해 분할
		sb.append("(");
		int half = N>>1;
		quadTree(half, r, 	   c,      crr, sb); // 2사분면
		quadTree(half, r, 	   c+half, crr, sb); // 1사분면
		quadTree(half, r+half, c,      crr, sb); // 3사분면
		quadTree(half, r+half, c+half, crr, sb); // 4사분면
		sb.append(")");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());  // 영상의 크기 1 <= N <= 64, 2의 제곱수;
		char[][] crr = new char[N][N];            // 입력받은 0과 1을 저장하기 위한 char형 배열
		
		for (int i = 0; i < N; i++) {
			crr[i] = br.readLine().toCharArray();
		}
		
		// 반복문으로는 힘들 듯 싶다 - 분할 & 정복이 필요하기 때문
		quadTree(N, 0, 0, crr, sb);
		
		System.out.print(sb.toString());
		
	} // end of main
	
} // end of class
