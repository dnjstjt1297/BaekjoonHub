
class Solution {
    int max = 0;
    int[][] parent;
    public int solution(int n, int infection, int[][] edges, int k) {
        int answer = 0;
        boolean[] infections = new boolean[n+1];
        infections[infection] = true;
        
        parent = new int[4][n+1];
        for(int i = 1; i<=3; i++){
            for(int j = 0; j<=n; j++) parent[i][j] = j;
        }
        
        for(int[] edge : edges){
            union(edge[2], edge[0], edge[1]);
        }
        
        dfs(edges, infections ,n, k, 0);
        answer = max;
        
        
        
        return answer;
    }
    
    public void dfs(int[][] edges,boolean[] infections, int n, int k , int cnt){
        if(cnt>=k){
            int sum = 0;
            for(int i = 1; i<=n;i++){
                if(infections[i]) sum++;
            }
            max = Math.max(max, sum);
            return;
        }
        
        
        for(int i = 1; i<=3; i++){ 
            boolean[] infectionsCopy = infections.clone();
            
            for(int j = 1; j<=n; j++){
                if(infectionsCopy[j]){
                    int p = find(i,j);
                    for(int l = 1; l<=n; l++){
                        if(p==find(i,l)){
                            infectionsCopy[l] = true;
                        }
                    }
                }
            }
            
            dfs(edges,infectionsCopy, n, k, cnt+1);
        }
        
    }
    
    public int find(int t, int a){
        if(parent[t][a] == a) return a;
        parent[t][a] = find(t,parent[t][a]);
        return parent[t][a];
    }
    
    public void union(int t, int a, int b){
        int pa = find(t,a);
        int pb = find(t,b);
        parent[t][pa] = parent[t][pb];
    }
}