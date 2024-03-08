import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int V;
	static ArrayList<Integer>[] tree;
	static boolean[] visted;
	static int vertice1;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		
		tree = new ArrayList[V];
		visted = new boolean[V];
		for(int i=0; i<V;i++) {
			st = new StringTokenizer(br.readLine());
			int n=0;
			tree[i] = new ArrayList<Integer>();
			while(true) {
				n = Integer.parseInt(st.nextToken());
				if(n == -1) break;
				tree[i].add(n);
			}
			visted[i] = false;
		}
		Arrays.sort(tree, (o1,o2)->{	
			return o1.get(0) - o2.get(0);
		});
		dfs(tree[0].get(0),0);
		ans =0;
		for(int i=0; i<V; i++) visted[i] = false;
		dfs(vertice1,0);
		System.out.println(ans);
	}
	public static void dfs(int start, int n) {
		if(n>ans) {
			vertice1 = start;
			ans = n;
		}
		visted[start-1] = true;
		for(int i=1; i<tree[start-1].size();i+=2) {	
			if(visted[tree[start-1].get(i)-1]) {
				continue;
			}
			else dfs(tree[start-1].get(i), n+tree[start-1].get(i+1));
		}
	}
}