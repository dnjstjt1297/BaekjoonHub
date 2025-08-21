import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = bfs(n,computers);
        return answer;
    }
    
    public int bfs(int n, int[][] computers) {
        int result = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            result ++;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int cur = q.poll();
                visited[cur] = true;
                for(int j = 0; j<n; j++){
                    if(cur == j) continue;
                    if(computers[cur][j] == 1 && !visited[j]){
                        q.add(j);
                    }
                }
            }
        }
        return result;
    }
}