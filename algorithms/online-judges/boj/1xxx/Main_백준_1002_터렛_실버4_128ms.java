
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Main_백준_1002_터렛_실버4_128ms
 */
public class Main_백준_1002_터렛_실버4_128ms {
	public static void main(String[] args) throws IOException {
		// 입력 처리
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = sc.nextInt();
		sc.nextLine(); // 개행문자 제거
		for (int i = 0; i < TC; i++) {
			String[] xyr = sc.nextLine().split(" ");
			int x21 = Integer.valueOf(xyr[3]) - Integer.valueOf(xyr[0]);
			int y21 = Integer.valueOf(xyr[4]) - Integer.valueOf(xyr[1]);
			int r1 = Integer.valueOf(xyr[2]);
			int r2 = Integer.valueOf(xyr[5]);
			// (x1, y1) == (x2, y2) && r1 == r2 -> 무한대
			// (x1, y1) == (x2, y2) && r1 != r2 -> 0
			if (x21 == 0 && y21 == 0) {
				if (r1 == r2) {
					bw.write(-1+"\n");
				} else {
					bw.write(0+"\n");
				}
			}
			// (r1 + r2)*(r1 + r2) == (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1) -> 1
			// (r1 - r2)*(r1 - r2) == (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1) -> 1
			
			// (r1 - r2)*(r1 - r2) > (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1) -> 0
			// (r1 + r2)*(r1 + r2) < (x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1) -> 0
			
			// else -> 2			
			else {
				int dist2 = x21*x21 + y21*y21;
				int rpr = (r1 + r2) * (r1 + r2);
				int rmr = (r1 - r2) * (r1 - r2);
				if (rpr == dist2 || rmr == dist2) {
					bw.write(1+"\n");
				} else if (rmr > dist2 || rpr < dist2) {
					bw.write(0+"\n");
				} else {
					bw.write(2+"\n");
				}
			}
		}
		bw.flush();
		bw.close();
		sc.close();
	} // end of main
} // end of class
