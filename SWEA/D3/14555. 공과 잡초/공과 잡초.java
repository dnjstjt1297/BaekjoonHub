import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	
	static boolean[] is_prime;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String S = sc.next();
			int answer =0;
			
			for(int i=0;i<S.length();i++) {
				if(S.charAt(i)=='(' && i!=S.length()-1) {
					if(S.charAt(i+1)==')'||S.charAt(i+1)=='|') {
						answer ++;
						i++;
					}
				}
				if(S.charAt(i)=='|' && i!=S.length()-1) {
					if(S.charAt(i+1)==')') {
						answer ++;
						i++;
					}
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
}