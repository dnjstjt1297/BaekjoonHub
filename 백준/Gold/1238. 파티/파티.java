import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node implements Comparable<Node>{
	int idx;
	int cost;
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}
public class Main {
	static int N,M,X;
	static ArrayList<Node>[] graph;
	static int dist1[];
	static int dist2[];
	static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<Node>();
		}
		dist1 = new int[N+1];
		dist2 = new int[N+1];
		int v,w,cost;
		for(int i =0; i<M;i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			graph[v].add(new Node(w,cost));
		}
		dijkstra(X,dist2);
		for(int i=1; i<=N;i++) {
			dijkstra(i,dist1);
			res = Math.max(res,dist2[i] + dist1[X]); 
		}
		System.out.println(res);
	}
	public static void dijkstra(int start, int[] dist) {
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			int node = pq.poll().idx;
			if(visited[node]) continue;
			visited[node]= true;
			
			for(Node e: graph[node]) {
				if(dist[e.idx]>dist[node]+e.cost) {
					dist[e.idx] = dist[node]+e.cost;
					pq.add(new Node(e.idx, dist[e.idx]));
				}
			}
		}
		
	}
	
}




