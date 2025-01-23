import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int N = arr.length;
        boolean[][] dp = new boolean[N][N];

        for(int i = 0; i<N-1; i++){
            dp[i][i] = true;
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }
        dp[N-1][N-1] = true;
        for(int i = N-2; i >=0; i--){
            for(int j =i+1; j<N; j++){
                if(arr[i] == arr[j] && dp[i+1][j-1])
                    dp[i][j] = true;
            }
        }

        int[] dp2 = new int[N+1];
        dp2[0] = 0;
        for(int i = 1; i<=N; i++) {
            dp2[i] = Integer.MAX_VALUE;
            for(int j = 1; j<=i; j++){
                if(dp[j-1][i-1]){
                    dp2[i] = Math.min(dp2[i],dp2[j-1]+1);
                }
            }
        }
        System.out.println(dp2[N]);
    }
}