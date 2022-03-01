import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_15681_트리와쿼리_골드5_메모리초과_클래스
 */
public class Main_백준_15681_트리와쿼리_골드5_메모리초과_클래스 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// 루트 번호 R을 통해 트리 객체 생성
		Tree tree = new Tree(R);
		
		// 간선의 정보를 저장할 큐
		Queue<int[]> queue = new ArrayDeque<int[]>(N);
		// 노드가 트리에 존재하는지
		boolean[] isValid = new boolean[N+1];
		isValid[R] = true;
		
		// 첫 입력 처리
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			// 두 정점 v1, v2
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			// v1이 트리에 존재한다면
			if (isValid[v1]) {
				// v1을 값으로 하는 노드 - 그 노드에 추가 - v2가 트리에 존재함
				Node temp = tree.search(v1);
				temp.add(v2);
				isValid[v2] = true;
				continue;
			}
			// v2가 트리에 존재한다면
			if (isValid[v2]) {
				Node temp = tree.search(v2);
				temp.add(v1);
				isValid[v1] = true;
				continue;
			}
			
			// 둘 다 트리에 존재하지 않는다면 - 큐에 넣는다
			queue.offer(new int[] {v1, v2});
		}
		
		while(!queue.isEmpty()) {
			// 큐에서 꺼낸다
			int[] tempv = queue.poll();
			
			// v1이 트리에 존재한다면
			if (isValid[tempv[0]]) {
				// v1을 값으로 하는 노드 - 그 노드에 추가 - v2가 트리에 존재함
				Node temp = tree.search(tempv[0]);
				temp.add(tempv[1]);
				isValid[tempv[1]] = true;
				continue;
			}
			// v2가 트리에 존재한다면
			if (isValid[tempv[1]]) {
				Node temp = tree.search(tempv[1]);
				temp.add(tempv[0]);
				isValid[tempv[0]] = true;
				continue;
			}
			
			// v1, v2가 트리에 없다면
			queue.offer(tempv);
		}
		
		// 트리 전체 사이즈 업데이트
		tree.root.getSize();
		
		// 쿼리 처리
		for (int i = 0; i < Q; i++) {
			int query = Integer.parseInt(br.readLine());
			// 노드 구하기
			Node node = tree.search(query);
			
			sb.append(node.size).append("\n");
		}
		
		System.out.print(sb.toString());
		
	} // end of main
} // end of class Main


class Node {
	
	/** 노드의 값 */
	int val;
	
	/** 노드의 크기 */
	int size = -1;
	
	/** 노드의 자식 노드들 */
	List<Node> childs = new LinkedList<Node>();
	
	/** 노드의 생성자 */
	public Node(int val) {
		this.val = val;
	}
	
	/** 자식 노드에 val 값을 갖는 노드를 추가 */
	public void add(int val) {
		childs.add(new Node(val));
	}
	
	/** 노드의 사이즈를 구하는 메서드 - DFS 활용 */
	public int getSize() {
		if (this.size != -1) return this.size;
		this.size = 1;
		for (Node node : childs) {
			this.size += node.getSize();
		}
		return this.size;
	}
	
} // end of class Node


class Tree {
	
	/** 트리의 루트 노드 */
	Node root;
	
	/** 트리의 생성자 */
	public Tree(int val) {
		super();
		this.root = new Node(val);
	}

	/** 값이 val과 동일한 Node를 반환한다. - BFS 구현 */
	public Node search(int val) {
		Queue<Node> queue = new ArrayDeque<Node>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			// 큐에서 원소 꺼내기
			Node temp = queue.poll();
			
			// 값이 동일한 원소를 찾았다면, 바로 반환
			if (temp.val == val) return temp;
			
			// 아니라면, temp의 자식들을 큐에 넣는다. 
			for (Node node : temp.childs) {
				queue.offer(node);
			}
		}
		
		// 찾지 못한 경우
		return null;
	}
} // end of class Tree