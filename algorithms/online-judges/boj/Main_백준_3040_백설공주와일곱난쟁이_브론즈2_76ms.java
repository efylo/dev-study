import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_3040_백설공주와일곱난쟁이_브론즈2_76ms
 * 
 * 9C7의 조합 문제 -> for문으로도 가능 (뽑아야 하는 수가 정해져있다. )
 */
public class Main_백준_3040_백설공주와일곱난쟁이_브론즈2_76ms {
	
	/** 난쟁이들의 번호를 저장할 배열 */
	private static int[] dwarves;
	
	/**
	 * 정석, 9C7을 직접 검출해보는 알고리즘
	 */
	public static void findDwarves(int pos, int startIdx, int bits) {
		if (pos == 7) {
			// 난쟁이들의 합 검출
			int sum = 0;
			for (int i = 0; i < dwarves.length; i++) {
				if ((bits & 1<<i) != 0) sum += dwarves[i];
			}
			if (sum == 100) {
				for (int i = 0; i < dwarves.length; i++) {
					if ((bits & 1<<i) != 0) System.out.println(dwarves[i]);
				}
			}
			return;
		}
		
		for (int i = startIdx; i < dwarves.length; i++) {
			// 난쟁이 포함 중
			if ((bits & 1<<i) != 0) continue;
			// 난쟁이 포함 X
			findDwarves(pos+1, i+1, bits | 1<<i);
		}
	} // end of findDwarves
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 전역변수 초기화
		dwarves = new int[9];
		
		// 입력 처리
		for (int i = 0; i < dwarves.length; i++) {
			dwarves[i] = Integer.parseInt(br.readLine());
		}
		
		findDwarves(0, 0, 0);
	} // end of main
	
} // end of class
