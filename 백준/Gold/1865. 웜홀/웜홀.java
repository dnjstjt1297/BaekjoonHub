import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Edge{
	private int v;
	private int w;
	private int cost;
	public Edge(int v, int w, int cost) {
		this.v = v;
		this.w = w;
		this.cost = cost;
	}
	public int getV() {
		return this.v;
	}
	public int getW() {
		return this.w;
	}
	public int getCost() {
		return this.cost;
	}
}
public class Main {
	static int T;
	static int N,M,W;
	static ArrayList<Edge> edges;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		boolean[] resList = new boolean[T];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList<>();
			int v,w,cost;
			for(int j=0; j<M+W;j++) {
				st = new StringTokenizer(br.readLine());
				v = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				cost = Integer.parseInt(st.nextToken());
				if(j>=M)
					edges.add(new Edge(v,w,-cost));
				else {
					edges.add(new Edge(v,w,cost));
					edges.add(new Edge(w,v,cost));
				}
			}
	
			boolean res = false;
			res = bellmanFord();
			resList[i] = res;
		}
		for(boolean e: resList) {
			if(e)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	public static boolean bellmanFord() {
		int[] dist = new int[N+1];
		boolean is_next;
		for(int i=1; i<=N;i++) {
			for(Edge e: edges) {
				if(dist[e.getW()] > dist[e.getV()]+e.getCost()) {
					is_next = true;
					dist[e.getW()] = dist[e.getV()]+e.getCost();
					if(i == N) {
						return true;
					}
				}
			}
		}
		return false;
	}
}