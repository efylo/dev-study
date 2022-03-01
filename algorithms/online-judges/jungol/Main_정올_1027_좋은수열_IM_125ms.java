import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_정올_1027_좋은수열_IM_125ms
 * 
 *  - brute force(X)
 *    : 중복 순열
 *  - back tracking
 *    : 경우의 수를 확 줄일 수 있는 아이디어
 *      1) 크기 1의 나쁜 수열을 판별
 *      2) 크기 2의 나쁜 수열을 판별
 *      3) 현재까지 들어온 수열은, 좋은 수열이라고 가정
 *         그러기 위해, 다음에 추가할 원소에 대해 좋은 수열을 검출
 *         그렇다면, 수열에 가능한 모든 나쁜 수열을 판별할 필요 X
 */
public class Main_정올_1027_좋은수열_IM_125ms {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder  sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		char[] seq  = new char[N];
		char[] nums = {'1', '2', '3'};
		
		dupPermutation(0, '0', seq, N, nums);
		
		sb.append(seq).append("\n");
		System.out.print(sb.toString());
		
	} // end of main
	
	/**
	 * @param cnt = 현재 자리
	 * @param seq = char 배열로 표현한 수열
	 */
	public static boolean dupPermutation(int cnt, char prev, char[] seq, int N, char[] nums) {
		if (cnt == N) {
			return true;
		}
		if (cnt >= 3 && prev == seq[cnt-3]) { // 크기 2인 나쁜 수열을 제외한다. 
			char c = (char) (150 - (prev + seq[cnt-2]));
			seq[cnt] = c;
			if(checkGood(cnt+1, seq)) return dupPermutation(cnt+1, c, seq, N, nums);
			return false;
		}
		
		for (int i = 0; i < 3; i++) {
			char c = nums[i];
			if (c == prev) continue;
			seq[cnt] = c; // 2
			if(checkGood(cnt+1, seq) && dupPermutation(cnt+1, c, seq, N, nums)) return true;
		}
		return false;
	} // end of dupPermutation

	/**
	 * @param seq
	 * @return 현재 수열이 좋은 수열인지 판별
	 * 
	 * - 길이 1, 2의 나쁜 수열은 순열 코드에서 판별해서 넘기기 때문에 따로 체크하지 않는다. 
	 * - 123121
	 */
	public static boolean checkGood(int len, char[] seq) {
		if (len <= 5) return true;
		
		int maxSize = len/2;
		for (int size = 3; size <= maxSize; size++) {
			int idx1 = len - 2*size;
			int idx2 = len - size;
			boolean isDiff = false;
			for (int i = 0; i < size; i++) {
				if (seq[idx1+i] != seq[idx2+i]) isDiff = true;
			}
			if(!isDiff) return false; // 나쁜 순열 존재
		}
		return true;
	} // end of checkGood
	
} // end of class
