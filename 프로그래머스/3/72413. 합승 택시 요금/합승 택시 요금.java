class Solution {
    final int INF = 1000000007;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] dist = floyd(n, fares);
        answer = run(dist, n, s, a, b);
        
        
        return answer;
    }
    
    public int run(int[][] dist, int n, int s, int a, int b){
        int result = Integer.MAX_VALUE;
        
        for(int i = 1; i<=n; i++){
            if(dist[s][i]==INF || dist[i][a] == INF || dist[i][b] == INF) continue;
            int sum=dist[s][i]+dist[i][a]+dist[i][b];
            result = Math.min(result, sum);
        }
        
        return result;
    }
    
    public int[][] floyd(int n, int[][] fares){
        int[][] dist = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dist[i][j] = INF;
                if(i==j) dist[i][j] = 0;
            }
        }
        
        for(int i=0; i<fares.length; i++){
            int v = fares[i][0];
            int w = fares[i][1];
            int cost = fares[i][2];
            dist[v][w] = cost;
            dist[w][v] = cost;
        }
        
        for(int k=1;k<=n;k++){
            for( int i=1; i<=n;i++){
                for( int j=1; j<=n; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        
        return dist;
        
    }
}