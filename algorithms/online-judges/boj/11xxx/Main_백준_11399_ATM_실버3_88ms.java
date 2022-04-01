import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main_백준_11399_ATM_실버3_88ms
 */
public class Main_백준_11399_ATM_실버3_88ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] times = new int[N];
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += times[i] * (N-i);
		}
		
		System.out.println(sum);
	} // end of main
} // end of class
