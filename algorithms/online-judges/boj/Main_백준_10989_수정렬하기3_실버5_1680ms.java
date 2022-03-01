import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_10989_수정렬하기3_실버5_1680ms
 */
public class Main_백준_10989_수정렬하기3_실버5_1680ms {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		for (int i = 0; i < N; i++) {
			count[Integer.parseInt(br.readLine())]++;
		} // end of for
		
		for (int i = 1; i <= 10000; i++) {
			if (count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		} // end of for
		// 출력 처리
		System.out.println(sb.toString());
	} // end of main
} // end of class
