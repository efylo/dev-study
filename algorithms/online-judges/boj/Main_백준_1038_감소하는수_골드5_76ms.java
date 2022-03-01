import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_1038_감소하는수_골드5_76ms
 */
public class Main_백준_1038_감소하는수_골드5_76ms {
	
	public static int cnt;
	public static char[] crr; // 2 => 1, 
	public static char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		crr = new char[10];
		char ten = '0'+10; 
		cnt = 0;
		for (int digits = 1; digits <= 10; digits++) { // 1자리 ~ 10자리 수 탐방
			if (backTrack(digits-1, ten, N)) {
				for (int i = digits-1; i >= 0; i--) {
					sb.append(crr[i]);
				}
				sb.append("\n");
				break;
			}
		}
		// 1023번째 숫자의 경우, -1이 append되어야 하는데 되지 않음..
		if (cnt <= N) sb.append("-1\n");
		
		System.out.print(sb.toString());
		
	} // end of main
	
	public static boolean backTrack(int pos, char prev, int N) {
		if (pos < 0) {
			if (cnt++ == N) return true;
			return false;
		}
		
		// pos에 가능한 숫자 시도
		for (char c = num[pos]; c < prev; c++) {
			crr[pos] = c;
			if (backTrack(pos-1, c, N)) return true;
		}
		
		return false;	
	}
	
} // end of class
