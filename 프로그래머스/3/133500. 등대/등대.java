import java.util.*;


class Solution {
    
    public int solution(int n, int[][] lighthouse) {
        
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<n-1;i++){
            int v = lighthouse[i][0];
            int w = lighthouse[i][1];
            graph[v].add(w);
            graph[w].add(v);
        }
        int answer =0;
        
        int head = 1;
        
        /**
        *level이 가장 높은 leaf노드들 찾기
        */
        Queue<Integer> q = new LinkedList<>();
        int[] levels = new int[n+1];
        q.add(head);
        Arrays.fill(levels,Integer.MAX_VALUE);
        levels[head] = 0;
        int maxLevel = 0;
        while(!q.isEmpty()){
            int cur = q.poll();    
            boolean is_leaf = true;
            for(int next: graph[cur]){
                if(levels[next]>levels[cur]+1){
                    levels[next]= levels[cur]+1;
                    q.add(next);
                    is_leaf = false;
                }
            }
            if(is_leaf){
                maxLevel = Math.max(maxLevel,levels[cur]);
            }
        }
        /**
        * 1. 가장 높은 level을 가진 leaf노드의 부모 찾기
        * 2. leaf노드와 부모노드 visited추가해 graph에서 지우기
        * 3. 부모 노드 수만큼 결과 1증가
        */
        boolean[] visited = new boolean[n+1];
        while(maxLevel>0){
            int numLight = 0;
            for(int i=1;i<=n;i++) {
                if(visited[i]) continue;
                if(levels[i]==maxLevel){
                    int leaf = i;
                    visited[leaf] = true;
                    for(int parent: graph[leaf]){
                        if(visited[parent]) continue;
                        visited[parent] = true;
                        numLight++;
                    }
                }
            }
            maxLevel--;
            answer+=numLight;
        }
        
        
        
        return answer;
    }
}