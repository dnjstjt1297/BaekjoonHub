class Solution {
    static int INF = 1000000000;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = Integer.MAX_VALUE;
        int maxAlp = alp;
        int maxCop = cop;
        for(int[] p : problems){
            maxAlp = Math.max(maxAlp,p[0]);
            maxCop = Math.max(maxCop,p[1]);
        }
        
        if(alp>=maxAlp && cop>=maxCop) return 0;
        
        //alp와 cop에 따른 최단시간을 얻기위한 DP배열
        int[][] dp = new int[801][801];
        for(int i =0;i<dp.length;i++){
            for(int j= 0;j<dp[0].length;j++){
                dp[i][j] = INF;
            }
        }
        dp[alp][cop] = 0;
        for(int i = alp; i<dp.length; i++){
            for(int j = cop;j<dp[0].length; j++){
                
                if(i==alp&&j==cop) continue;
                
                if(i>=1){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                }
                if(j>=1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                }
                
                //문제마다 최단시간 갱신
                for(int[] p : problems){
                    int aReq = p[0];
                    int cReq = p[1];
                    int aRwd = p[2];
                    int cRwd = p[3];
                    int cost = p[4];
                    if(i-aRwd<aReq||j-cRwd<cReq) continue;              
                    dp[i][j] = Math.min(dp[i][j], dp[i-aRwd][j-cRwd]+cost);
                }
                if(i>=maxAlp && j>=maxCop){
                    answer = Math.min(dp[i][j],answer);
                }
            }
        }
        return answer;
    }
}