import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = arr.length;

        if(N == 1){
            System.out.println(0);
            return;
        }
        else if(N == 2){
            System.out.println(2);
            return;
        }

        int[][][] dp = new int[N][5][5]; //0: idx, 1:right, 2:left
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][arr[0]][0] = 2;
        dp[0][0][arr[0]] = 2;
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<N-1;i++) {
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(dp[i-1][j][k]!=Integer.MAX_VALUE) {
                        dp[i][arr[i]][k] = Math.min(dp[i][arr[i]][k], dp[i-1][j][k]+findScore(j,arr[i]));
                        dp[i][j][arr[i]] = Math.min(dp[i][j][arr[i]], dp[i-1][j][k]+findScore(k,arr[i]));
                        if(i==N-2){
                            answer = Math.min(answer,dp[i][arr[i]][k]);
                            answer = Math.min(answer,dp[i][j][arr[i]]);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }

    public static int findScore(int loc, int next) {
        if(loc==next) return 1;
        if(loc==0) return 2;
        else if(Math.abs(loc-next)==2) return 4;
        else return 3;
    }
}

