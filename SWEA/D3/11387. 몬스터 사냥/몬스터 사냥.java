import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int D = sc.nextInt();
			int L = sc.nextInt();
			int N = sc.nextInt();
			long answer = 0;
			for(int i=1;i<=N;i++) {
				answer+= D+(D/100)*((i-1)*L);
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}