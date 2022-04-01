import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_10026_적록색약_골드5_88ms
 * 
 * 2차원 배열의 서로소 집합(disjoint set)
 *  - 적록색약 X: 인접한 R, G, B끼리 union
 *  - 적록색맹 O: 인접한 R과 G를 union
 */
public class Main_백준_10026_적록색약_골드5_88ms {
	
	public static int[][][] pMap;
	public static int N;
	
	public static void makeSet() {
		pMap = new int[N][N][2];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				pMap[r][c][0] = r;
				pMap[r][c][1] = c;				
			}
		}
	}
	
	public static int[] findSet(int r, int c) {
		if (pMap[r][c][0] == r && pMap[r][c][1] == c) return pMap[r][c];
		// path compression
		return pMap[r][c] = findSet(pMap[r][c][0], pMap[r][c][1]);
	}
	
	public static boolean union(int r1, int c1, int r2, int c2) {
		int[] root1 = findSet(r1, c1);
		int[] root2 = findSet(r2, c2);
		if (root1 == root2) return false;
		
		pMap[root2[0]][root2[1]] = root1;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // N <= 100
		int cnt = N*N;
		char[][] rgbMap = new char[N][];
		for (int i = 0; i < N; i++) {
			rgbMap[i] = br.readLine().toCharArray();
		}
		
		makeSet(); // NxNx2 각각 다른 집합으로 초기화
		for (int r = 0; r < N; r++) { // R, G, B 집합 union
			for (int c = 0; c < N; c++) {
				char rgb = rgbMap[r][c];
				if (r+1 < N && rgbMap[r+1][c] == rgb && union(r, c, r+1, c)) cnt--; // r,c 좌표랑 r+1, c 좌표
				if (c+1 < N && rgbMap[r][c+1] == rgb && union(r, c, r, c+1)) cnt--;
			}
		}
		sb.append(cnt).append(" ");
		
		for (int r = 0; r < N; r++) { // R과 G집합 union
			for (int c = 0; c < N; c++) {
				char rgb = rgbMap[r][c];
				if (rgb == 'B') continue;
				else if (rgb == 'R') {
					if (r+1 < N && rgbMap[r+1][c] == 'G' && union(r, c, r+1, c)) cnt--;
					if (c+1 < N && rgbMap[r][c+1] == 'G' && union(r, c, r, c+1)) cnt--;
				}
				else { // 현재 좌표가 'G'
					if (r+1 < N && rgbMap[r+1][c] == 'R' && union(r, c, r+1, c)) cnt--;
					if (c+1 < N && rgbMap[r][c+1] == 'R' && union(r, c, r, c+1)) cnt--;
				}
			}
		}
		sb.append(cnt).append("\n");
		
		System.out.print(sb.toString());
		
	} // end of main
	
} // end of class
