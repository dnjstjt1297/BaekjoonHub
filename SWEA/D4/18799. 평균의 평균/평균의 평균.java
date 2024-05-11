import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	
	static double avgSum;
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			
			int[] S = new int[N];
			
			for(int i=0;i<N;i++) {
				S[i] = sc.nextInt();
			}
			avgSum = 0;
			
			dfs(S,N,0,0,0);
			
			
			double answer = avgSum/(Math.pow(2, N)-1);
			if(answer == (int)answer) {
				System.out.println("#"+test_case+" "+(int)answer);
			}
			else
				System.out.println("#"+test_case+" "+answer);
		}
	}
	
	public static void dfs(int[] S, int N, int idx, int size, int sum) {
		
		if(idx>=N) {
			return;
		}
		avgSum+=(double)(sum+S[idx])/(double)(size+1);
		dfs(S,N,idx+1,size+1,sum+S[idx]);
		dfs(S,N,idx+1,size,sum);
		
	}
	
}