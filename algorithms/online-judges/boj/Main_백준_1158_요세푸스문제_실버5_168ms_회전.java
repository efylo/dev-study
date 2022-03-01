import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Main_백준_1158_요세푸스문제_실버5_168ms_회전
 */
public class Main_백준_1158_요세푸스문제_실버5_168ms_회전 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); 
		
		// 큐 초기화
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <=  N; i++) {
			queue.offer(i);
		}
		
		sb.append("<");
		// 큐에 원소가 존재할 동안
		while(!queue.isEmpty()) {
			// K-1만큼 회전, 모듈러 연산 = 회전 최적화
			int rotate = (K-1) % queue.size();
			for (int i = 0; i < rotate; i++) {
				// 연결 리스트로 구현 시, GC가 제대로 일어나지 않는다. 
				queue.offer(queue.poll());
			}
			// 해당 번호 제거, 출력
			sb.append(queue.poll()).append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append(">\n");
		System.out.print(sb.toString());
		
	} // end of main
	
} // end of class
