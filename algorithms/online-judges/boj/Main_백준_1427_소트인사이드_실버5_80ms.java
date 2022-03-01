import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main_백준_1427_소트인사이드_실버5_80ms
 */
public class Main_백준_1427_소트인사이드_실버5_80ms {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine(); // 큰 숫자를, String으로 처리
		int[] count = new int[10];  // 0 ~ 9의 한정된 값을, int 배열로 처리
		
		for (int i = 0; i < num.length(); i++) {
			count[num.charAt(i) - '0']++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = count.length - 1; i >= 0; i--) {
			for (int j = 0; j < count[i]; j++) {
				sb.append(i);
			}
		}
		sb.append("\n");
		System.out.print(sb.toString());
	}
}
