import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Main_백준_11651_좌표정렬하기2_실버5_608ms
 */
public class Main_백준_11651_좌표정렬하기2_실버5_608ms {
	public static void main(String[] args) throws Exception {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] coord = new int[N*2][2];
		// 입력 데이터 파싱
		String line;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			int space = 0;
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == ' ') {
					space = j;
					break;
				}
			}
			coord[i][0] = Integer.parseInt(line.substring(0, space));
			coord[i][1] = Integer.parseInt(line.substring(space+1));
		}
		// x 좌표 먼저 정렬
		mergeSort(coord, 0, N, 0, N);
		// y 좌표 이후 정렬
		mergeSort(coord, 0, N, 1, N);
		// 출력 처리
		for (int i = 0; i < N; i++) {
			sb.append(coord[i][0]).append(" ").append(coord[i][1]).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void mergeSort(int[][] coord, int start, int end, int axis, int N) {
		// basis part
		if (end - start <= 1) return;
		// divide
		int mid = start + (end - start) / 2;
		mergeSort(coord, start, mid, axis, N);
		mergeSort(coord, mid, end, axis, N);
		// conquer
		// start부터 end까지 정렬
		int idx = start + N;
		int l = start;
		int r = mid;
		while(l < mid && r < end) {
			if (coord[l][axis] <= coord[r][axis]) {
				System.arraycopy(coord[l++], 0, coord[idx++], 0, 2);
			} else {
				System.arraycopy(coord[r++], 0, coord[idx++], 0, 2);
			}
		}
		while (l < mid) {
			System.arraycopy(coord[l++], 0, coord[idx++], 0, 2);
		}
		while (r < end) {
			System.arraycopy(coord[r++], 0, coord[idx++], 0, 2);
		}
		for (int i = start; i < end; i++) {
			System.arraycopy(coord[i+N], 0, coord[i], 0, 2);
		}
	}
}
