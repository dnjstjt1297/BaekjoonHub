import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Long.MAX_VALUE;
                if(i == j) dp[i][j] = 0;
            }
        }

        for(int i = 0; i<n-1;i++){
            dp[i][i+1] = (long) arr[i][0] *arr[i][1]*arr[i+1][1];
        }


        for(int j=2; j<n; j++){
            for(int i = 0; i<n-j;i++){
                for(int k = 0; k<j; k++){
                    dp[i][i+j] = Math.min(dp[i][i+j], dp[i][i+k]+dp[i+k+1][i+j]+ (long) arr[i][0] *arr[i+k][1]*arr[i+j][1] );
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}