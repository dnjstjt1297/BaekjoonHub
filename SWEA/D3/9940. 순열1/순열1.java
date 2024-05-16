
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N =sc.nextInt();
			boolean[] visited = new boolean[N+1];
			int e;
			boolean is_answer = true;
			for(int i=0;i<N;i++) {
				e = sc.nextInt();
				if(visited[e]) {
					is_answer =false;
				}
				visited[e] =true;
			}
			if(is_answer)
				System.out.println("#"+test_case+" Yes");
			else {
				System.out.println("#"+test_case+" No");
			}
		}
	}
	
}
