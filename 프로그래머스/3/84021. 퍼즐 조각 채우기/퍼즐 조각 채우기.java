import java.util.*;

class Solution {
    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};
    
    public int solution(int[][] gameBoard, int[][] table) {
        int n = gameBoard.length;
        
        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> blocks = new ArrayList<>();
        
        boolean[][] visited = new boolean[n][n];
        
        // 1. 빈칸 추출
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(gameBoard[i][j] == 0 && !visited[i][j]){
                    blanks.add(bfs(i,j,gameBoard,visited,0));
                }
            }
        }
        
        visited = new boolean[n][n];
        
        // 2. 블록 추출
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(table[i][j] == 1 && !visited[i][j]){
                    blocks.add(bfs(i,j,table,visited,1));
                }
            }
        }
        
        int answer = 0;
        boolean[] used = new boolean[blocks.size()];
        
        // 3. 매칭
        for(List<int[]> blank : blanks){
            for(int i=0;i<blocks.size();i++){
                if(used[i]) continue;
                
                List<int[]> block = blocks.get(i);
                
                if(match(blank, block)){
                    used[i] = true;
                    answer += blank.size();
                    break;
                }
            }
        }
        
        return answer;
    }
    
    // BFS로 도형 추출
    private List<int[]> bfs(int x, int y, int[][] map, boolean[][] visited, int target){
        int n = map.length;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        
        q.add(new int[]{x,y});
        visited[x][y] = true;
        list.add(new int[]{x,y});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != target) continue;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
                list.add(new int[]{nx,ny});
            }
        }
        
        return normalize(list);
    }
    
    // 좌표 정규화 (0,0 기준)
    private List<int[]> normalize(List<int[]> list){
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int[] p : list){
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        
        List<int[]> result = new ArrayList<>();
        for(int[] p : list){
            result.add(new int[]{p[0]-minX, p[1]-minY});
        }
        
        result.sort((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        return result;
    }
    
    // 90도 회전
    private List<int[]> rotate(List<int[]> list){
        List<int[]> result = new ArrayList<>();
        
        for(int[] p : list){
            result.add(new int[]{p[1], -p[0]});
        }
        
        return normalize(result);
    }
    
    // 도형 비교
    private boolean match(List<int[]> blank, List<int[]> block){
        if(blank.size() != block.size()) return false;
        
        for(int i=0;i<4;i++){
            boolean same = true;
            
            for(int j=0;j<blank.size();j++){
                if(blank.get(j)[0] != block.get(j)[0] ||
                   blank.get(j)[1] != block.get(j)[1]){
                    same = false;
                    break;
                }
            }
            
            if(same) return true;
            
            block = rotate(block);
        }
        
        return false;
    }
}