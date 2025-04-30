import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[k+1][n+1];

        for(int i = 0; i<=n; i++){
            dp[1][i] = 1;
        }

        for(int i = 2; i<=k ; i++){
            for(int j = 0; j<=n; j++){
                for(int p = 0; p<=j; p++){
                    dp[i][j] = (dp[i][j]+dp[i-1][j-p])%1000000000;
                }
            }
        }
        System.out.println(dp[k][n]);

    }
    //f(1,n) = 1;
    //f(2,n) = n+1;
    //f(3,n) = f(2,n) + f(2,n-1) + f(2,n-2) ... f(2,0)
}
