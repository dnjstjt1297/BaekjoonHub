import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public int solution(String[] board) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        
        int x =0;
        int y =0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == 'R'){
                    q.add(new int[]{i,j,0,0});
                }
                else if(board[i].charAt(j) == 'G'){
                    x = i;
                    y = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            if(cur[0]==x && cur[1]==y){
                answer = cur[3];
                break;
            }
            for(int i=0;i<4;i++){
                int nx = cur[0];
                int ny = cur[1];
                int dist = 0;
                while(true){
                    if(nx<0||ny<0||nx>=board.length||ny>=board[0].length()||board[nx].charAt(ny)=='D'){
                        dist--;
                        nx-=dx[i];
                        ny-=dy[i];
                        break;
                    }
                    nx+=dx[i];
                    ny+=dy[i];
                    dist++;
                }
                if(visited[nx][ny])continue;
                q.add(new int[]{nx,ny,cur[2]+dist,cur[3]+1});
            }
            
        }
        
        return answer;
    }
}