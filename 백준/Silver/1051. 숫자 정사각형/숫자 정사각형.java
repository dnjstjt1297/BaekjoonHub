import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int ans = 1;
        for(int i = 0; i<n;i++){
            for(int j=0; j<m; j++){
                for(int k= j+1; k<m;k++){
                    if(board[i][j] == board[i][k]){
                        int len = k-j;
                        if( i+len<n && board[i+len][j] == board[i+len][k] && board[i+len][j] == board[i][j]){
                            ans = Math.max(ans, (len+1)*(len+1));
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
