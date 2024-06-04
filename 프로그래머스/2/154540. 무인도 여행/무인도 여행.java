import java.util.*;
class Solution {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public int[] solution(String[] maps) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList<>();
        
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j)>='1' && maps[i].charAt(j)<='9'){
                    if(visited[i][j]) continue;
                    
                    int sum = 0;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        if(visited[cur[0]][cur[1]]) continue;
                        visited[cur[0]][cur[1]] = true;
                        sum+=maps[cur[0]].charAt(cur[1])-'0';
                        for(int k=0;k<4;k++){
                            int nx = cur[0]+dx[k];
                            int ny = cur[1]+dy[k];
                            if(nx<0||ny<0||nx>=maps.length||ny>=maps[0].length()) continue;
                            if(maps[nx].charAt(ny)=='X') continue;
                            
                            q.add(new int[]{nx,ny});
                        }
                    }
                    result.add(sum);
                }
            }
        }
        
        Collections.sort(result);
        if(result.isEmpty())result.add(-1);
        answer = new int[result.size()];
        for(int i =0;i<answer.length;i++) answer[i] = result.get(i);
        
        return answer;
    }
}