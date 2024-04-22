import java.util.*;

class Solution {
    
    static long[] dp;
    static long answer = 0;
    public long solution(int[] sequence) {
        
        int n = sequence.length;
        
        dp = new long[n];
        dp[0] = sequence[0];
        answer = Math.max(answer,Math.abs(dp[0]));
        long min = dp[0];
        long max = dp[0];
        for(int i=1;i<n;i++){
            int flag = i%2;
            if(flag==0)
                dp[i] = sequence[i]+dp[i-1];
            else
                dp[i] = -sequence[i]+dp[i-1];
            if(min>dp[i-1]) min = dp[i-1];
            if(max<dp[i-1]) max = dp[i-1];
            
            answer = Math.max(answer,Math.abs(dp[i]));
            answer = Math.max(answer,Math.abs(dp[i]-min));
            answer = Math.max(answer,Math.abs(dp[i]-max));
        }
        
        
        
        return answer;
    }
    
}