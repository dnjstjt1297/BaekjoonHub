
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main (String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());
			if(n==1) {
				System.out.println(0);
				continue;
			}
			
			
			List<Integer>[] tree = new ArrayList[n+1];
			for(int i = 1; i<=n;i++) {
				tree[i] = new ArrayList<>();
			}
			
			
			for(int i = 0; i<n-1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());	
				tree[a].add(b);
				tree[b].add(a);
			}
			
			
			
			int result = 0;
			int leaf = -1;
			
			for(int i =1; i<=n;i++) {
				if(tree[i].size()==1) {
					leaf = i;
					break;
				}
			}
			boolean[] visited = new boolean[n+1];
			
			Queue<Integer> q = new LinkedList<>();
			q.add(leaf);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				visited[cur] = true;
				
				int cnt = 0;
				for(int node: tree[cur]) {
					if(visited[node]) continue;
					cnt++;
					q.add(node);
				}
				if(cnt>=2) result+=cnt-1;
			}
			System.out.println(result);
		}
	}
}
