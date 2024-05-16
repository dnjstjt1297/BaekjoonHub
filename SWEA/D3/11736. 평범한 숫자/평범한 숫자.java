import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N =sc.nextInt();
			int[] P = new int[N];
			int max = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				P[i] = sc.nextInt();
				max = Math.max(max, P[i]);
				min = Math.min(min, P[i]);
			}
			int answer = 0;
			
			for(int i=1;i<N-1;i++) {
				if(P[i-1]<P[i]){
					if(P[i]<P[i+1]) {
						answer++;
					}
				}
				else if(P[i-1]>P[i]){
					if(P[i]>P[i+1]) {
						answer++;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}