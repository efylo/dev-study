import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_1592_영식이와친구들_브론즈2_80ms
 */
public class Main_백준_1592_영식이와친구들_브론즈2_80ms {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 친구들 수, N <= 50
		int M = Integer.parseInt(st.nextToken()); // 최대 공 받은 횟수
		int L = Integer.parseInt(st.nextToken()); // 던지는 기준
		
		int[] received = new int[N]; // 공을 받은 횟수
		//    1, 2, 3, ..., N
		// 0, 1, 2, 3, ..
		int cnt = 0;				 // 전체 공을 던진 횟수
		int p = 1; 					 // 공을 받은 사람
		
		while(true) {
			// 공을 받는다. 
			received[p]++;
			
			// 공을 M번 받으면 게임은 끝난다. 
			if (received[p] == M) break;
			
			cnt++;
			// 현재 공을 홀수 번 받았다면
			if (received[p] % 2 != 0) {
				p += L;
				if (p >= N) p -= N;
			}
			else {
				p -= L;
				if (p < 0) p += N;
			}
		}
		
		System.out.println(cnt);
		
	} // end of main
	
} // end of class
