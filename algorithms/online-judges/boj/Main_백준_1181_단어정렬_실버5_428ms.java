import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Main_백준_1181_단어정렬_실버5_428ms
 */
public class Main_백준_1181_단어정렬_실버5_428ms {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		// 1. 사전 순 정렬 (단어 오름차순)
		Arrays.sort(words, (o1, o2) -> o1.compareTo(o2));
		// 2. 길이 오름차순 정렬
		mergeSort(words, 0, N, new String[N]);
		// 3. 출력 - 중복 제외
		sb.append(words[0]).append("\n");
		for (int i = 1; i < N; i++) {
			if (words[i-1].equals(words[i])) continue;
			sb.append(words[i]).append("\n");
		}
		System.out.print(sb.toString());
	} // end of main
	
	/**
	 * 단어 길이 기반 정렬
	 */
	public static void mergeSort(String[] words, int start, int end, String[] temp) {
		// basis part
		if (end - start <= 1) return;
		// divide
		int mid = start + (end - start) / 2;
		mergeSort(words, start, mid, temp);
		mergeSort(words, mid, end, temp);		
		// conquer
		// temp에 왼쪽, 오른쪽 정렬된 배열 저장
		int idx = start; // temp의 인덱스
		int l = start;
		int r = mid;
		// left, right 배열을 temp에 append
		while (l < mid && r < end) {
			// leq: 사전 순 정렬을 해치지 않도록
			if (words[l].length() <= words[r].length()) {
				temp[idx++] = words[l++];
			} else {
				temp[idx++] = words[r++];
			} 
		}
		// 잔여 left, right 데이터 temp에 append
		while (l < mid) {
			temp[idx++] = words[l++];
		}
		while (r < end) {
			temp[idx++] = words[r++];
		}
		// temp에 존재하는 정렬된 데이터를, 기존 words 배열로 copy
		System.arraycopy(temp, start, words, start, end - start);
		
	} // end of mergeSort
} // end of class
