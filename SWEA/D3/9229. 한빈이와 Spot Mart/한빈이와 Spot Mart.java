import java.util.Arrays;
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
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] a = new int[N];
			
			for(int i=0;i<N;i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			int answer = -1;
			int A,B;
			for(int i=0;i<N;i++) {
				A = a[i];
				for(int j=i+1;j<N;j++) {
					B = a[j];
					if(A+B<=M) {
						answer = Math.max(A+B,answer);
					}
					else break;
				}
			}
			
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
