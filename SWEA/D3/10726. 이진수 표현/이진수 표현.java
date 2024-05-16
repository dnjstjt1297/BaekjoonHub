
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileInputStream;

class Location {
	char type;
	int idx;
	public Location(char type, int idx) {
		this.type = type;
		this.idx = idx;
	}
	
}

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			String result = "";
			int length = 0;
			while(M>0) {
				if(M%2==0) {
					result = "0"+result;
				}
				else {
					result = "1"+result;
				}
				M = M/2;
				length++;
			}
			boolean is_answer = true;
			
			for(int i= length-1;i>length-1-N;i--) {
				if(i<0) {
					is_answer = false;
					break;
				}
				if(result.charAt(i)=='0') {
					is_answer = false;
					break;
				}
				
			}
			if(is_answer)
				System.out.println("#"+test_case+" ON");
			else
				System.out.println("#"+test_case+" OFF");
		}
	}
	
}
