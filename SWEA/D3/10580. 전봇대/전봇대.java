
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
			int N = sc.nextInt();
			int[][] wires = new int[N][2];
			int answer = 0;
			int A,B;
			for(int i=0;i<N;i++) {
				A = sc.nextInt();
				B = sc.nextInt();
				wires[i][0] = A;
				wires[i][1] = B;
			}
			
			Arrays.sort(wires, new Comparator<int[]>(){
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(wires[i][1]>wires[j][1]) {
						answer++;
					}
				}
			}
			
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
