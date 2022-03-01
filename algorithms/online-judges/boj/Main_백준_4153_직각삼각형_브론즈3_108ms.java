
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Main_백준_4153_직각삼각형_브론즈3_108ms
 */
public class Main_백준_4153_직각삼각형_브론즈3_108ms {
	public static void main(String[] args) throws IOException {
		// 입력 처리
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] triangle = sc.nextLine().split(" ");
		int a = Integer.valueOf(triangle[0]);
		int b = Integer.valueOf(triangle[1]);
		int c = Integer.valueOf(triangle[2]);
		
		while (a != 0) {
			a *= a;
			b *= b;
			c *= c;
			if (a + b == c || b + c == a || c + a == b) {
				bw.write("right\n");
			} else {
				bw.write("wrong\n");
			}
			
			triangle = sc.nextLine().split(" ");
			a = Integer.valueOf(triangle[0]);
			b = Integer.valueOf(triangle[1]);
			c = Integer.valueOf(triangle[2]);
		}
		
		
		bw.flush();
		bw.close();
		sc.close();
	} // end of main
} // end of class
