import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Main_백준_2108_통계학_실버4_400ms
 */
public class Main_백준_2108_통계학_실버4_400ms {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1 <= N <= 50만, N은 홀수
		int sum = 0; // 최대: 4000 x 500000 = 20억, int 범위 내 표현 가능
		HashMap<Integer, Integer> count = new HashMap<>(8001);
		int min = 4000;  // 범위를 위한 min, max
		int max = -4000;
		int pre;
		for (int i = 0; i < N; i++) { // 입력 처리
			pre = Integer.parseInt(br.readLine());
			sum += pre;
			if (pre < min) min = pre;
			if (pre > max) max = pre;
			if (count.containsKey(pre)) {
				count.put(pre, count.get(pre)+1);
			} else {
				count.put(pre, 1);
			}
		} // end of for i
		int mid = min; // 중앙값 
		List<Integer> values = new LinkedList<>();
		int freq = 0;
		int avg = (int) Math.round((double) sum / N);
		// 중앙값 및 최빈값 산출
		int no = 0; // 빈도수
		boolean flag = false; // 중앙값 산출 여부 플래그
		for (int num = -4000; num <= 4000; num++) {
			if (count.containsKey(num)) { // key hit
				pre = count.get(num);
				no += pre;
				if (!flag && no > N / 2) {
					flag = true;
					mid = num;
				}
				if (freq < pre) {
					freq = pre;
					values.clear();
					values.add(num);
				} else if (freq == pre) {
					values.add(num);
				}
			}
		} // end of for num
		StringBuilder sb = new StringBuilder();
		sb.append(avg).append("\n");
		sb.append(mid).append("\n");
		int value = values.size() == 1 ? values.get(0): values.get(1);
		sb.append(value).append("\n");
		sb.append(max - min).append("\n");
		System.out.println(sb.toString());
	} // end of main
} // end of class
