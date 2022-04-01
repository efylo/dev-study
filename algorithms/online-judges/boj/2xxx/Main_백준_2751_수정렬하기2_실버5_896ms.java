import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2751_수정렬하기2_실버5_896ms
 */
public class Main_백준_2751_수정렬하기2_실버5_896ms {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		// 분할정복 정렬 호출
		numbers = divideConquer(numbers, 0, N);
		// 자바 내장 sort - 시간 초과..(quick sort?)
//		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			sb.append(numbers[i]).append("\n");
		}
		// 출력 
		System.out.println(sb.toString());
	} // end of main
	
	public static int[] divideConquer(int[] numbers, int start, int end) {
		// basis part
		if (end == start) {
			return null;
		}
		if (end - start == 1) {
			return new int[] {numbers[start]};
		}
		// inductive part - divide
		int mid = start + (end - start) / 2;
		int[] left  = divideConquer(numbers, start, mid);
		int[] right = divideConquer(numbers, mid, end);
		// inductive part - conquer
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		int[] ret = new int[end - start];
		int l = 0, r = 0, idx = 0;
		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				ret[idx++] = left[l++];
			}
			else {
				ret[idx++] = right[r++];
			}
		}
		if (l < left.length) {
			// 직접 copy하는 것보다, system.arraycopy가 60ms정도 빠르다. 
			System.arraycopy(left, l, ret, idx, left.length - l);
		}
		if (r < right.length) {
			System.arraycopy(right, r, ret, idx, right.length - r);
		}
		
		return ret;
	} // end of divideConquer
} // end of class
