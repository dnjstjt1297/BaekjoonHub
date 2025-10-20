import java.util.*;

class Solution {

    ArrayList<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i< edge.length; i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        visited[1] = true;
        
        int[] dist = new int[n+1];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int next : graph[cur[0]]){
                if(visited[next]) continue;
                visited[next] = true;
                q.add(new int[]{next,cur[1]+1});
                dist[cur[1]+1]++;
            }
        }
        
        for(int i = 0; i<=n; i++){
            if(dist[i]!=0) answer = dist[i];
        }
        
        return answer;
    }
}