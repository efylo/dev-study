import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Main_백준_1753_최단경로_골드5_1844ms
 * 
 *  - 아이디어
 *    : 다익스트라 - start로부터 최단 경로 탐색
 *    : bitmasking - 1844ms 
 *  
 *  - 자료구조
 *    : LinkedList - 2140ms
 *    : ArrayList  - 1984ms
 *    : PriorityQueue - 856ms
 *    : 인접 리스트 직접 구현 - 668ms
 *  
 *  - 실패
 *    : 인접 행렬 - 메모리 초과
 *    : bitmasking - 우선순위 (가감 연산자 > 비트 연산자)
 */
public class Main_백준_1753_최단경로_골드5_668ms {
	
	static class Edge implements Comparable<Edge>{
		int to;
		int dist;
		
		public Edge(int to, int dist) {
			super();
			this.to = to;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	static class Node {
		int val;
		int cost;
		Node link;
		
		public Node(int val, int cost) {
			super();
			this.val = val;
			this.cost = cost;
			this.link = null;
		}
		
		public void add(int to, int cost) {
			Node node = new Node(to, cost);
			node.link = this.link;
			this.link = node;
		}
		
		public Node next() {
			return this.link;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken()); // V <= 20,000
		int E = Integer.parseInt(st.nextToken()); // E <= 300,000
		int start = Integer.parseInt(br.readLine()); // 시작 정점
		
		// 인접 리스트 초기화
		Node[] adjList = new Node[V+1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new Node(i, 0);
		}
		
		// 간선 입력 처리
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to   = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList[from].add(to, cost);
		}
		
		// 다익스트라를 위한 자료구조
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		pQueue.offer(new Edge(start, 0));
		Edge edge = null;
		while(!pQueue.isEmpty()) {
			// 현재 start 노드와의 최소 거리를 갖는 간선 poll
			edge = pQueue.poll();
			int curr = edge.to;
			
			if (visited[curr]) continue;
			
			visited[curr] = true;
			distance[curr] = edge.dist;
			
			Node node = adjList[curr];
			while((node = node.next()) != null) {
				int next = node.val;
				if (visited[next]) continue;
				
				if (node.cost + distance[curr] < distance[next]) {
					pQueue.offer(new Edge(next, node.cost + distance[curr]));
				}
			}
		} // end of while pQueue
		
		for (int i = 1; i <= V; i++) {
			sb.append(distance[i]==Integer.MAX_VALUE? "INF": distance[i]).append("\n");
		}
		
		System.out.print(sb.toString());
		
	} // end of main
	
} // end of class
