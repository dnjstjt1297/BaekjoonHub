
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n-1; i++) {
            dp[i][i] = true;
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }
        dp[n-1][n-1] = true;

        for(int i = n-2; i >=0; i--){
            for(int j =i+1; j<n; j++){
                if(arr[i] == arr[j] && dp[i+1][j-1])
                    dp[i][j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(dp[a-1][b-1]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.println(sb);

    }
}