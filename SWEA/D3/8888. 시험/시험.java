import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
	        int t = Integer.parseInt(st.nextToken());
	        int p = Integer.parseInt(st.nextToken());
			
			int[] scores = new int[t];
			int[][] is_answers = new int[n][t]; 
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<t;j++) {
					is_answers[i][j] = Integer.parseInt(st.nextToken());
					if(is_answers[i][j] == 0) scores[j]++;
				}
			}
			
			int JHscore = 0;
			int JHnum = 0;
			for(int i=0;i<t;i++) {
				if(is_answers[p-1][i] == 1) {
					JHscore+=scores[i];
					JHnum++;
				}
			}
			
			int answer = 1;
			
			for(int i=0;i<n;i++) {
				if(i==p-1) continue;
				int score = 0;
				int num = 0;
				int min = Integer.MAX_VALUE;
				for(int j=0;j<t;j++) {
					if(is_answers[i][j] == 1) {
						score+=scores[j];
						min = Math.min(min, j);
						num++;
					}
				}
				if(score>JHscore) {
					answer++;
				}
				else if(score==JHscore) {
					if(num>JHnum) {
						answer++;
					}
					else if(num==JHnum) {
						if(i<p-1) {
							answer++;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+JHscore+" "+answer);
		}
	}
	
	
}
