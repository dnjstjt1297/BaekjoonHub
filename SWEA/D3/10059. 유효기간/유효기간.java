
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
			String S = sc.next();
			
			boolean is_month1 = false;
			if(S.charAt(0) == '1') {
				if(S.charAt(1)>='0'&&S.charAt(1)<='2') {
					is_month1 = true;
				}
			}
			else if(S.charAt(0)=='0') {
				if(S.charAt(1)>='1'&&S.charAt(1)<='9') {
					is_month1 = true;
				}
			}
			
			boolean is_month2 = false;
			if(S.charAt(2) == '1') {
				if(S.charAt(3)>='0'&&S.charAt(3)<='2') {
					is_month2 = true;
				}
			}
			else if(S.charAt(2)=='0') {
				if(S.charAt(3)>='1'&&S.charAt(3)<='9') {
					is_month2 = true;
				}
			}
			
			if(is_month1&&is_month2) {
				System.out.println("#"+test_case+" AMBIGUOUS");
			}
			else if(is_month1) {
				System.out.println("#"+test_case+" MMYY");
			}
			else if(is_month2) {
				System.out.println("#"+test_case+" YYMM");
			}
			else {
				System.out.println("#"+test_case+" NA");
			}
			
		}
	}
	
}
