import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_16236_아기상어_골드3_252ms
 */
public class Main_백준_16236_아기상어_골드3_252ms {
	
	static int N;
	
	static class BabyShark {
		int r, c;  // 아기상어의 위치
		int level; // 아기상어의 레벨
		int exp;   // 아기상어의 경험치
		int[] fishes;
		int[][] map;
		boolean[][] visited;
		
		public BabyShark(int r, int c, int[] fishes, int[][] map, boolean[][] visited) {
			this.r = r; this.c = c; this.fishes = fishes; this.map = map; this.visited = visited;
			this.level = 2; this.exp = 0;
		} // end of Constuctor BabyShark
		
		public void eat(int r, int c) {
			map[this.r][this.c] = 0; 
			fishes[map[r][c]]--;
			map[r][c] = 9;
			this.r = r;
			this.c = c;
			if(++exp == level) {
				level++;
				exp = 0;
			}
		} // end of eat
		
		public int bfs() {
			// 먹을 수 있는 fish가 있는지
			boolean canEat = false;
			int maxEat = Math.min(this.level, 7);
			for (int i = 1; i < maxEat; i++) {
				if (fishes[i] > 0) {
					canEat = true;
					break;
				}
			}
			if (!canEat) return -1;
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
			
			
			int time = 0;
			boolean hasAte = false;
			PriorityQueue<int[]> pqueue = new PriorityQueue<int[]>(
					(i1, i2)->(i1[0] != i2[0])? i1[0]-i2[0]: i1[1]-i2[1]); // r값 기준 내림차순으로 정렬 - c값 기준 내림차순 정렬
			Queue<int[]> tempq = new LinkedList<int[]>(); // 같은 레벨에 있는 좌표들을 임시로 저장하기 위한 큐
			// 큐의 초깃값
			visited[r][c] = true;
			if (r-1>=0 && !visited[r-1][c] && map[r-1][c] <= this.level) { // 상
				visited[r-1][c] = true;
				pqueue.offer(new int[] {r-1, c});
			}
			if (c-1>=0 && !visited[r][c-1] && map[r][c-1] <= this.level) { // 좌
				visited[r][c-1] = true;
				pqueue.offer(new int[] {r, c-1});
			}
			if (c+1< N && !visited[r][c+1] && map[r][c+1] <= this.level) { // 우
				visited[r][c+1] = true;
				pqueue.offer(new int[] {r, c+1});
			}
			if (r+1< N && !visited[r+1][c] && map[r+1][c] <= this.level) { // 하
				visited[r+1][c] = true;
				pqueue.offer(new int[] {r+1, c});
			}
			
			// bfs
outer:		while(!pqueue.isEmpty()) {
				time++;
				
				while(!pqueue.isEmpty()) {
					int[] rc = pqueue.poll();
					int nr = rc[0];
					int nc = rc[1];
					if (0 < map[nr][nc] && map[nr][nc] < this.level) {
						eat(nr, nc);
						hasAte = true;
						break outer;
					}
					if (nr-1>=0 && !visited[nr-1][nc] && map[nr-1][nc] <= this.level) { // 상
						visited[nr-1][nc] = true;
						tempq.offer(new int[] {nr-1, nc});
					}
					if (nc-1>=0 && !visited[nr][nc-1] && map[nr][nc-1] <= this.level) { // 좌
						visited[nr][nc-1] = true;
						tempq.offer(new int[] {nr, nc-1});
					}
					if (nc+1< N && !visited[nr][nc+1] && map[nr][nc+1] <= this.level) { // 우
						visited[nr][nc+1] = true;
						tempq.offer(new int[] {nr, nc+1});
					}
					if (nr+1< N && !visited[nr+1][nc] && map[nr+1][nc] <= this.level) { // 하
						visited[nr+1][nc] = true;
						tempq.offer(new int[] {nr+1, nc});
					}
				} // end of while pqueue
				
				while(!tempq.isEmpty()) {
					pqueue.offer(tempq.poll());
				}
			} // end of while outer pqueue
			
			if (!hasAte) return -1;
			return time;
		} // end of bfs
	} // end of class BabyShark
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sr = 0, sc = 0;
		N = Integer.parseInt(br.readLine());
		int[] fishes = new int[7];
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 9) {
					sr = i;
					sc = j;
				} 
				else {
					fishes[n]++;
				}
			} // end of for j
		} // end of for i
		
		BabyShark shark = new BabyShark(sr, sc, fishes, map, visited);
		
		int time = 0;
		while(true) {
			int t = shark.bfs();
			if (t == -1) break;
			time += t;
		} // end of while
		System.out.println(time);
	} // end of main
	
} // end of class
