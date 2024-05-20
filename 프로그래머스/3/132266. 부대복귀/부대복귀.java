import java.util.*;


class Solution {
    static ArrayList<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++) graph[i] = new ArrayList<>();
        
        for(int i=0;i<roads.length;i++){
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        for(int i=0;i<sources.length ;i++){
           answer[i] = dijkstra(graph, n, sources[i], destination);
        }
        return answer;
    }
    public static int dijkstra(ArrayList<Integer>[] graph,int n, int start, int destination){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int[] inDegree = new int[n+1];
        Arrays.fill(inDegree, Integer.MAX_VALUE);
        inDegree[start] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(destination==cur) return inDegree[cur];
            for(int next : graph[cur]){
                if(inDegree[next]>1+inDegree[cur]){
                    inDegree[next] = 1+inDegree[cur];
                    if(destination== next) return inDegree[next];
                    q.add(next);
                }
            }
        }
        return -1;
    }
}