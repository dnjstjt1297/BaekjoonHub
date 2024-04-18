import java.util.*;

class Solution {
    static int n;
    static int dp[][];
    public int solution(int[][] triangle) {
        int answer = 0;
        n = triangle.length-1;
        
        dp = new int[n+1][n+1];
        
        
        for(int j=0;j<=n;j++){
            Arrays.fill(dp[j],-1);
        }
        func(triangle,0,0);
        
        answer=dp[0][0];
        
        return answer;
    }
    public int func (int[][] triangle, int level, int idx) {
        if(level>n){
            return 0;
        }
        
        if(dp[level][idx]!=-1) return dp[level][idx];
        
        dp[level][idx] =
                triangle[level][idx]+Math.max(func(triangle,level+1,idx),func(triangle,level+1,idx+1));
        
        return dp[level][idx];
    }
}