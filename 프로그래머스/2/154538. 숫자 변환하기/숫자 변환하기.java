import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[1000001];
        Arrays.fill(dp,1000001);
        dp[x] = 0;
        for(int i=x+1;i<1000001;i++){
            if(i-n>=0){
                dp[i] = Math.min(dp[i],dp[i-n]+1);
            }
            if(i%2==0){
                dp[i] = Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
                dp[i] = Math.min(dp[i],dp[i/3]+1);
            }
        }
        if(dp[y]==1000001) answer = -1;
        else answer = dp[y];
        
        return answer;
    }
}