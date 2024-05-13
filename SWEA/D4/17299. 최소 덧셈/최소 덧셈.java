import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String S = sc.next();
			int N = S.length();
			int answer =Integer.MAX_VALUE;
			if(N%2==0){
				String A = S.substring(0,N/2);
				String B = S.substring(N/2,N);
				int IA =0;
				int IB =0;
				int num = 1;
				for(int i=A.length()-1;i>=0;i--) {
					IA += (A.charAt(i)-'0')*num;
					num*=10;
				}
				num = 1;
				for(int i=B.length()-1;i>=0;i--) {
					IB += (B.charAt(i)-'0')*num;
					num*=10;
				}
				
				answer = IA+IB;
			}
			else {
				String A = S.substring(0,N/2);
				String B = S.substring(N/2,N);
				int IA =0;
				int IB =0;
				int num = 1;
				for(int i=A.length()-1;i>=0;i--) {
					IA += (A.charAt(i)-'0')*num;
					num*=10;
				}
				num = 1;
				for(int i=B.length()-1;i>=0;i--) {
					IB += (B.charAt(i)-'0')*num;
					num*=10;
				}
				answer = IA+IB;
				A = S.substring(0,N/2+1);
				B = S.substring(N/2+1,N);
				IA =0;
				IB =0;
				num = 1;
				for(int i=A.length()-1;i>=0;i--) {
					IA += (A.charAt(i)-'0')*num;
					num*=10;
				}
				num = 1;
				for(int i=B.length()-1;i>=0;i--) {
					IB += (B.charAt(i)-'0')*num;
					num*=10;
				}
				answer = Math.min(answer, IA+ IB);
				
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}