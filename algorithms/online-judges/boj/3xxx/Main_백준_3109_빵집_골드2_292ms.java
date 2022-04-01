import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Main_백준_3109_빵집_골드2_292ms
 * 
 *  백트래킹
 *   - 재귀함수 호출 전에, 탐색이 가능한지 확인한다. 
 */
public class Main_백준_3109_빵집_골드2_292ms {
	static int R;
	static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 지도의 크기
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 지도 초기화
		char[][] map = new char[R][];
		
		// '.' = 빈 공간, 'x' = 건물, 'o' = 파이프가 설치된 자리
		for (int i = 0; i < map.length; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 파이프 시공
		int result = 0;
		for (int r = 0; r < map.length; r++) {
			if (construct(r, 0, map)) {
				result++;
			}
		}
		
		System.out.println(result);
		
		
		
	} // end of main

	/**
	 * @param sr = 행 정보
	 * @param sc = 열 정보
	 * @param map = 지도 정보
	 * @return = 시공 가능, 불가능 여부
	 */
	public static boolean construct(int sr, int sc, char[][] map) {
		// 끝까지 연결됐을 경우, 맵을 수정해주고 true 반환
		if (sc == map[0].length - 1) {
			map[sr][sc] = 'o';
			return true;
		}
		
		// 다음 열로 진행 ↗, →, ↘
		for (int r = sr-1, er = sr+1; r <= er; r++) {
			// 백트래킹 - 진행 가능 여부 판별
			if (r >= 0 && r < R && map[r][sc+1] == '.') {
				boolean flag = construct(r, sc+1, map);
				if (flag) { // 시공 가능
					map[sr][sc] = 'o';
					return true;
				}
			}
		}
		// 시공 불가능
		map[sr][sc] = 'x';
		return false;
		
	}
} // end of class
