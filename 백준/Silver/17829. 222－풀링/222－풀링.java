import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dq(board,N));
		
	}
	
	public static int dq(int[][] board, int N) {
		
		while(N>1) {
			int[][] tmp = new int[N/2][N/2];
			
			
			for(int i=0;i<N/2;i++) {
				for(int j=0;j<N/2;j++) {
					tmp[i][j] = findTwoMax(board,2*i,2*j);
				}
			}
			N/=2;
			board = tmp;
			
		}
		
		return board[0][0];
	}
	
	public static int findTwoMax(int[][] board, int sx, int sy) {
		int mx = sx, my = sy;
		
		for(int i = sx; i<sx+2;i++) {
			for(int j = sy; j<sy+2;j++) {
				if(board[mx][my]<board[i][j]) {
					mx = i; my = j;
				}
			}
		}
		
		int result = -10000;
		
		for(int i = sx; i<sx+2;i++) {
			for(int j = sy; j<sy+2;j++) {
				if(i!=mx || j!=my) {
					if(result<board[i][j]) result = board[i][j];
				}
			}
		}
		
		return result;
	}
	
}
