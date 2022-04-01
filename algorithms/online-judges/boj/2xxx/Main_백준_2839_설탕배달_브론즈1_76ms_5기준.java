import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2839_설탕배달_브론즈1_76ms_5기준
 */
public class Main_백준_2839_설탕배달_브론즈1_76ms_5기준 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int plasticBag = 0;
		
		// 안 되는 유일한 경우
		if (N == 4 | N == 7) plasticBag = -1;
		
		else {
			// N이 15보다 크거나, N이 15보다 작고 3으로 나누어떨어질 때까지 
			while(N >= 15 || N % 3 != 0) {
				N -= 5;
				plasticBag++;
			} 
			// 3키로짜리 추가해주는 부분
			plasticBag += N/3;
		}
		
		System.out.println(plasticBag);
	}
}
