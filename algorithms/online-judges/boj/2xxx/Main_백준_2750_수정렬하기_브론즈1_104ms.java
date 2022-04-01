import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_2750_수정렬하기_브론즈1_104ms
 * 버블정렬, 선택정렬, 분할정복을 활용해 수 정렬 알고리즘을 구현해보았다. 
 * 분할정복의 경우, 메모리를 덜 쓰고 시간을 투자하는 방식(배열 회전을 이용)을 사용하였다. 
 */
public class Main_백준_2750_수정렬하기_브론즈1_104ms {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		// 정렬
		divideConquer(numbers, 0, numbers.length);
		for (int i = 0; i < N; i++) {
			sb.append(numbers[i]).append("\n");
		}
		// 출력
		System.out.println(sb.toString());
	}
	
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	} // end of swap
	
	public static void bubbleSort(int[] numbers) {
		int len = numbers.length;
		for (int i = 0; i < len-1; i++) {
			for (int j = 0; j < len-1-i; j++) {
				if (numbers[j] > numbers[j+1]) {
					swap(numbers, j, j+1);
				}
			}
		}
	} // end of method bubbleSort
	
	public static void selectionSort(int[] numbers) {
		int len = numbers.length;
		for (int i = 0; i < len; i++) {
			int minIdx = i;
			for (int j = i + 1; j < len; j++) {
				if (numbers[j] < numbers[minIdx]) {
					minIdx = j;
				}
			}
			swap(numbers, i, minIdx);
		}
	} // end of method selectionSort
	
	public static void divideConquer(int[] numbers, int start, int end) {
		// basis part
		if (end - start <= 1) {
			return;
		}
		// inductive part(1) - divide
		int mid = start + (end - start) / 2;
		divideConquer(numbers, start, mid); // 왼쪽 부분이 정렬됨
		divideConquer(numbers, mid, end); 	// 오른쪽 부분이 정렬됨
		// inductive part(2) - conquer
		while(start < mid && mid < end) {
			if(numbers[start] <= numbers[mid]) start++;
			else {
				int temp = numbers[mid];
				for (int i = mid; i > start; i--) {
					numbers[i] = numbers[i-1];
				}
				numbers[start++] = temp;
				mid++;
			}
		}
	} // end of method divideConquer
} // end of class
