import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t,w;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[t];
        for(int i=0;i<t;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        int[][][] dp = new int[1001][3][31];

        if(arr[0] == 1) dp[0][1][0]++;
        if(arr[0] == 2) dp[0][2][1]++;
        ans = Math.max(ans, dp[0][1][0]);
        ans = Math.max(ans, dp[0][2][1]);

        for (int i = 1; i < t; i++) {
            for (int j = 0; j <= w; j++) {
                if (arr[i] == 1) {
                    if (j == 0) {
                        dp[i][1][j] = dp[i - 1][1][j] + 1;
                    } else {
                        dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][2][j - 1]) + 1;
                        dp[i][2][j] = Math.max(dp[i - 1][2][j], dp[i - 1][1][j - 1]);
                    }
                } else { // arr[i] == 2
                    if (j == 0) {
                        dp[i][1][j] = dp[i - 1][1][j];
                    } else {
                        dp[i][2][j] = Math.max(dp[i - 1][2][j], dp[i - 1][1][j - 1]) + 1;
                        dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][2][j - 1]);
                    }
                }

                ans = Math.max(ans, Math.max(dp[i][1][j], dp[i][2][j]));
            }
        }
        System.out.println(ans);
    }

    //f(n,1,f) = f(n-1,2,f-1)+f(n-1,1,f);
}
