import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int s,n,k;
    static int r1,r2,c1,c2;
    static int[][] board;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        int m = (int) (Math.pow(n,s));
        board = new int[r2-r1+1][c2-c1+1];
        b = (n-k)/2;


        dq(s, m,0,0,m,m,false);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=r2-r1;i++){
            for(int j=0;j<=c2-c1;j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    public static void dq(int s, int m, int x1, int y1, int x2, int y2, boolean isBlack) {

        if (x2 <= r1 || x1 > r2 || y2 <= c1 || y1 > c2) return;
        if (m == 1 && isBlack) board[x1-r1][y1-c1] = 1;
        if(s==0) return;

        int next = m/n;
        int sb = b * next;
        int eb = (b + k) * next;

        for (int i = x1; i < x2; i += next) {
            for (int j = y1; j < y2; j += next) {
                if (sb <= i - x1 && i - x1 < eb && sb <= j - y1 && j - y1 < eb) {
                    dq(s-1, m/n, i, j, i+ next, j+next, true);
                } else {
                    dq(s-1, m/n, i, j, i + next, j + next, isBlack);
                }
            }
        }
    }

}
