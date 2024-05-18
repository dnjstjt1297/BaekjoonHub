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
			int[] R = new int[N];
			int[] W = new int[M];
			int[] S = new int[2*M];
			for(int i=0;i<N;i++) {
				R[i] = sc.nextInt();
			}
			for(int i=0;i<M;i++) {
				W[i] = sc.nextInt();
			}
			for(int i=0;i<2*M;i++) {
				S[i] = sc.nextInt();
			}
			
			int answer = 0;
			int[] park = new int[N];
			Queue<Integer> q = new LinkedList<>();
			for(int i=0;i<2*M;i++) {
				if(S[i]<0) {
					for(int j=0;j<N;j++) {
						if(park[j]==-S[i]) {
							park[j] = 0;
							answer+= W[-S[i]-1]*R[j];
							break;
						}
					}
					if(!q.isEmpty()) {
						for(int j=0;j<N;j++) {
							if(park[j]==0) {
								int next = q.poll();
								park[j] = next;
								break;
							}
						}
					}
				}
				else {
					q.add(S[i]);
					for(int j=0;j<N;j++) {
						if(park[j]==0) {
							int next = q.poll();
							park[j] = next;
							break;
						}
					}
				}
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
