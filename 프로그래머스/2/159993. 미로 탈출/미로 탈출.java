import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public int solution(String[] maps) {
        int answer = -1;
        
        int[] start = new int[2];
        int[] laber = new int[2];
        int[] exit = new int[2];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j) == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                if(maps[i].charAt(j) == 'L'){
                    laber[0] = i;
                    laber[1] = j;
                }
                if(maps[i].charAt(j) == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        int cnt1 = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0],start[1],0});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==laber[0]&&cur[1]==laber[1]){
                cnt1 = cur[2];
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length()) continue;
                if(maps[nx].charAt(ny)=='X')continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,cur[2]+1});
            }
        }
        if(cnt1 == -1) return answer;
        
        int cnt2 = -1;
        visited = new boolean[maps.length][maps[0].length()];
        q = new LinkedList<>();
        q.add(new int[]{laber[0],laber[1],0});
        visited[laber[0]][laber[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==exit[0]&&cur[1]==exit[1]){
                cnt2 = cur[2];
                break;
            }
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                
                if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length()) continue;
                if(maps[nx].charAt(ny)=='X')continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny,cur[2]+1});
            }
        }
        if(cnt2 == -1) return answer;
        
        answer = cnt1+cnt2;
        return answer;
    }
}