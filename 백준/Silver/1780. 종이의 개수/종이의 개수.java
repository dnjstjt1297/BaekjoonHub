import java.util.*;
import java.io.*;

public class Main{
	static int[] result = new int[3];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		dq(board,0,0,N);
		for(int i=0;i<3;i++) System.out.println(result[i]);
	}
	
	public static void dq(int[][] board, int sx, int sy, int N) {
		if(findEquals(board,sx,sy,N)) {
			result[board[sx][sy]+1]++;
			return;
		}
		
		int k = N/3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				dq(board,sx+i*k,sy+j*k,k);
			}
		}
		
	}
	
	public static boolean findEquals(int[][] board, int sx, int sy, int N) {
		int tmp = board[sx][sy];
		for(int i=sx;i<sx+N;i++) {
			for(int j=sy;j<sy+N;j++) {
				if(tmp!= board[i][j]) return false;
			}
		}
		
		return true;
	}
}
