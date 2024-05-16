import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int answer =0;
			for(int i=0;i<N;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				double r = Math.sqrt(x*x+y*y);
				int p = 11-(int)r/20;
				if(r%20!=0) p--;
				if(r==0) p--;
				if(p<0) {
					continue;
				}
				answer+=p;
			}
			
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}