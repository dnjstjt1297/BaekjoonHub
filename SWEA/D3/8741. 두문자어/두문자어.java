
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
			for(int i=0;i<SList.length;i++) {
				answer+=(char)(SList[i].charAt(0)-'a'+'A');
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
