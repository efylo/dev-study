
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Main_17478_재귀함수가뭔가요_실버5_80ms
 */
public class Main_백준_17478_재귀함수가뭔가요_실버5_80ms {
	static int MAX;
	static String prefix = "____";
	static StringBuilder sb = new StringBuilder();
	static String question = "\"재귀함수가 뭔가요?\"\n";
	static String answer = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String answered = "라고 답변하였지.\n";
	static String[] jabdam = {
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", 
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", 
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n", 
	};
	
	static void addPrefix(int N) {
		for (int i = 0; i < N; i++) {
			sb.append(prefix);
		}
	}
	
	static void recursiveCall(int N) {
		// 종료 조건
		if (N > MAX) {
			return;
		}
		// 호출 전 실행부
		addPrefix(N);
		sb.append(question);
		// N에 따른 분기 처리
		if (N == MAX) {
			addPrefix(N);
			sb.append(answer);
		} else {
			for (int i = 0; i < jabdam.length; i++) {
				addPrefix(N);
				sb.append(jabdam[i]);
			}
		}
		// 재귀 호출
		recursiveCall(N+1);
		// 호출 후 실행부
		addPrefix(N);
		sb.append(answered);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MAX = Integer.parseInt(br.readLine().trim());
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		// 재귀함수 호출
		recursiveCall(0);
		System.out.print(sb.toString());
	}
}
