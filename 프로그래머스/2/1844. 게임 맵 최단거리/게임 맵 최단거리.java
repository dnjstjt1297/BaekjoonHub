import java.util.*;

class Solution {
    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,1,-1};
    static int INF = 10001;
    
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        
        
        int[][] inDegree = new int[n][m];
        for(int i = 0; i<n;i++){
            Arrays.fill(inDegree[i], INF);
        }
        
        
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        
        q.add(new int[]{0,0,1});
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            
            if(cur[0] == n-1 && cur[1] == m-1){
                answer = cur[2];    
                break;
            }
            
            for(int i = 0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0 || ny<0 || nx>=n || ny >=m) continue;
                if(maps[nx][ny] == 0) continue;
                if(inDegree[nx][ny]>cur[2]+1){
                    inDegree[nx][ny] = cur[2]+1;
                    q.add(new int[]{nx, ny, cur[2]+1});
                }
            }
            
        }
        
        
        return answer;
    }
}