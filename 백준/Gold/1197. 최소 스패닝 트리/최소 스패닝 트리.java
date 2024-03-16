import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;


class Edge implements Comparable<Edge> {
	private int v,w;
	private int cost;
	public Edge(int v, int w, int cost) {
		this.v = v;
		this.w = w;
		this.cost = cost;
	}
	public int getV() {
		return this.v;
	}
	public int getW(){
		return this.w;
	}
	public int getCost(){
		return this.cost;
	}
	@Override
	public int compareTo(Edge n) {
		return this.cost - n.cost;
	}
} 

public class Main {
	static int V,E;
	static ArrayList<Edge> edges;
	static int[] parent;
	static int res =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList<Edge>();
		
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(v,w,cost));
		}
		
		parent = new int[V+1];
		for(int i=0;i<=V;i++) parent[i] = i;
		
		kruskal();
		System.out.println(res);
	}
	public static void kruskal() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(Edge e: edges) {
			pq.add(e);
		}
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(!union(e.getV(),e.getW())) {
				res += e.getCost();
			}
		}
	}
	public static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		return find(parent[x]);
	}
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return true;
		parent[y] = x;
		return false;
	}
}
