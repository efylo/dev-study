import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_정올_1681_해밀턴순환회로_IM_145ms
 * 
 *  - 아이디어
 *    : 외판원 순회 문제(TSP)
 *    : 정점 0에서 시작하여, 다시 0으로 돌아오는 경로의 최소 비용
 *      => 결국 전체 경우의 수를 순회해야 함
 *    : 백트래킹
 *      => 현재까지의 최소 비용 minPrice보다 현재까지의 비용 price가 커질 경우 호출X
 *  
 *  - 실패
 *    : 백트래킹 적용 X
 *    : 마지막 장소에서 정점 0으로 가는 길 체크 X
 * 
 */
public class Main_정올_1681_해밀턴순환회로_IM_145ms {
	private static int N;
	private static int minPrice;
	private static int[][] adjMatrix;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // N <= 13
		minPrice = Integer.MAX_VALUE;
		adjMatrix = new int[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visited = new boolean[N];
		int[] places = new int[N];
		places[0] = 0;
		go(1, 0, places, visited);
		System.out.println(minPrice);
		
	} // end of main
	
	public static void go(int cnt, int price, int[] places, boolean[] visited) {
		if (cnt == N) {
			int p = adjMatrix[places[N-1]][0];
			if (p != 0) {
				price += p;
				if (price < minPrice) {
					minPrice = price;
				}
			}
			return;
		}
		
		int prev = places[cnt-1];
		for (int i = 1; i < N; i++) {
			if (!visited[i]) {
				int p = adjMatrix[prev][i];
				if (p != 0 && price + p < minPrice) {
					visited[i] = true;
					places[cnt] = i;
					go(cnt+1, price+p, places, visited);
					visited[i] = false;
				}
			}
		}
	}
	
} // end of class
