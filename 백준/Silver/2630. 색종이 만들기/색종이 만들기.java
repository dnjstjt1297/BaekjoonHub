
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int numOfWhite = 0;
    public static int numOfBlue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dq(board,0,N,0,N);
        System.out.println(numOfWhite);
        System.out.println(numOfBlue);

    }
    public  static void dq(int[][] board, int sx, int ex, int sy, int ey) {
        if(sx>ex || sy>ey) return;
        boolean isWhite = true;
        boolean isBlue = true;
        for(int i = sx;i<ex;i++) {
            for(int j = sy;j<ey;j++) {
                if(board[i][j] == 1) isWhite = false;
                else if(board[i][j] == 0) isBlue = false;
            }
        }
        if(isWhite){
            numOfWhite++;
            return;
        }
        if(isBlue){
            numOfBlue++;
            return;
        }

        int xmid = (ex + sx)/2;
        int ymid = (ey + sy)/2;

        dq(board, sx, xmid, sy, ymid);
        dq(board, xmid, ex, sy, ymid);
        dq(board, xmid, ex, ymid, ey);
        dq(board, sx, xmid, ymid, ey);

    }
}
