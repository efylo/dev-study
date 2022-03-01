import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_7562_나이트의이동_실버2_592ms
 */
public class Main_백준_7562_나이트의이동_실버2_592ms {
	
	/** 체스보드의 상태를 저장할 상수 X, O, GOAL */
	private final static int X = 0;
	private final static int O = 1;
	private final static int GOAL = 2;
	
	/** 체스판 */
	private static int[][] chessBoard;
	/** 나이트의 이동 경로 */
	private final static int[] knightR = {2, 2,-2,-2, 1, 1,-1,-1};
	private final static int[] knightC = {1,-1, 1,-1, 2,-2, 2,-2};	
	/** 행과 열 값에 대한 큐 */
	private static Queue<Integer> rQueue;
	private static Queue<Integer> cQueue;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			// 전역 변수 초기화
			chessBoard = new int[N][N];
			rQueue = new ArrayDeque<Integer>();
			cQueue = new ArrayDeque<Integer>();
			
			st = new StringTokenizer(br.readLine(), " ");
			int r0 = Integer.parseInt(st.nextToken());
			int c0 = Integer.parseInt(st.nextToken());
			rQueue.offer(r0);
			cQueue.offer(c0);
			
			st = new StringTokenizer(br.readLine(), " ");
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			chessBoard[r1][c1] = GOAL;
			
			int r;
			int c;
			int level = 0;
			boolean hasFound = false;
			
			// BFS
			while(!rQueue.isEmpty()) {
				// 현재 레벨의 크기
				int size = rQueue.size();
				
				// 같은 레벨의 좌표를 deQueue
				while(size-- > 0) {
					r = rQueue.poll();
					c = cQueue.poll();
					// 이미 접근했었던 좌표 - 다음으로,,
					if(chessBoard[r][c] == O) continue;
					// 처음 접근하는 좌표 - 업데이트
					if(chessBoard[r][c] == X) chessBoard[r][c] = O;
					
					// 현재 좌표가 GOAL인지 확인
					if(chessBoard[r][c] == GOAL) {
						hasFound = true;
						break;
					}
					// 현재 좌표에서 갈 수 있는 좌표 中 가능한 좌표 enQueue
					for (int k = 0; k < 8; k++) {
						int nextR = r + knightR[k];
						int nextC = c + knightC[k];
						
						// 가능하다 = 좌표가 접근 가능하며, 접근했었던 좌표가 아니다
						// BFS - 큐에 넣을 때 방문 처리
						if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < N
								&& chessBoard[nextR][nextC] != O) {
							rQueue.offer(nextR);
							cQueue.offer(nextC);
						}
					} // end of for k
					
				} // end of while size
				
				// 만약 찾았다면, break
				if (hasFound) break;
				
				// 찾지 못했다면, 다음레벨
				level++;
			}
			
			// 출력 처리
			sb.append(level).append("\n");
			
		} // end of for testCase
		
		System.out.print(sb.toString());
		
	} // end of main
	
} // end of class
