import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_2527_직사각형_실버1_80ms
 */
public class Main_백준_2527_직사각형_실버1_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int x1 = 0, y1 = 0, p1 = 0, q1 = 0;
		int x2 = 0, y2 = 0, p2 = 0, q2 = 0;
		
		for (int testCase = 0; testCase < 4; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 첫번째 사각형 입력
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			p1 = Integer.parseInt(st.nextToken());
			q1 = Integer.parseInt(st.nextToken());
			// 두번째 사각형 입력
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			p2 = Integer.parseInt(st.nextToken());
			q2 = Integer.parseInt(st.nextToken());
			
			// 공통 부분이 없는 경우
			if (x2 > p1 || x1 > p2 || y2 > q1 || y1 > q2) {
				sb.append("d").append("\n");
			}
			// 공통 부분이  점인 경우
			else if (x2 == p1 && y2 == q1) {
				sb.append("c").append("\n");
			}
			else if (x2 == p1 && q2 == y1) {
				sb.append("c").append("\n");
			}
			else if (x1 == p2 && y1 == q2) {
				sb.append("c").append("\n");
			}
			else if (x1 == p2 && y2 == q1) {
				sb.append("c").append("\n");
			}
			// 공통 부분이 선분인 경우
			else if (x1 == p2) {
				sb.append("b").append("\n");
			}
			else if (x2 == p1) {
				sb.append("b").append("\n");
			}
			else if (y1 == q2) {
				sb.append("b").append("\n");
			}
			else if (y2 == q1) {
				sb.append("b").append("\n");
			}
			// 나머지
			else {
				sb.append("a").append("\n");
			}
		} // end of for testCase
		
		System.out.print(sb.toString());
		
	} // end of main
} // end of class
