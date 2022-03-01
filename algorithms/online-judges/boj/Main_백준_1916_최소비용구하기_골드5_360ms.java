import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Main_백준_1916_최소비용구하기_골드5_360ms
 * 
 *  - 아이디어
 *    : 다익스트라 연습
 *    : 인접리스트 직접 구현
 * 
 */
public class Main_백준_1916_최소비용구하기_골드5_360ms {
	
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
		
		public Node(int to, int cost) {
			super();
			this.val = to;
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 정점의 개수, N <= 1,000
		int M = Integer.parseInt(br.readLine()); // 간선의 개수, M <= 100,000
		
		// 인접 리스트 초기화
		Node[] adjList = new Node[N+1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new Node(i, 0);
		}
		
		// 간선 입력
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(st.nextToken()); // 출발 정점
			int to   = Integer.parseInt(st.nextToken()); // 도착 정점
			int cost = Integer.parseInt(st.nextToken()); // 간선 비용
			
			adjList[from].add(to, cost);
		}
		
		// 출발 및 도착 정점
		st = new StringTokenizer(br.readLine(), " ");
		int curr = Integer.parseInt(st.nextToken());
		int end  = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[curr] = 0;
		
		pQueue.offer(new Edge(curr, 0));
		
		Edge edge = null;
		while(!pQueue.isEmpty()) {
			// pQueue에 존재하는, 거리가 가장 짧은 노드 poll
			edge = pQueue.poll();
			curr = edge.to;
			
			if (visited[curr]) continue;
			
			visited[curr] = true;
			distance[curr] = edge.dist;
			
			if (curr == end) break;
			
			// 현재 노드(curr)로부터, 탐색할 수 있는 모든 정점을 탐색하며 비용 업데이트
			Node node = adjList[curr];
			while((node = node.next()) != null) {
				if (visited[node.val]) continue;
				
				if (node.cost + distance[curr] < distance[node.val]) {
					pQueue.offer(new Edge(node.val, node.cost + distance[curr]));
				}
			}
		} // end of while pQueue
		
		System.out.println(distance[end]);
		
	} // end of main
	
} // end of class
