import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int LEN = 9;
    static int[][] board = new int[LEN][LEN];
    static boolean[][] xv = new boolean[LEN][LEN+1];
    static boolean[][] yv = new boolean[LEN][LEN+1];
    static boolean[][] mv = new boolean[LEN][LEN+1];
    static int[][] result = null;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[LEN][LEN];

        for(int i = 0; i< LEN; i++){
            st = new StringTokenizer(reader.readLine());
            for(int j = 0; j< LEN; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                xv[i][board[i][j]] = true;
                yv[j][board[i][j]] = true;
                int m;
                if(i <= 2 && j <= 2) m = 0;
                else if(i <= 2 && j <= 5) m = 1;
                else if(i <= 2) m = 2;
                else if(i <= 5 && j <= 2) m = 3;
                else if(i <= 5 && j <= 5) m = 4;
                else if(i <= 5) m = 5;
                else if(j <= 2) m = 6;
                else if(j <= 5) m = 7;
                else m = 8;
                mv[m][board[i][j]] = true;
            }
        }
        dfs(0);
        for(int i = 0; i< LEN; i++){
            for(int j = 0; j< LEN; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int depth){
        if(result != null) return;
        if(depth == LEN * LEN){
            result = new int[LEN][LEN];
            for(int i = 0; i< LEN; i++) result[i] = board[i].clone();
            return;
        }
        int x = depth / LEN;
        int y = depth % LEN;
        if(board[x][y] != 0){
            dfs(depth+1);
            return;
        }

        int m;
        if(x <= 2 && y <= 2) m = 0;
        else if(x <= 2 && y <= 5) m = 1;
        else if(x <= 2) m = 2;
        else if(x <= 5 && y <= 2) m = 3;
        else if(x <= 5 && y <= 5) m = 4;
        else if(x <= 5) m = 5;
        else if(y <= 2) m = 6;
        else if(y <= 5) m = 7;
        else m = 8;

        for(int i = 1; i<=LEN; i++){
            if(xv[x][i]) continue;
            if(yv[y][i]) continue;
            if(mv[m][i]) continue;
            xv[x][i] = true;
            yv[y][i] = true;
            mv[m][i] = true;
            board[x][y] = i;
            dfs(depth+1);
            board[x][y] = 0;
            xv[x][i] = false;
            yv[y][i] = false;
            mv[m][i] = false;
        }
    }
}