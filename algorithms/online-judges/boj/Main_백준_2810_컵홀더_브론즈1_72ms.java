import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2810_컵홀더_브론즈1_72ms
 */
public class Main_백준_2810_컵홀더_브론즈1_72ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String seats = br.readLine();
		
		// result: 컵홀더의 개수
		int idx = 0, result = 0;
		while (idx < N) {
			if (seats.charAt(idx) == 'S') {
				idx++;
				result++;
			} else {
				idx += 2;
				result++;
			}
		} // end of idx
		result++;
		
		// 컵홀더의 개수와, 사람의 명수 중 작은 것을 출력
		System.out.println(Math.min(result, N));
		
	} // end of main
} // end of class
