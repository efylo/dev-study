import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_1244_스위치켜고끄기_실버3_76ms
 * 
 *  - 스위치 켜고 끄기
 *    1) true  ^ true = false
 *    2) false ^ true = true
 */
public class Main_백준_1244_스위치켜고끄기_실버3_76ms {
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 스위치 개수 N <= 100
		boolean[] sw = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 스위치가 켜져 있으면 true, 아니면 false
		for (int i = 1; i <= N; i++) {
			if (st.nextToken().charAt(0) == '1') sw[i] = true;
		}
		
		int M = Integer.parseInt(br.readLine()); // 학생수 M <= 100
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			char std = st.nextToken().charAt(0);
			int x = Integer.parseInt(st.nextToken()); // 스위치 넘버

			if (std == '1') { // 남학생이라면
				int dx = x;
				while(x <= N) {
					sw[x] = sw[x] ^ true;
					x += dx;
				}
			}
			
			if (std == '2') { // 여학생이라면
				sw[x] = sw[x] ^ true; // 중앙 스위치
				
				int dx = 1;
				while(x-dx > 0 && x+dx <= N			// 스위치 버튼을 누를 수 있고 
						&& sw[x-dx]==sw[x+dx]) {	// 대칭이라면
					sw[x-dx] = sw[x-dx] ^ true;
					sw[x+dx] = sw[x+dx] ^ true;
					dx++;
				}
			}
		} // end of for i
		
		// 출력 처리
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 1; i < sw.length; i++) {
			if (sw[i]) 	sb.append("1 ");
			else 		sb.append("0 ");
			if (i % 20 == 0) sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	} // end of main
	
} // end of class
