import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] rgbs = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            rgbs[i][0] = Integer.parseInt(st.nextToken());
            rgbs[i][1] = Integer.parseInt(st.nextToken());
            rgbs[i][2] = Integer.parseInt(st.nextToken());
        }
        if(N==2) {
            int res = rgbs[1][0]+Math.min(rgbs[2][1], rgbs[2][2]);
            res = Math.min(res, rgbs[1][1]+Math.min(rgbs[2][0], rgbs[2][2]));
            res = Math.min(res, rgbs[1][2]+Math.min(rgbs[2][0], rgbs[2][1]));
            System.out.println(res);
            return;
        }


        int[][] dpR = new int[N+1][3];
        dpR[2][0] = INF;
        dpR[2][1] = rgbs[2][1]+rgbs[1][0];
        dpR[2][2] = rgbs[2][2]+rgbs[1][0];
        int resR = runDP(rgbs, dpR,N,0);



        int[][] dpG = new int[N+1][3];
        dpG[2][1] = INF;
        dpG[2][0] = rgbs[2][0]+rgbs[1][1];
        dpG[2][2] = rgbs[2][2]+rgbs[1][1];
        int resG = runDP(rgbs, dpG,N,1);

        int[][] dpB = new int[N+1][3];
        dpB[2][2] = INF;
        dpB[2][0] = rgbs[2][0]+rgbs[1][2];
        dpB[2][1] = rgbs[2][1]+rgbs[1][2];
        int resB = runDP(rgbs, dpB,N,2);

        System.out.println(Math.min(resR, Math.min(resG, resB)));

    }

    public static int runDP(int[][] rgbs, int[][] dp, int N , int s){
        for(int i = 3; i <= N-1; i++) {
            dp[i][0] = Math.min(dp[i-1][2],dp[i-1][1]) + rgbs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + rgbs[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0]) + rgbs[i][2];
        }
        int result = 0;

        if(s == 0){
            result = dp[N-1][0]+ Math.min(rgbs[N][1], rgbs[N][2]);
            result = Math.min(result, dp[N-1][1]+rgbs[N][2]);
            result = Math.min(result, dp[N-1][2]+rgbs[N][1]);
        }
        else if(s == 1){
            result = dp[N-1][1]+ Math.min(rgbs[N][0], rgbs[N][2]);
            result = Math.min(result, dp[N-1][0]+rgbs[N][2]);
            result = Math.min(result, dp[N-1][2]+rgbs[N][0]);
        }
        else if(s == 2){
            result = dp[N-1][2]+ Math.min(rgbs[N][0], rgbs[N][1]);
            result = Math.min(result, dp[N-1][0]+rgbs[N][1]);
            result = Math.min(result, dp[N-1][1]+rgbs[N][0]);
        }


        return result;
    }
}