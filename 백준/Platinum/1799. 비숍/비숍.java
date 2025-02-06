import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static int max;
    static int[] a, b;
    static int[] ans = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        a = new int[2*N-1];
        b = new int[2*N-1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0,0);
        dfs(0,1,0,1);
        System.out.println(ans[0]+ans[1]);
    }

    public static void dfs(int x, int y, int cnt, int color){

        if(y>=N) {
            x++;
            if(y%2==0) y=1;
            else y =0;
        }
        if(x==N){
            ans[color] = Math.max(ans[color], cnt);
            return;
        }

        if(board[x][y] == 1 && a[x+y]==0 && b[y-x+N-1]==0){
            a[x+y] = 1; b[y-x+N-1] = 1;
            dfs(x,y+2, cnt+1, color);
            a[x+y] = 0; b[y-x+N-1] = 0;
        }
        dfs(x,y+2,cnt, color);
    }
}