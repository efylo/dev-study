
import java.util.Scanner;

/**
 * Main_백준_1085_직사각형에서탈출_브론즈3_112ms
 */
public class Main_백준_1085_직사각형에서탈출_브론즈3_112ms {
	public static void main(String[] args) {
		// 입력 처리
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int dist = 0;
		dist = Math.min(Math.min(y, h-y), Math.min(x, w-x));
		
		System.out.println(dist);
	}
}
