import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

public class Main {
	static int R,C;
	static String[] board;
	static int res = 1;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new String[R];
		for(int i=0;i<R;i++) {
			board[i] = br.readLine();
		}
		visited = new boolean['Z'-'A'+1];
		dfs(0,0,0);
		System.out.println(res);
	}
	public static void dfs(int x, int y, int cnt) {
		if(visited[board[y].charAt(x)-'A']) {
			res = Math.max(res, cnt);
			return;
		}
		visited[board[y].charAt(x)-'A'] = true;
		if(x!=0) dfs(x-1,y,cnt+1);
		if(y!=0) dfs(x,y-1,cnt+1);
		if(x!=C-1) dfs(x+1,y,cnt+1);
		if(y!=R-1) dfs(x,y+1,cnt+1);
		visited[board[y].charAt(x)-'A'] = false;
	}
}