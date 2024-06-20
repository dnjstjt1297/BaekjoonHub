import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] records = new int[N][9];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				records[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ArrayList<Integer> q = new ArrayList<>();
		boolean[] visited = new boolean[9];
		
		int maxTotalScore = findMaxScore(q,records,visited, N, 0, 1);
		System.out.println(maxTotalScore);
		
	}
	/**
	 * 타자들의 순서가 정해진 게임의 전체 점수를 구하는 함수
	 * @param seq : 타자의 순서
	 * @param N : 전체 이닝 수
	 */
	private static int getTotalScore(int[][] records, int[] seq, int N) {
		int totalScore = 0;
		int num=0;
		for(int i=0;i<N;i++) {
			int out =0;
			boolean[] atBats = new boolean[4];
			while(out<3) {
				int hit = records[i][seq[num]];
				totalScore+=getScore(atBats,hit);
				
				if(hit==0) out++;
				num++;
				if(num>=9) num = 0;
			}
		}
		return totalScore;
	}
	/**
	 * 타자가 얻을 수 있는 점수를 반환하는 함수
	 * @param atBats : 타석 배열(1루 2루 3루)
	 * @param hit : 안타나 홈런을 결정하는 수
	 * @return 타석과 hits에 따른 점수
	 */
	private static int getScore(boolean[] atBats, int hit) {
		if(hit==0) return 0;
		int score = 0;
		for(int i=3;i>=1;i--) {
			if(atBats[i]) {
				atBats[i] = false;
				if(hit+i>=4) score++;
				else atBats[i+hit] = true;
			}
		}
		if(hit == 4) score++;
		else atBats[hit] = true;
		return score;
	}
	/**
	 * dfs 완전탐색 사용
	 * 타자의 순서에 따른 경기의 전체 점수의 최댓값 구하는 함수
	 * @param arr : 타자 순서를 결정할 배열
	 * @param visited : 티자 순서가 결정된 idx를 판단하는 변수
	 * @param N : 전체 이닝 수
	 * @param cnt : 타자 순서를 결정한 수
 	 * @return 타자 순서에 따른 가능한 최대 점수
	 */
	public static int findMaxScore(ArrayList<Integer> arr,int[][] records, boolean[] visited, int N, int maxTotalScore, int cnt) {
		if(cnt==9) {
			int[] seq = new int[arr.size()+1];
			int idx = 0;
			seq[3] = 0;
			for(int e: arr) {
				if(idx == 3) idx++;
				seq[idx] = e;
				idx++;
			}
			int totalScore = getTotalScore(records, seq, N);
			return Math.max(maxTotalScore, totalScore);
		}
		visited[0] = true;
		for(int i=1;i<9;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			ArrayList<Integer> copyArr = (ArrayList) arr.clone();
			copyArr.add(i);
			maxTotalScore = findMaxScore(copyArr,records,visited,N,maxTotalScore,cnt+1);
			visited[i] = false;
		}
		return maxTotalScore;
	}	
}