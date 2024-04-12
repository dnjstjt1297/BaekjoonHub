import java.util.*;
class Solution {
    static final int MOD = 1000000007;
    public int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);

        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int k=0;k<money.length;k++){
            for(int i=money[k];i<=n;i++){
                if(i-money[k]<0) break;
                dp[i] +=dp[i-money[k]]%MOD;
            }
        }
        
        answer = dp[n];


        return answer;
    }
}