import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

class Node{
	private int x;
	private int y;
	private int cost;
	private int boom;
	public Node(int x,int y,int cost, int boom) {
		this.x = x;
		this.y = y;
		this.cost = cost;
		this.boom = boom;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getCost() {
		return cost;
	}
	public int getBoom() {
		return boom;
	}
}

public class Main {
	static final int dx[] = {0,0,1,-1};
	static final int dy[] = {1,-1,0,0};
	static int N,M;
	static int[][] arr;
	static int res = -1;
	static boolean visited[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N;i++) {
			String input = br.readLine();
			for(int j=0; j<M;j++) {
				arr[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}
		
		bfs();
		System.out.println(res);
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1,0));
		boolean visited[][][] = new boolean[2][N][M];
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.getX();
			int y = node.getY();
			if(x == N-1&&y==M-1) {
				res = node.getCost();
				return;
			}
			
			for(int i=0;i<4;i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				if(nextX<0|| nextX>=N || nextY<0|| nextY>=M) continue;
				
				if(arr[nextX][nextY]==0 && !visited[node.getBoom()][nextX][nextY]!=false) {
					visited[node.getBoom()][nextX][nextY] = true;
					q.add(new Node(nextX,nextY,node.getCost()+1,node.getBoom()));
				}
				else {
					if(node.getBoom()==0 && !visited[node.getBoom()][nextX][nextY]) {
						visited[node.getBoom()][nextX][nextY] = true;
						q.add(new Node(nextX,nextY,node.getCost()+1,node.getBoom()+1));
					}
				}
				
			}
		}
	}
}
