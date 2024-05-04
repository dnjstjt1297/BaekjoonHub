import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    static boolean is_palindrome;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			is_palindrome = true;
			
			palindrome(str,0,str.length()-1,0);
			if(is_palindrome) {
				System.out.println("#"+test_case+" YES");
			}
			else {
				System.out.println("#"+test_case+" NO");
			}

		}
	}
	
	public static void palindrome(String str, int start, int end, int k) {
		if(start >= end) {
			return;
		}
		int mid = (start+end)/2;
		
		int len = end- start+1;
		for(int i = 0; i<len/2;i++) {
			if(str.charAt(start+i)!=str.charAt(end-i))
				is_palindrome =false;
		}
		
		if(len%2==1&&k==0) {
			palindrome(str, mid+1,end,1);
			palindrome(str, start,mid-1,1);
		}
		
	}
}
