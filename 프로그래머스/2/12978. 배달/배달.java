import java.util.*;

class Node implements Comparable<Node>{

    int v;
    int cost;
    public Node(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o){
        return this.cost-o.cost;
    }
    
}

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Node>[] graph = new ArrayList[N+1];
        int[] inDegree = new int[N+1];
        
        for(int i=0; i<=N;i++) {
            graph[i] = new ArrayList<>();
            inDegree[i] = Integer.MAX_VALUE;
        }
        
        int M = road.length;
        for(int i=0; i<M; i++){
            graph[road[i][0]].add(new Node(road[i][1],road[i][2]));
            graph[road[i][1]].add(new Node(road[i][0],road[i][2]));
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(1);
        inDegree[1] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(Node e: graph[cur]){
                if(inDegree[e.v] > inDegree[cur]+e.cost){
                    inDegree[e.v] = inDegree[cur]+e.cost;
                    q.add(e.v);
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            if(inDegree[i]<=K) answer++;
        }
        
        return answer;
    }
}