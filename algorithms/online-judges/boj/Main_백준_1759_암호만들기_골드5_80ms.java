import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Main_백준_1759_암호만들기_골드5_80ms
 * 
 *  - 해싱 기법의 아이디어를 적용해보자
 *    : 자음 / 모음을 미리 판별해서 저장해두는 것이, 효율적일 수 있다. 
 */
public class Main_백준_1759_암호만들기_골드5_80ms {
	/** 암호의 길이 L, 가능한 문자의 개수 C */
	private static int L;
	private static int C;
	
	/** 가능한 문자의 배열 crr */
	private static char[] crr;
	private static StringBuilder sb;
	
	public static void print(boolean[] used) {
		int aeiou = 0;
		// 모음 개수 count
		for (int i = 0; i < used.length; i++) {
			if (used[i] && (crr[i] == 'a' || crr[i] == 'e' || crr[i] == 'i'
						|| crr[i] == 'o' || crr[i] == 'u')) aeiou++;
		}
		
		// 모음이 하나 이상, 자음이 둘 이상
		if (aeiou >= 1 && L - aeiou >= 2) {
			for (int i = 0; i < used.length; i++) {
				if (used[i]) sb.append(crr[i]);
			}
			sb.append("\n");
		}
	}
	
	/**
	 * @param cnt
	 * @param used
	 * 가능한 조합을 모두 출력
	 */
	public static void combination(int cnt, int start, boolean[] used) {
		// 기저 조건 - cnt가 L일 때
		if (cnt == L) {
			print(used);
			return;
		}
		
		// 유도 부분 - start부터 use 시작
		int end = C - (L - cnt);
		for (int i = start; i <= end; i++) {
			// cnt 순서에, i번째 원소 사용
			used[i] = true;
			combination(cnt+1, i+1, used);
			used[i] = false;
		}
	}
	
	// a c i s t w
	// a c i s
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		L = Integer.parseInt(st.nextToken()); // 암호의 길이 3 <= L <= C <= 15
		C = Integer.parseInt(st.nextToken()); // 총 문자의 개수
		
		crr = new char[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			crr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(crr);				   // crr 정렬하기 - 정렬 시 크기가 변함
		
		combination(0, 0, new boolean[C]);
		
		System.out.print(sb.toString());
	}
}
