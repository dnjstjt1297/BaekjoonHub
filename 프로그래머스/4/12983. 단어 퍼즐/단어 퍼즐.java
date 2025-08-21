import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
        int INF = 20001;
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (String s : strs) {
                int len = s.length();
                if (i - len >= 0 && t.substring(i-len, i).equals(s)) {
                    dp[i] = Math.min(dp[i], dp[i-len] + 1);
                }
            }
        }
        return dp[n] == INF ? -1 : dp[n];
    }
}