import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_1074_Z_실버1_76ms
 */
public class Main_백준_1074_Z_실버1_76ms {
	
	/**
	 * (offsetR, offsetC)를 시작 좌표로 갖는 크기 2^N의 배열
	 * 
	 * 배열을, 2^(N-1) 크기로 나누어서 4분할 탐색을 진행
	 * 
	 * (1) 왼쪽 위
	 *   - offsetR, offsetC: 변하지 않음
	 *   - 이동: 추가 이동 필요 없음
	 *   
	 * (2) 오른쪽 위
	 *   - offsetR, offsetC: offsetC를 1<<(N-1)만큼 이동
	 *   - 이동: 1<<2*(N-1), 4분할된 배열의 크기만큼
	 *   
	 * ...
	 * 
	 * @return targetR, targetC까지 이동한 횟수
	 */
	public static int dq(int N, int offsetR, int offsetC, int targetR, int targetC) {
		// 기저 조건 - offset과 target이 동일할 때
		if (offsetR == targetR && offsetC == targetC) {
			return 0;
		}
		
		/* 2차원 배열 4분할하여 탐색할 순서
		 * 
		 * (1) [offsetR][offsetC]
		 * (2) [offsetR][offsetC + half]
		 * (3) [offsetR + half][offsetC]
		 * (4) [offsetR + half][offsetC + half]
		 */
		
		// 2^N 크기 배열에 대하여, 4분할된 배열의 행과 열의 길이(절반)
		int half = 1<<N-1;
		// 2^N 크기 배열에 대하여, 4분할 하였을 때 각 배열의 크기(1/4)
		int quarter = 1<<2*(N-1);
		
		// 위쪽 탐색
		if (targetR < offsetR + half) {
			// (1) 배열에 존재할 때 - 추가적인 이동이 필요하지 않다. 
			if (targetC < offsetC + half) {
				return dq(N-1, offsetR, offsetC, targetR, targetC);
			}
			// (2) 배열에 존재할 때 - quarter만큼 추가 이동이 필요하다.  
			else {
				return quarter + dq(N-1, offsetR, offsetC+half, targetR, targetC);
			}
		}
		
		// 아래쪽 탐색
		else {
			// (3) 배열에 존재할 때 - quarter*2만큼 추가 이동이 필요하다. 
			if (targetC < offsetC + half) {
				return quarter*2 + dq(N-1, offsetR+half, offsetC, targetR, targetC);
			}
			// (4) 배열에 존재할 때 - quarter*3만큼 추가 이동이 필요하다. 
			else {
				return quarter*3 + dq(N-1, offsetR+half, offsetC+half, targetR, targetC);
			}
		}
		
	} // end of dq
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 배열의 크기의 승 (배열의 크기는 2의 N승이 된다. )
		int N = Integer.parseInt(st.nextToken());
		// 타겟 좌표 r, c
		int targetR = Integer.parseInt(st.nextToken());
		int targetC = Integer.parseInt(st.nextToken());
		
		// 0, 0에서부터 탐색 시작
		System.out.println(dq(N, 0, 0, targetR, targetC));
		
	} // end of main
	
} // end of class
