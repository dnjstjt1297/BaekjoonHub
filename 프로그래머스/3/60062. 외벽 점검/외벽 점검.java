import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        boolean[] visited = new boolean[weak.length];
        dfs(n,weak,dist,visited, dist.length-1,0);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    
    public void dfs(int n, int[] weak, int[] dist, boolean[] visited, int Didx, int cnt){
        boolean isAllInspaction = true;
        for(boolean e : visited) if(!e) isAllInspaction = false;
        if(isAllInspaction) answer = Math.min(cnt,answer);
        
        if(Didx==-1||isAllInspaction||cnt>=answer) return;
        
        for(int i=0;i<weak.length;i++){
            if(visited[i]) continue;
            
            ArrayList<Integer> visitedList = new ArrayList<>();
            for(int j=0;j<weak.length;j++){
                int curIdx = i+j;
                if(i+j>=weak.length) curIdx-=weak.length;
                if(visited[curIdx]) continue;
                int d = weak[curIdx]-weak[i];
                if(d<0) d = n+d;
                if(d>dist[Didx]) break;
                visited[curIdx] = true;
                visitedList.add(curIdx);
            }
            dfs(n,weak,dist,visited,Didx-1,cnt+1);
            for(Integer e : visitedList) visited[e] = false;
        }
    }
}

