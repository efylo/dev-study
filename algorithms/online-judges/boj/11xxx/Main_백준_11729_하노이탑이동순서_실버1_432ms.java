
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Main_11729_하노이탑이동순서_실버1_432ms
 * 출력이 잦은 함수는 BufferedWriter로 출력하자. 
 */
public class Main_백준_11729_하노이탑이동순서_실버1_432ms {
	/** 하노이 탑 이동 순서 - 재귀 호출 */
	static void hanoi(int level, int start, int end, BufferedWriter bw) throws IOException {
		// 종료 구문
		if (level == 1) {
			bw.write(start+" "+end+"\n");
			return;
		}
		// start에 존재하는 (level-1)의 탑을 중간으로 옮김
		hanoi(level-1, start, 6-start-end, bw);
		// 마지막 판을 end로 옮김
		bw.write(start+" "+end+"\n");
		// 중간에 있는 판을 end로 옮김
		hanoi(level-1, 6-start-end, end, bw);
	}
	
	/** main함수 */
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		int K = (int) Math.pow(2, N) - 1;
		bw.write(K+"\n");
		hanoi(N, 1, 3, bw);
		bw.flush();
		bw.close();
		sc.close();
	}
}
