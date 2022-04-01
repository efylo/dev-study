import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_8320_직사각형을만드는방법_브론즈2_72ms
 */
public class Main_백준_8320_직사각형을만드는방법_브론즈2_72ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int maxR = (int) Math.floor(Math.sqrt(N));
		
		int cnt = 0;
		for (int r = 1; r <= maxR; r++) {
			cnt += N/r - r + 1;
		}
		
		System.out.println(cnt);
		
	} // end of main
} // end of class
