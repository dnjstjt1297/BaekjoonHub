
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int answer = 0;
			for(int i=A;i<=B;i++) {
				if(Math.sqrt(i)==(int)Math.sqrt(i)) {
					
					int tmp = i;
					String S = "";
					while(tmp>0) {
						S=(char)(tmp%10+'0')+S;
						tmp /=10;
					}
					boolean is_palindrome = true;
					for(int j=0;j<S.length()/2;j++) {
						if(S.charAt(j) != S.charAt(S.length()-1-j)) {
							is_palindrome = false;
							break;
						}
					}
					if(is_palindrome) {
						tmp = (int) Math.sqrt(i);
						S = "";
						while(tmp>0) {
							S=(char)(tmp%10+'0')+S;
							tmp/=10;
						}
						is_palindrome = true;
						for(int j=0;j<S.length()/2;j++) {
							if(S.charAt(j) != S.charAt(S.length()-1-j)) {
								is_palindrome = false;
								break;
							}
						}
						if(is_palindrome) {
							answer++;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
