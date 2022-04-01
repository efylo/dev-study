
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Main_백준_7568_덩치_실버5_132ms
 */
public class Main_백준_7568_덩치_실버5_132ms {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = sc.nextInt();
		
		int[] weights = new int[N];
		int[] heights = new int[N];
		int[] ranks = new int[N];
		
		// 몸무게, 키 입력받기
		for (int i = 0; i < N; i++) {
			weights[i] = sc.nextInt();
			heights[i] = sc.nextInt();
		}
		// 더 큰 사람의 수 + 1 = rank
		for (int i = 0; i < N; i++) {
			int tempW = weights[i];
			int tempH = heights[i];
			for (int j = 0; j < N; j++) {
				if (i == j) continue;
				if (weights[j] > tempW && heights[j] > tempH) {
					ranks[i]++;
				}
			}
			ranks[i]++;
		}
		for (int i = 0; i < N; i++) {
			bw.write(ranks[i]+" ");
		}
		bw.flush();
		bw.close();
		sc.close();
	}
}
