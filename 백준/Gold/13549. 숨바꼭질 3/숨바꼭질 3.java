import java.util.*;
import java.io.*;


public class Main {

	
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int answer = -1;
		
		

		int[] dist = new int[200001];
		Arrays.fill(dist, -1);

		Deque<Integer> q = new LinkedList<Integer>();  
		q.add(N);
		dist[N] = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == K) {
				answer = dist[cur];
				break;
			}
			if(cur<=100000 && dist[2*cur]==-1) {
				dist[2*cur] = dist[cur];
				q.addFirst(2*cur);
			}
			
			if(cur>0 && dist[cur-1]==-1) {
				dist[cur-1] = dist[cur]+1;
				q.addLast(cur-1);
			}
			
			if(cur<200000 && dist[cur+1]==-1) {
				dist[cur+1] = dist[cur]+1;
				q.addLast(cur+1);
			}
		}
		
		System.out.println(answer);
	} 
	
}
