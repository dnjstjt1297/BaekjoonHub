import java.util.*;

class Solution {
    final int[] dx = new int[]{0,0,-1,1};
    final int[] dy = new int[]{1,-1,0,0};
    
    int[][] board;
    int n;
    
    public int solution(int[][] board) {
        
        this.board = board;
        this.n = board.length;
        
        return dijkstra();
    }
    
    public int dijkstra(){
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[3]-o2[3];
            }
        });
        
        pq.add(new int[]{0,0,-1,0});
        int[][][] visited = new int[n][n][4];
            
        for(int i =0; i<n; i++){
            for(int j=0;j<n;j++){
                for(int k = 0; k<4; k++){
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        visited[0][0][0] = 0;
        visited[0][0][1] = 0;
        visited[0][0][2] = 0;
        visited[0][0][3] = 0;
        
        
        int result = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            if(cur[0] == n-1 && cur[1] == n-1){
                result = Math.min(result, cur[3]);
            }
            
            
            for(int i = 0; i<4; i++){
                
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||ny<0||nx>=n||ny>=n||
                   board[nx][ny]==1) continue;
                
                
                if(cur[2]==-1 || cur[2]==i){
                    if(visited[nx][ny][i]<cur[3]+100) continue;
                    pq.add(new int[]{nx,ny,i,cur[3]+100});
                    visited[nx][ny][i] = cur[3]+100;
                    
                }
                else{
                    if(visited[nx][ny][i]<cur[3]+600) continue;
                    pq.add(new int[]{nx,ny,i,cur[3]+600});
                    visited[nx][ny][i] = cur[3]+600;
                }
            }
        }
        return result;
    }
}