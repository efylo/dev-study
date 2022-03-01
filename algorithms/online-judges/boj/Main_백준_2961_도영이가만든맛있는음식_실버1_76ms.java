import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_2961_도영이가만든맛있는음식_실버1_76ms
 */
public class Main_백준_2961_도영이가만든맛있는음식_실버1_76ms {
	
	/** 재료의 개수 */
	private static int N;
	/** 신맛과 쓴맛의 차이 */
	private static int diff = Integer.MAX_VALUE;
	/** 음식의 신맛 정보 */
	private static int[] sours;
	/** 음식의 쓴맛 정보 */
	private static int[] bitters;
	
	/**
	 * 각 pos별로 음식을 선택 / 선택하지 않음에 따른 부분집합을 구한다. 
	 * pos는 0부터 N-1까지 - N일 시 함수 종료
	 * sour는 현재까지 신맛의 곱 - 1로 초기화
	 * bitter은 현재까지 쓴맛의 합 - 0으로 초기화
	 * 
	 * tip
	 *  - sour(신맛의곱)와 bitter(쓴맛의합)를 다음 재귀 호출로 넘겨준다. 
	 *  - bitter = 양의 정수의 합
	 *  - bitter == 0일 경우, 모든 원소가 선택되지 않은 공집합임을 알려준다. 
	 */
	public static void subset(int pos, int sour, int bitter) {
		// 기저 조건 - pos == N일 때
		if (pos == N) {
			// 모든 재료를 사용하지 않았을 경우 바로 종료
			if (bitter == 0) return;
			// 현재 맛의 차이가 더 작다면, diff 업데이트
			int temp = Math.abs(sour - bitter);
			if (temp < diff) diff = temp;
			return;
		}
		// (1) - pos의 원소를 사용할 때
		subset(pos+1, sour*sours[pos], bitter+bitters[pos]);
		
		// (2) - pos의 원소를 사용하지 않을 때
		subset(pos+1, sour, bitter);
		
	} // end of subset
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		// 전역변수 초기화
		sours   = new int[N];
		bitters = new int[N];
		
		// N개의 입력 처리
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sours[i]    = Integer.parseInt(st.nextToken());
			bitters[i]  = Integer.parseInt(st.nextToken());
		} // end of for i
		
		// 신맛은 곱이므로 1로 초기화
		subset(0, 1, 0);
		
		// 출력 처리
		System.out.println(diff);
		
	} // end of main
} // end of class
