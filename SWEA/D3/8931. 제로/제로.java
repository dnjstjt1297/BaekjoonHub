import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int K = sc.nextInt();
			Stack<Integer> q = new Stack<>();
			
			int num;
			for(int i=0;i<K;i++) {
				num = sc.nextInt();
				if(num ==0) {
					if(!q.isEmpty()) {
						q.pop();
					}
				}
				else {
					q.add(num);
				}
			}
			int answer =0;
			for(int e: q) {
				answer+=e;
			}
			
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
