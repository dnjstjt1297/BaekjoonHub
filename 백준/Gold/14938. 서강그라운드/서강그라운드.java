import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = 1000000007;
                if(i == j) dp[i][j] = 0;
            }
        }

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken())-1;
            int distance = Integer.parseInt(st.nextToken());
            dp[v][w] = distance;
            dp[w][v] = distance;
        }

        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }


        int ans = 0;
        for(int i = 0;i<n;i++) {
            int sum = 0;
            for(int j = 0;j<n;j++) {
                if(dp[i][j]<=m) sum+=arr[j];
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);

    }
}