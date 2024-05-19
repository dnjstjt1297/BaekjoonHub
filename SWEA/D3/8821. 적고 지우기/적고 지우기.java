
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			String S = sc.next();
			int[] nums = new int[10];
			int num;
			int answer =0;
			for(int i=0;i<S.length();i++) {
				num = S.charAt(i)-'0';
				nums[num]++;
				answer++;
				if(nums[num]==2) {
					nums[num] = 0;
					answer-=2;
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
