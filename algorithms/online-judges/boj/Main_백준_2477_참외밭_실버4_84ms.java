import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_2477_참외밭_실버4_84ms
 * 
 */
public class Main_백준_2477_참외밭_실버4_84ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		int[] e = new int[6];
		int max0 = 0;
		int max1 = 0;
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			e[i] = Integer.parseInt(st.nextToken());
			if (i%2 == 0 && e[i] > max0) max0 = e[i];
			if (i%2 != 0 && e[i] > max1) max1 = e[i];
		}
		
		int index = 0;
		for (int i = 0; i < 6; i++) {
			if (e[i]*e[(i+1)%6] == max0*max1) {
				index = i;
				break;
			}
		}
		
		System.out.println(K * (max0*max1 - e[(index+3)%6]*e[(index+4)%6]));
		
	} // end of main
	
} // end of class
