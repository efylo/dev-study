import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2999_비밀이메일_브론즈1_72ms
 */
public class Main_백준_2999_비밀이메일_브론즈1_72ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] message = br.readLine().toCharArray();
		
		int N = message.length;
		
		int R = (int) Math.floor(Math.sqrt(N));
		while(N%R != 0) R--;
		int C = N/R;
		
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(message[c*R+r]);
			}			
		}
		sb.append("\n");
		
		System.out.print(sb.toString());
		
	}
}
