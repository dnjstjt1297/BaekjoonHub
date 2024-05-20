class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][]dp = new int[100001][2];
        for(int i=0;i<=100000;i++){
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i=1;i<=20;i++){
            dp[2*i][0] = 1;
            dp[2*i][1] = 0;
        }
        for(int i=1;i<=20;i++){
            dp[3*i][0] = 1;
            dp[3*i][1] = 0;
        }
        for(int i=1;i<=20;i++){
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        dp[50][0] = 1;
        dp[50][1] = 1;
        
        for(int i=1; i<=target;i++){
            if(dp[i][0] != Integer.MAX_VALUE) continue;
            
            int idx = 0;
            for(int j=1; j<=20; j++){
                if(i-j<=0) break;
                if(dp[i][0]>dp[i-j][0]+1){
                    dp[i][0] = dp[i-j][0]+1;
                    idx = j;
                }
            }
            if(i>=50){
                if(dp[i][0]>dp[i-50][0]+1){
                    dp[i][0] = dp[i-50][0]+1;
                    idx = 50;
                }
            }
            for(int j=1; j<=20;j++){
                if(i-2*j<=0) break;
                if(dp[i][0]>dp[i-2*j][0]+1){
                    dp[i][0] = dp[i-2*j][0]+1;
                    idx = 2*j;
                }
            }
            for(int j=1; j<=20;j++){
                if(i-3*j<=0) break;
                if(dp[i][0]>dp[i-3*j][0]+1){
                    dp[i][0] = dp[i-3*j][0]+1;
                    idx = 3*j;
                }
            }
            
            if(idx<=20||idx==50){
                for(int j=1;j<=20;j++){
                    if(i-j<=0) break;
                    if(dp[i][0] == dp[i-j][0]+1) 
                        dp[i][1] = Math.max(dp[i][1],dp[i-j][1]+1);
                }
                if(i>=50){
                    if(dp[i][0] == dp[i-50][0]+1)
                        dp[i][1] = Math.max(dp[i][1],dp[i-50][1]+1);
                }
            }
            else{
                for(int j=1;j<=20;j++){
                    if(i-2*j<=0) break;
                    if(dp[i][0] == dp[i-2*j][0]+1)
                        dp[i][1] = Math.max(dp[i][1],dp[i-2*j][1]);
                }
                for(int j=1;j<=20;j++){
                    if(i-3*j<=0) break;
                    if(dp[i][0] == dp[i-3*j][0]+1)
                        dp[i][1] = Math.max(dp[i][1],dp[i-3*j][1]);
                }
            }
        }
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        return answer;
    }
}