class Solution {
    final int[] dx = {-1,1,0,0};
    final int[] dy = {0,0,-1,1};
    
    int srx, sry, sbx, sby;
    int erx, ery, ebx, eby;
    int answer = Integer.MAX_VALUE;
    boolean[][] visitedR, visitedB;  // 방문 여부 체크 배열
    
    public int solution(int[][] maze) {
        setInit(maze);
        
        // 방문 배열 초기화
        visitedR = new boolean[maze.length][maze[0].length];
        visitedB = new boolean[maze.length][maze[0].length];
        
        dfs(maze, srx, sry, sbx, sby, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void setInit(int[][] maze) {
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                if(maze[i][j] == 1) {
                    srx = i;
                    sry = j;
                    maze[i][j] = 0;
                } else if(maze[i][j] == 2) {
                    sbx = i;
                    sby = j;
                    maze[i][j] = 0;
                } else if(maze[i][j] == 3) {
                    erx = i;
                    ery = j;
                    maze[i][j] = 0;
                } else if(maze[i][j] == 4) {
                    ebx = i;
                    eby = j;
                    maze[i][j] = 0;
                }
            }
        }
    }
    
    public void dfs(int[][] maze, int rx, int ry, int bx, int by, int cnt) {
        if(rx == erx && ry == ery && bx == ebx && by == eby) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        if(visitedR[rx][ry] && visitedB[bx][by]) return;
        
        visitedR[rx][ry] = true;
        visitedB[bx][by] = true;

        if(rx == erx && ry == ery) {  // 빨간 로봇이 도착한 경우 파란 로봇만 움직임
            for(int i = 0; i < 4; i++) {
                int nbx = bx + dx[i];
                int nby = by + dy[i];
                
                if(nbx < 0 || nby < 0 || nbx >= maze.length || nby >= maze[0].length) continue;
                if(maze[nbx][nby] == 5 || visitedB[nbx][nby]) continue;  // 벽이거나 방문한 곳
                if(nbx == erx && nby == ery) continue;
                dfs(maze, rx, ry, nbx, nby, cnt + 1);
            }
        } else if(bx == ebx && by == eby) {  // 파란 로봇이 도착한 경우 빨간 로봇만 움직임
            for(int i = 0; i < 4; i++) {
                int nrx = rx + dx[i];
                int nry = ry + dy[i];
                
                if(nrx < 0 || nry < 0 || nrx >= maze.length || nry >= maze[0].length) continue;
                if(maze[nrx][nry] == 5 || visitedR[nrx][nry]) continue;  // 벽이거나 방문한 곳
                if(nrx == ebx && nry == eby) continue;
                dfs(maze, nrx, nry, bx, by, cnt + 1);
            }
        } else {  // 둘 다 움직여야 하는 경우
            for(int i = 0; i < 4; i++) {
                int nrx = rx + dx[i];
                int nry = ry + dy[i];
                if(nrx < 0 || nry < 0 || nrx >= maze.length || nry >= maze[0].length) continue;
                if(maze[nrx][nry] == 5 || visitedR[nrx][nry]) continue;

                for(int j = 0; j < 4; j++) {
                    int nbx = bx + dx[j];
                    int nby = by + dy[j];
                    if(nbx < 0 || nby < 0 || nbx >= maze.length || nby >= maze[0].length) continue;
                    if(maze[nbx][nby] == 5 || visitedB[nbx][nby]) continue;
                    if(nrx == nbx && nry == nby) continue;  // 겹치지 않도록 방지
                    if(nrx == bx && nry == by && rx == nbx && ry == nby) continue;
                    dfs(maze, nrx, nry, nbx, nby, cnt + 1);
                }
            }
        }

        visitedR[rx][ry] = false;
        visitedB[bx][by] = false;
    }
}
