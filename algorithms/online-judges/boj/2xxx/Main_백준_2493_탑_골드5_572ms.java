import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_2493_탑_골드5_572ms
 */
public class Main_백준_2493_탑_골드5_572ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 500,000
		int[] towers = new int[N];
		int[] received = new int[N+1];
		int maxH = 0; // 현재 루프의 i까지 최대 높이를 보관
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken()); // 1 <= h <= 100,000,000
			towers[i] = h;
			if (maxH <= h) { // 현재 h가 최대, 탐색 필요 x
				maxH = h;
			} else { // i 왼쪽의 index들에 대해서 탐색
				int left = i;
				while(left > 0) {
					if (towers[left-1] > h) {
						received[i+1] = left;
						break;
					} else {
						left = received[left];
					}
				}
			} 
		} // end of for i
		
		for (int i = 1; i <= N; i++) {
			sb.append(received[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	} // end of main
} // end of class
