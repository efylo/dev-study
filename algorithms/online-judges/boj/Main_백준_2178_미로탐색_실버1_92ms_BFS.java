import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_2178_미로탐색_실버1_92ms_BFS
 * 
 * BFS
 *  - 큐에 다음 원소를 넣을 때, 선제적으로 방문 처리를 해주어도 무방하다. 
 *  - 선제적 방문 처리를 해주지 않을 경우, 동일한 값이 여러 번 들어갈 수 있다.
 *  - 큐에서 항상 같은 레벨의 좌표들을 처리하기 때문에 가능하다.
 *   
 *  예) 
 *  - {{1, 1}
 *  - ,{1, 1}} 
 *  - 여기서 (0, 0)에서 (1, 1)로 가는 두 가지 경우가 모두 큐에 입력된다.
 */
public class Main_백준_2178_미로탐색_실버1_92ms_BFS {
	
	private static int N;
	private static int M;
	
	private static boolean[][] maze;
	
	private static Queue<Integer> rQueue = new ArrayDeque<Integer>();
	private static Queue<Integer> cQueue = new ArrayDeque<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new boolean[N][M];
		
		for (int r = 0; r < maze.length; r++) {
			String str = br.readLine();
			for (int c = 0; c < maze[0].length; c++) {
				if (str.charAt(c) == '1') maze[r][c] = true;
			}
			
		}
		
		rQueue.offer(0);
		cQueue.offer(0);
		maze[0][0] = false;
		
		int level = 0;
		boolean hasReached = false;
		
		while(!rQueue.isEmpty()) {
			int breadth = rQueue.size();
			
			level++;
			
			// 현재 높이 전부 탐색
			while(breadth-- > 0) {				
				int r = rQueue.poll();
				int c = cQueue.poll();
								
				// 목표 지점 도착
				if (r == N-1 && c == M-1) {
					hasReached = true;
					break;
				}
				
				// 다음 레벨 enQueue
				if (c+1 < M && maze[r][c+1]) { // →
					rQueue.offer(r);
					cQueue.offer(c+1);
					maze[r][c+1] = false;
				}
				if (r+1 < N && maze[r+1][c]) { // ↓
					rQueue.offer(r+1);
					cQueue.offer(c);
					maze[r+1][c] = false;
				}
				if (c-1 >=0 && maze[r][c-1]) { // ←
					rQueue.offer(r);
					cQueue.offer(c-1);
					maze[r][c-1] = false;
				}
				if (r-1 >=0 && maze[r-1][c]) { // ↑
					rQueue.offer(r-1);
					cQueue.offer(c);
					maze[r-1][c] = false;
				}
			}
			
			// 탐색 완료
			if (hasReached) {
				System.out.println(level);
				break;
			}
		} 
		
	} // end of main
} // end of class
