import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] apps = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            apps[i] = Integer.parseInt(st.nextToken());
        }

        int[] bytes = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            bytes[i] = Integer.parseInt(st.nextToken());
        }

        int maxCost = 10000;
        int[][] dp = new int[n + 1][maxCost + 1];
        int res = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxCost; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - bytes[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - bytes[i]] + apps[i]);
                }
                if (dp[i][j] >= m) {
                    res = Math.min(res, j);
                }
            }
        }

        System.out.println(res);
    }
}
