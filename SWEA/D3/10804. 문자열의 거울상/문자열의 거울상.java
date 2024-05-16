import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String S = sc.next();
			String answer ="";
			
			for(int i=S.length()-1;i>=0;i--) {
				if(S.charAt(i)=='p') {
					answer+='q';
				}
				else if(S.charAt(i)=='q') {
					answer+='p';
				}
				else if(S.charAt(i)=='b') {
					answer+='d';
				}
				else if(S.charAt(i)=='d') {
					answer+='b';
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
