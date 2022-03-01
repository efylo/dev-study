import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Main_정올_1828_냉장고_135ms
 */
public class Main_정올_1828_냉장고_135ms {
	
	static class Chemical {
		/** x <= 보관 가능 온도 <= y */
		int x;
		int y;
		
		/** 생성자 */
		public Chemical(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		
		// 화학 물질의 수 1 <= N <= 100
		int N = Integer.parseInt(br.readLine());
		
		// 화학 물질을 담을, 우선순위 큐
		PriorityQueue<Chemical> chemicals = new PriorityQueue<>(N, // 초기 사이즈 
				(c1, c2) -> (c1.y!=c2.y)? c1.y-c2.y: c1.x-c2.x);   // 최대 온도 우선 정렬, 같을 경우 최소 온도 기준
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()); // 가능한 최소 온도 x
			int y = Integer.parseInt(st.nextToken()); // 가능한 최대 온도 y
			
			chemicals.offer(new Chemical(x, y));
		}
		
		// 최대 온도가 가장 낮은 화학 물질, 첫 번째 화학 물질
		Chemical c = chemicals.poll();
		// 첫 번째 냉장고의 온도
		int ref = c.y;
		// 필요한 냉장고의 개수
		int cnt = 1;
		
		while(!chemicals.isEmpty()) {
			c = chemicals.poll();
			
			// 현재 화학 물질의 최소 온도가, 냉장고 온도보다 커진다면
			if (c.x > ref) {
				ref = c.y;
				cnt++;
			}
			
		} // end of while chemicals
		
		// 출력 처리
		System.out.println(cnt);
		
	} // end of main
	
} // end of class
