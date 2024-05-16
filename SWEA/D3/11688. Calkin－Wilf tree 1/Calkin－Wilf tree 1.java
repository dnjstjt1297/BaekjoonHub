import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String S = sc.next();
			int a = 1;
			int b = 1;
			for(int i=0;i<S.length();i++) {
				if(S.charAt(i)=='L') {
					b = a+b;
				}
				if(S.charAt(i)=='R') {
					a = a+b;
				}
			}
			
			
			System.out.println("#"+test_case+" "+a+" "+b);
		}
	}
	
}