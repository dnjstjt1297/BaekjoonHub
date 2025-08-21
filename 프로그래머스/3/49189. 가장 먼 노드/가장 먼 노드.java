import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int N = 0;
        for(int[] e : edge){
            N = Math.max(Math.max(e[0],e[1]), N);
        }
        
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1; i<N+1; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0;i<edge.length;i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        int[] inDegree = new int[N+1];
        Arrays.fill(inDegree, N);
        
        inDegree[1] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1,0});
        
        
        int max = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int node : graph[cur[0]]){
                if(inDegree[node]>cur[1]+1){
                    inDegree[node] = cur[1]+1;
                    max = Math.max(inDegree[node], max);
                    q.add(new int[]{node,cur[1]+1});
                }
            }
        }
        
        for(int e : inDegree){
            if(e == max) answer++;
        }
        
        return answer;
    }
}