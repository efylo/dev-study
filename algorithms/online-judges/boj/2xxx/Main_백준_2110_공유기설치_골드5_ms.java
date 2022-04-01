import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main_백준_2110_공유기설치_골드5_ms
 * 
7 4
0
4
8
11
13
15
18

==> 답: 5
 */
public class Main_백준_2110_공유기설치_골드5_ms {
	
	public static int[] houses;
	public static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // N <= 200,000
		int C = Integer.parseInt(st.nextToken()); // C <= N
		houses = new int[N];
		
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses); // 퀵 정렬
		
		System.out.println(search(0, houses[N-1], C-1, (houses[N-1]-houses[0]) / (C-1)));
		
		
		
	} // end of main
	
	/**
	 * pos: 현재 인덱스, end: 마지막 좌표값, div: 분할 개수
	 */
	public static int search(int pos, int end, int div, int dd) {
		int start = houses[pos];
		int dist =  end - start;
		if (div == 1) return dist;
		
		int offset = start + dd;
		int next = pos+1;
		int last = N-div;
		
		for (int i = next+1; i <= last; i++) {
			if (houses[i] >= offset) {
				if (houses[i] - offset < offset - houses[i-1]) next = i;
				else next = i-1;
				break;
			}
		}
		return Math.min(houses[next]-start, search(next, end, div-1, dd));
	} // end of search

} // end of class
