import java.util.*;
class Solution {
    int MOD = 1000000007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        
        dp[1][1] = 1;
        
        for(int i =0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1&&j==1) continue;
                if(dp[i][j]!=-1){
                    if(dp[i-1][j] != -1 && dp[i][j-1] != -1) dp[i][j] = (dp[i-1][j]+dp[i][j-1])%MOD;
                    else if(dp[i-1][j] != -1) dp[i][j] = dp[i-1][j];
                    else if(dp[i][j-1] != -1) dp[i][j] = dp[i][j-1];
                }
                
            }
        }
        
        
        answer = dp[n][m];
        
        return answer;
    }
}