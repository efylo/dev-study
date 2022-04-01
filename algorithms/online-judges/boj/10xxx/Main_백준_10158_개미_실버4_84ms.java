import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_10158_개미_실버4_84ms
 */
public class Main_백준_10158_개미_실버4_84ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine(), " ");
		int w = Integer.parseInt(st.nextToken()); // 2 <= w, h <= 40,000
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken()); // 0 < p < w
		int q = Integer.parseInt(st.nextToken()); // 0 < q < h
		
		int t = Integer.parseInt(br.readLine()); // 1 <= t <= 2E8
		
		p += t;
		q += t;
		
		p %= 2*w;
		q %= 2*h;
		
		if (p > w) p = 2*w - p;
		if (q > h) q = 2*h - q;
		
		System.out.println(p+" "+q);
		
	} // end of main
} // end of class
