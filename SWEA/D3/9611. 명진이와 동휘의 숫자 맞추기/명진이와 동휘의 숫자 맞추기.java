
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
			boolean[] is_answer = new boolean[10];
			Arrays.fill(is_answer, true);
			int a,b,c,d;
			String S;
			for(int i=0;i<N;i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				c = sc.nextInt();
				d = sc.nextInt();
				S = sc.next();
				if(S.equals("YES")) {
					for(int j=0;j<10;j++) {
						if(j!=a&&j!=b&&j!=c&&j!=d) {
							is_answer[j] = false;
						}
					}
				}
				else if(S.equals("NO")){
					is_answer[a] = false;
					is_answer[b] = false;
					is_answer[c] = false;
					is_answer[d] = false;
				}
			}
			for(int i=0;i<10;i++) {
				if(is_answer[i]) {
					System.out.println("#"+test_case+" "+i);
				}
			}
		}
	}
	
}
