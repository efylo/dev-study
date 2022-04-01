import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Main_백준_1786_찾기_플래티넘5_504ms
 * 
 *  - KMP 알고리즘
 *    : P(패턴) - 길이 M
 *      P[i]에 대해서, (0 <= i < x) == (M-x <= i < M)인 경우를 탐색
 * 
 */
public class Main_백준_1786_찾기_플래티넘5_504ms {
	
	static int cnt;
	static ArrayList<Integer> hit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] T = br.readLine().toCharArray(); // A-Z | a-z | 공백
		char[] P = br.readLine().toCharArray();
		
		int n = T.length; // 1 <= n, m <= 1,000,000
		int m = P.length;
		
		// 부분 일치 집합
		// i번째 index = {0...pi[i]} == {i-pi[i]...i}
		int[] pi = getPi(P);
		
		cnt = 0;
		hit = new ArrayList<Integer>();
		
		KMP(T, P, pi);
		
		sb.append(cnt).append("\n");
		for (int i : hit) {
			sb.append(i).append(" ");
		}
		sb.append("\n");
		
		System.out.print(sb.toString());
		
	} // end of main
	
	/**
	 * @param pattern
	 * @return pi (부분 일치 집합)
	 * 
	 * {0...matched} == {end-matched...end}
	 * pattern[matched] != pattern[end]
	 * e.g) abcxyzabcy ... abcxyzabcx  
	 *      matched == 9
	 *      pattern[matched] == y, pattern[end] == x
	 *      pattern[matched-1]을 보면, 직전까지 동일한 abc를 볼 수 있다. 
	 *      {0...pattern[matched-1]} == {end-pattern[matched-1]...end}
	 *      고로 다시 pattern[matched-1]과 end를 비교하면 된다.
	 */
	public static int[] getPi(char[] pattern) {
		// 부분 일치 집합
		// {0..pi[i]} == {i-pi[i]...i}
		int[] pi = new int[pattern.length];
		
		int matched = 0;
		for (int end = 1; end < pi.length; end++) {
			while(matched > 0 && pattern[matched] != pattern[end]) {
				matched = pi[matched-1];
			}
			
			// matched될 경우, 다음 end로 matched 값을 넘긴다. 
			if (pattern[matched] == pattern[end]) pi[end] = ++matched;
			else pi[end] = 0;
		}
		
		return pi;
	} // end of getPi
	
	public static void KMP(char[] text, char[] pattern, int[] pi) {
		int n = text.length;
		int m = pattern.length;
		
		int matched = 0;
		for (int i = 0; i < n; i++) {
			if (matched == m) {
				hit.add(i-matched+1); // 1-based 인덱스
				cnt++;
				matched = pi[matched-1];
			}
			while(matched > 0 && text[i] != pattern[matched]) {
				matched = pi[matched-1];
			}
			
			if (text[i] == pattern[matched]) matched++;
		}
		if (matched == m) {
			hit.add(n-matched+1); // 1-based 인덱스
			cnt++;
		}
	} // end of KMP
	
} // end of class
