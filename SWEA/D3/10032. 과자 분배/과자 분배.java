import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N =sc.nextInt();
			int K = sc.nextInt();
			if(N%K!=0) {
				System.out.println("#"+test_case+" 1");
			}
			else {
				System.out.println("#"+test_case+" 0");
			}
			
		}
	}
	
	
}
