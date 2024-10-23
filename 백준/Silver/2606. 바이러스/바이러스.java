import java.util.*;
import java.io.*;



public class Main{
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		for(int i =0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int result =0;
		boolean[] visited = new boolean[N+1];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int e: graph[cur]) {
				if(visited[e]) continue;
				q.add(e);
				visited[e] = true;
				result++;
			}
		}
		
		System.out.println(result);
		
	}

}
