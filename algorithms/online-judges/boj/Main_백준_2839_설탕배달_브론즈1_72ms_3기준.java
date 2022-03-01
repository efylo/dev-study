import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2839_설탕배달_브론즈1_72ms_3기준
 */
public class Main_백준_2839_설탕배달_브론즈1_72ms_3기준 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int plasticBag = 0;
		
		// 안 되는 유일한 경우 - 
		if (N == 4 | N == 7) plasticBag = -1;
		
		else {
			// N 3씩 빼주면서 
			while(N%5 != 0) {
				N -= 3;
				plasticBag++;
			}
			// 5kg 비닐봉지의 개수를 추가
			plasticBag += N/5;
		}
		
		System.out.println(plasticBag);
	}
}
