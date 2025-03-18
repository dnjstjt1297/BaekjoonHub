import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for(int k=1; k<=K;k++){
            for(int i=1;i<=N;i++){
                dp[i][k] = dp[i-1][k];
                if(k-arr[i][0]>=0){
                    dp[i][k] = Math.max(dp[i-1][k], arr[i][1]+ dp[i-1][k-arr[i][0]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}