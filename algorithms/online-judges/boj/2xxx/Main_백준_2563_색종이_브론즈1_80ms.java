import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_2563_색종이_브1_80ms
 */
public class Main_백준_2563_색종이_브론즈1_80ms {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] map = new boolean[100][100];
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) { // 시간복잡도: 100*N
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int dy = 0; dy < 10; dy++) {
				for (int dx = 0; dx < 10; dx++) {
					map[y+dy][x+dx] = true;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < map.length; i++) { // 시간복잡도: 10000
			for (int j = 0; j < map.length; j++) {
				if (map[i][j]) sum++;
			}
		}
		System.out.println(sum);
	}
}
