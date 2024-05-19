
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			String S1 = sc.next();
			String S2  =sc.next();
			int answer = N;
			for(int i=0;i<N;i++) {
				if(S1.charAt(i)!=S2.charAt(i)) answer--;
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
