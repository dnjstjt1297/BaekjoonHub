
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++) {
			
			String S = br.readLine();
			
			String[] SList = S.split(" ");
			String answer = "";
			
			int min = Integer.MAX_VALUE;
			int max = 0;
			
			for(int i=0;i<SList.length;i++) {
				int a =0;
				for(int j=0;j<SList[i].length();j++) {
					a+=SList[i].charAt(j)-'0';
				}
				min = Math.min(min, a);
				max = Math.max(max, a);
			}
			System.out.println("#"+test_case+" "+max+" "+min);
		}
	}
	
}
