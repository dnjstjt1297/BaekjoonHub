import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

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
		int C =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1) C++; 
			}
		}
		boolean[][] visited = new boolean[N][M];
		int time = 0;

		while(C>0) {
			time++;
			bfs();
			int[][] arrCopy = new int[N][M];
			for(int i=0;i<N;i++) {
				arrCopy[i] = arr[i].clone();
			}
			for(int i=0; i<N;i++) {
				for(int j=0; j<M;j++) {
					int count =0;
					if(arr[i][j] == 2) continue;
					for(int k =0; k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx<0||nx>=N||ny<0||ny>=M) continue;
						if(arr[nx][ny]==2)
							count++;
					}
					if(count>=2) {
						arrCopy[i][j] = 2;
						if(arr[i][j] == 1)
							C--;
					}
				}
			}
			for(int i=0;i<N;i++) {
				arr[i] = arrCopy[i].clone();
			}
		}
		System.out.println(time);
	}
	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		
		q.add(new int[] {0,0});
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int x = node[0];
			int y = node[1];
			if(visited[x][y]) continue;
			visited[x][y] = true;
			arr[x][y] = 2;
			for(int k =0; k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if(nx<0||nx>=N||ny<0||ny>=M) continue;
				if(arr[nx][ny] == 0||arr[nx][ny]==2) {
					q.add(new int[] {nx,ny});
				}
			}
		}
		return 0;
	}
}
