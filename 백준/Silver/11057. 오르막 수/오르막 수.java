import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][10];

        dp[1][0] = 10;
        dp[1][1] = 9;
        dp[1][2] = 8;
        dp[1][3] = 7;
        dp[1][4] = 6;
        dp[1][5] = 5;
        dp[1][6] = 4;
        dp[1][7] = 3;
        dp[1][8] = 2;
        dp[1][9] = 1;


        for(int i = 2; i <= n; i++) {
            for(int j = 0; j<10; j++){
                dp[i][j] = 0;
                for(int k = j; k < 10; k++){
                    dp[i][j] = (dp[i][j] + dp[i-1][k])%10007;
                }
            }
        }
        System.out.println(dp[n][0]);
    }
}
