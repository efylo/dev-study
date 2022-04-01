import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_3985_롤케이크_브론즈1_88ms
 */
public class Main_백준_3985_롤케이크_브론즈1_88ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine()); // L <= 1000
		int N = Integer.parseInt(br.readLine()); // N <= 1000
		int rollCakes[] = new int[L+1]; 
		
		int expd[] = {0, 0};
		int rcvd[] = {0, 0}; 
		
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int cakes = K-P+1;
			if (cakes > expd[0]) {
				expd[0] = cakes;
				expd[1] = i;
			}
			for (int j = P; j <= K; j++) {
				if (rollCakes[j] == 0) rollCakes[j] = i;
				else cakes--;
			}
			if (cakes > rcvd[0]) {
				rcvd[0] = cakes;
				rcvd[1] = i;
			}
		}
		
		System.out.println(expd[1]+"\n"+rcvd[1]);
		
	} // end of main
} // end of class
