import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<Integer> bfs = new ArrayList<>();
    static List<Integer> dfs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int i = 0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for(int i = 1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        bfs(graph, N, V);
        dfs(graph,new boolean[N+1],V);

        dfs.forEach(i -> System.out.print(i+" "));
        System.out.println();
        bfs.forEach(i -> System.out.print(i+" "));
    }

    public static void bfs(List<Integer>[] graph, int N, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            bfs.add(cur);

            for(int e : graph[cur]){
                if(!visited[e]){
                    visited[e] = true;
                    q.add(e);
                }
            }
        }
    }

    public static void dfs(List<Integer>[] graph, boolean[] visited, int v){
        dfs.add(v);
        visited[v] = true;

        for(int e : graph[v]){
            if(visited[e]) continue;
            dfs(graph,visited, e);
        }
    }
}