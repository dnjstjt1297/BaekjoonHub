import java.util.*;

class Node implements Comparable<Node>{
    int w;
    int cost;
    public Node(int w, int cost){
        this.w = w;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        ArrayList<Node>[] graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
        
        for(int i=0;i<paths.length;i++){
            int v = paths[i][0];
            int w = paths[i][1];
            int cost = paths[i][2];
            graph[v].add(new Node(w,cost));
            graph[w].add(new Node(v,cost));
        }
        
        boolean[] is_summits = new boolean[n+1];
        for(int e: summits){
            is_summits[e] = true;
        }
        
        int[] answer = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE};
        
        for(int s: gates){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n+1];
            pq.add(new Node(s,0));
            for(int t : gates) visited[t] = true;
            int intensity = 0;
            
            int cntSummits = 0;
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                intensity = Math.max(intensity, cur.cost);   
                visited[cur.w] = true;
                if(is_summits[cur.w]){
                    cntSummits++;
                    if(intensity < answer[1]){
                        answer[1] = intensity;
                        answer[0] = cur.w;
                    }
                    else if(intensity == answer[1]){
                        if(cur.w < answer[0]) answer[0] = cur.w;
                    }
                    else{
                        break;
                    }
                    continue;
                }
                if(cntSummits == summits.length) break;
                
                for(Node next : graph[cur.w]){
                    if(visited[next.w]) continue;
                    pq.add(next);
                }
                
            }
        }
        
        return answer;
    }
}