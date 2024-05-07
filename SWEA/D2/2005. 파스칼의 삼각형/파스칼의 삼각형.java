import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] dp = new int[N+1][N+1];
			
			System.out.println("#"+test_case);
			dp[1][1] = 1;
			System.out.println(dp[1][1]);
			for(int i=2;i<=N;i++) {
				for(int j=1;j<=i;j++) {
					if(j==1) {
						dp[i][j] = dp[i-1][j];
					}
					if(j==i) {
						dp[i][j] = dp[i-1][j-1];
					}
					else {
						dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
					}
					System.out.print(dp[i][j]+" ");
				}

				System.out.println();
			}
			
		}
	}
}