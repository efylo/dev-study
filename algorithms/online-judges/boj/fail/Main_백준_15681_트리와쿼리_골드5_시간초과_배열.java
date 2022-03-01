import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_15681_트리와쿼리_골드5_시간초과_배열
 */
public class Main_백준_15681_트리와쿼리_골드5_시간초과_배열 {
	
	private static ArrayList<Integer>[] tree;
	private static boolean[] valid;
	private static int[] size;
	
	/** tree에 edge를 추가, 만약 추가 실패 시 false 반환 */ 
	public static boolean add(int[] edge) {
		if (valid[edge[0]]) {
			tree[edge[0]].add(edge[1]);
			valid[edge[1]] = true;
			return true;
		}
		if (valid[edge[1]]) {
			tree[edge[1]].add(edge[0]);
			valid[edge[0]] = true;
			return true;
		}
		return false;
	}
	
	/** 노드 v의 사이즈를 구한다. - DFS */
	public static int update(int v) {
		int vSize = 1;
		
		for (Integer v0 : tree[v]) {
			vSize += update(v0);
		}
		
		size[v] = vSize;
		
		return vSize;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[N+1];
		size = new int[N+1];
		
		// 트리 초기화
		for (int i = 1; i < tree.length; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		// 큐에 넣어서 트리 빌드
		Queue<int[]> queue = new ArrayDeque<int[]>(N-1);
		
		// 현재까지 트리에 존재하는 노드들
		valid = new boolean[N+1];
		valid[R] = true;
		
		// N-1개의 간선 입력 처리
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// 간선의 두 정점 v1, v2
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			int[] edge = {v1, v2};
			
			if (!add(edge)) { // tree에 edge 추가 실패 시, 큐에 추가
				queue.add(edge);
			}
		}
		
		// 잔여 간선 처리
		while(!queue.isEmpty()) {
			int[] edge = queue.poll();
			
			if(!add(edge)) {
				queue.add(edge);
			}
		}
		
		// 각 노드의 사이즈 업데이트
		update(R);
		
		// 쿼리 처리
		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			sb.append(size[query]).append("\n");
		}
		
		System.out.print(sb.toString());
		
	} // end of main
} // end of class Main