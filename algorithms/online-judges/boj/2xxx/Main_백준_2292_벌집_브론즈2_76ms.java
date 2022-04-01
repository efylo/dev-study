import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2292_벌집_브론즈2_76ms
 */
public class Main_백준_2292_벌집_브론즈2_76ms { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
//		int rooms = (int) Math.ceil((3 + Math.sqrt(12*N-3)) / 6);
		
		int max = 1;
		int dx = 0;
		
		while(N > max) {
			max += ++dx*6;
		}
		
		System.out.println(dx+1);
		
	} // end of main
} // end of class
