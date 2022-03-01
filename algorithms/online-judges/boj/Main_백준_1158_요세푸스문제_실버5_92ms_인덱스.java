import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Main_백준_1158_요세푸스문제_실버5_92ms_인덱스
 */
public class Main_백준_1158_요세푸스문제_실버5_92ms_인덱스 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 배열 리스트가 연결 리스트보다 빠르다
		List<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			al.add(i);
		}
		// 리스트 인덱스 초기화 
		int i = 0;
		int di = K - 1; // 현재 인덱스 제거 -> K번 오른쪽 이동 == K-1번 이동
		int size = N;
		
		sb.append("<");
		while (!al.isEmpty()) {
			// 인덱스 업데이트
			i += di;
			if (i >= size) {
				i %= size;
			}
			
			// 해당 인덱스 제거
			sb.append(al.remove(i)).append(", ");
			size--;
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
