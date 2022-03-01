import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2851_슈퍼마리오_브론즈1_76ms
 */
public class Main_백준_2851_슈퍼마리오_브론즈1_76ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < 10; i++) {
			int mush = Integer.parseInt(br.readLine());
			if (!flag) {
				sum += mush;
				if (sum >= 100) {
					flag = true;
					int prev = sum - mush;
					if (prev != 0 && 100 - prev < sum - 100) {
						sum = prev;
					}
				}
			}
		}
		
		System.out.println(sum);
		
	} // end of main
} // end of class
