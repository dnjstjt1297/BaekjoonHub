import java.util.*;

class Solution {
    
    int max = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        
        return max;
    }
    public void dfs(int k, int[][] dungeons, int cnt){
        if(k<0) return;
        
        max = Math.max(cnt, max);
        for(int i = 0; i< dungeons.length; i++){
            if(visited[i]) continue;
            
            if(k>=dungeons[i][0]){
                if(k>=dungeons[i][1]){
                    visited[i] = true;
                    dfs(k-dungeons[i][1], dungeons, cnt+1);
                    visited[i] = false;
                }
            }
            
        }
    }
}