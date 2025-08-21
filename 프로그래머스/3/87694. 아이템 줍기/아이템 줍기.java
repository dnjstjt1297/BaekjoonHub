import java.util.*;
class Solution {
    int[] dx = new int[]{0,-1,0,1};
    int[] dy = new int[]{-1,0,1,0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int answer = Integer.MAX_VALUE;
        int N = 52;
        
        int[][] board = new int[N][N];
        ArrayList<Integer>[] graph = new ArrayList[N*N];
        for(int i = 0; i<N*N; i++){
            graph[i] = new ArrayList<>();
            
        }
        
        for(int[] r : rectangle){
            for(int i = r[0]; i<r[2]; i++){
                boolean isEdge1 = true;
                boolean isEdge2 = true;
                for(int[] c : rectangle){
                    if(r==c) continue;
                    
                    if(c[1] < r[1] && c[3]> r[1]){
                        if((c[0]<i && c[2]>i) || (c[0]<i+1 && c[2]>i+1))
                            isEdge1 = false;
                        if(c[0]==i && c[2]==i+1)
                            isEdge1 = false;
                    }
                    if(c[1] < r[3] && c[3]> r[3]){
                        if((c[0]<i && c[2]>i) || (c[0]<i+1 && c[2]>i+1))
                            isEdge2 = false;
                        if(c[0]==i && c[2]==i+1)
                            isEdge2 = false;
                    }
                    
                }
                if(isEdge1){
                    graph[i*N+r[1]].add((i+1)*N+r[1]);
                    graph[(i+1)*N+r[1]].add(i*N+r[1]);
                }
                if(isEdge2){
                    graph[i*N+r[3]].add((i+1)*N+r[3]);
                    graph[(i+1)*N+r[3]].add(i*N+r[3]);    
                }
            }
            
            for(int i = r[1]; i<r[3]; i++){
                boolean isEdge1 = true;
                boolean isEdge2 = true;
                for(int[] c : rectangle){
                    if(r==c) continue;
                    if(c[0] < r[0] && c[2]> r[0]){
                        if((c[1]< i && c[3]>i) || (c[1]<i+1 && c[3]>i+1))
                            isEdge1 = false;
                        if(c[1] == i && c[3] == i+1)
                            isEdge1 = false;
                    }
                    if(c[0] < r[2] && c[2]> r[2]){
                        if((c[1]<i && c[3]>i) || (c[1]<i+1 && c[3]>i+1))
                            isEdge2 = false;
                        if(c[1]==i && c[3]==i+1)
                            isEdge2 = false;
                    }
                    
                }
                if(isEdge1){
                    graph[r[0]*N+i].add(r[0]*N+i+1);
                    graph[r[0]*N+i+1].add(r[0]*N+i);
                }
                if(isEdge2){
                    graph[r[2]*N+i].add(r[2]*N+i+1);
                    graph[r[2]*N+i+1].add(r[2]*N+i);
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY, 0});
        boolean[][] visited = new boolean[N][N];
        visited[characterX][characterY] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0]==itemX && cur[1] == itemY){
                answer = Math.min(answer,cur[2]);
                continue;
            }
            for(int e : graph[cur[0]*N+cur[1]]){
                int x = e/N;
                int y = e%N;
                
                if(visited[x][y])
                    continue;
                
                visited[x][y] = true;
                q.add(new int[]{x, y, cur[2]+1});
                
            }
            
        }
        

        return answer;
    }

}