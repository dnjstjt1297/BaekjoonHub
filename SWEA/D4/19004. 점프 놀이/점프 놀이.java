import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			int[][] board = new int[N][N];
			for(int i =0; i<N;i++) {
				for(int j=0;j<N;j++) {
					board[i][j] = sc.nextInt();
				}
			}
            
            if(K==1) {
				boolean is_answer=false;
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(board[i][j] ==1) is_answer = true;
					}
				}
				if(is_answer){
                    System.out.println("#"+test_case+" "+0);
                }
                else{
                    System.out.println("#"+test_case+" -1");
                }
                continue;
			}
			
			int[][] dp = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(board[i][j] != 1)
						dp[i][j] = 10000000;
				}
			}
			
			int answer  = 10000000;
			
			
			for(int i=2;i<=K;i++) {
				for(int a=0;a<N;a++) {
					for(int b =0 ;b<N;b++) {
						if(board[a][b] == i) {
							for(int c=0; c<N; c++) {
								for(int d =0; d<N; d++) {
									if(board[c][d] == i-1) {
										dp[a][b] = Math.min(dp[c][d]+Math.abs(a-c)+Math.abs(b-d),dp[a][b]);
									}
								}
							}
							if(i==K) {
								answer = Math.min(answer, dp[a][b]);
							}
						}
					}
				}
			}
			
			
			
			
			if(answer == 10000000)
				System.out.println("#"+test_case+" -1");
			else
				System.out.println("#"+test_case+" "+answer);
		}
	}
	
	
}