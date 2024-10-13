import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            int cnt = 0;
            boolean[] visited = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int[] result: results){
                    if(result[0] == cur && !visited[result[1]]) {
                        q.add(result[1]);
                        visited[result[1]] = true;
                        cnt++;
                    }
                }
            }
            
            visited = new boolean[n+1];
            q = new LinkedList<>();
            q.add(i);
            visited[i] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int[] result: results){
                    if(result[1] == cur && !visited[result[0]]) {
                        q.add(result[0]);
                        visited[result[0]] = true;
                        cnt++;
                    }
                }
            }
            if(cnt==n-1) answer++;
            
        }
        
        return answer;
    }
}