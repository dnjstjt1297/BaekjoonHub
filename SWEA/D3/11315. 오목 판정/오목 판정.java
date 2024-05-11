import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			
			String[] board = new String[N];
			
			for(int i=0; i<N;i++) {
				board[i] = sc.next();
			}

			boolean is_answer = false;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(board[i].charAt(j)=='o') {
						boolean is_five = fiveO(board,N,i,j);
						if(is_five) is_answer = true;
					}
				}
			}
			
			if(is_answer)
				System.out.println("#"+test_case+" YES");
			else
				System.out.println("#"+test_case+" NO");
				
		}
		
	}
	public static boolean fiveO(String[] board, int n, int x, int y) {
		
		int N = 0;
		int S = 0;
		int E = 0;
		int W = 0;
		int SE = 0;
		int SW = 0;
		int NE = 0;
		int NW = 0;
		
		for(int i=1;i<=4;i++) {
			if(x+i<n) {
				if(board[x+i].charAt(y) == 'o') {
					S++;
				}
			}
			if(x-i>=0) {
				if(board[x-i].charAt(y) == 'o') {
					N++;
				}
			}
			if(y+i<n) {
				if(board[x].charAt(y+i) == 'o') {
					E++;
				}
			}
			if(y-i>=0) {
				if(board[x].charAt(y-i) == 'o') {
					W++;
				}
			}
			if(x+i<n && y+i<n) {
				if(board[x+i].charAt(y+i) == 'o') {
					SE++;
				}
			}
			if(x+i<n && y-i>=0) {
				if(board[x+i].charAt(y-i) == 'o') {
					SW++;
				}
			}
			if(x-i>=0 && y+i<n) {
				if(board[x-i].charAt(y+i) == 'o') {
					NE++;
				}
			}
			if(x-i>=0 && y-i>=0) {
				if(board[x-i].charAt(y-i) == 'o') {
					NW++;
				}
			}
		}

		if(N==4||S==4||E==4||W==4||NE==4||NW==4||SE==4||SW==4) {
			return true;
		}
		return false;
	}
	
	
}