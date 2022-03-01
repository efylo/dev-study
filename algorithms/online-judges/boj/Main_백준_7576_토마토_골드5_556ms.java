import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_7576_토마토_골드5_ms
 * 
 *  - 아이디어
 *    : BFS, 시작 시에 모든 익은 토마토의 위치를 enqueue
 * 
 */
public class Main_백준_7576_토마토_골드5_556ms {
	
	static class Coord {
		int r, c;

		public Coord(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	} // end of class Coord
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] box = new int[R][C];
		Queue<Coord> queue = new LinkedList<Coord>();
		
		int xomato = 0; // 익지 않은 토마토의 개수
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < C; j++) {
				int temp = Integer.parseInt(st.nextToken()); 
				box[i][j] = temp;
				
				if (temp == 0) xomato++;
				else if (temp == 1) queue.offer(new Coord(i, j));
			} // end of for j
		} // end of for i
				
		// bfs
		int days = 0;
		Coord crd = null;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-- > 0) { // 현재 레벨만큼
				crd = queue.poll();
				
				if (crd.r >= 1 && box[crd.r-1][crd.c] == 0) {
					xomato--;
					box[crd.r-1][crd.c] = 1;
					queue.offer(new Coord(crd.r-1, crd.c));
				}
				if (crd.c >= 1 && box[crd.r][crd.c-1] == 0) {
					xomato--;
					box[crd.r][crd.c-1] = 1;
					queue.offer(new Coord(crd.r, crd.c-1));
				}				
				if (crd.r+1< R && box[crd.r+1][crd.c] == 0) {
					xomato--;
					box[crd.r+1][crd.c] = 1;
					queue.offer(new Coord(crd.r+1, crd.c));
				}
				if (crd.c+1< C && box[crd.r][crd.c+1] == 0) {
					xomato--;
					box[crd.r][crd.c+1] = 1;
					queue.offer(new Coord(crd.r, crd.c+1));
				}
			} // end of while size
			if (!queue.isEmpty()) days++;
			
		} // end of while queue
		
		if (xomato > 0) days = -1;
		System.out.println(days);
		
	} // end of main
} // end of class
