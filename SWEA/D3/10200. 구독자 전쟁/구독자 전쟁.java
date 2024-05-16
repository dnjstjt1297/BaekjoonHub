import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N =sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int max = Math.min(A,B);
			int min = A+B-N;
			if(min<0) min = 0;
			System.out.println("#"+test_case+" "+max+" "+min);
		}
	}
	
	
}
