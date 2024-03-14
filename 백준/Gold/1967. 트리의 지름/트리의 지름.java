import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

class Node{
	private int child;
	private int cost;
	public Node(int child, int cost) {
		this.child = child;
		this.cost = cost;
	}
	public int getChild() {
		return this.child;
	}
	public int getCost() {
		return this.cost;
	}
}
public class Main {
	static int N;
	static ArrayList<Node>[] tree;
	static int next;
	static int res=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			tree[i] = new ArrayList<>();
		}
		int v,w,cost;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			tree[v].add(new Node(w,cost));
			tree[w].add(new Node(v,cost));
		}
		topologySort(1);
		topologySort(next);
		System.out.println(res);
	}
	
	public static void topologySort(int start) {
		Queue<Integer> q = new LinkedList<>();
		int degree[] = new int[N+1];
		boolean visited[] = new boolean[N+1];
		q.add(start);
		while(!q.isEmpty()) {
			int node = q.poll();
			visited[node] = true;
			for(Node n : tree[node]) {
				if (visited[n.getChild()]) continue;
				q.add(n.getChild());
				degree[n.getChild()]=degree[node]+n.getCost();
				if(res<degree[n.getChild()]) {
					res = degree[n.getChild()];
					next = n.getChild();
				}
			}
		}
	}
}




