import java.util.*;
import java.io.*;

class Node{
    int v;
    public Node(int v){
        this.v = v;
    }
}

class TopologySort{
    ArrayList<Node>[] graph;
    int N;
    ArrayList<Integer> sorted;
    public TopologySort(ArrayList<Node>[] graph, int N){
        this.graph = graph;
        this.N = N;
    }

    public void sort(){
        this.sorted = new ArrayList<>();
        int[] inDegree = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=1;i<=N;i++){
            for(Node e : graph[i]){
                inDegree[e.v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(inDegree[i]==0){
                q.add(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            sorted.add(cur);
            for(Node e : graph[cur]){
                inDegree[e.v]--;
                if(inDegree[e.v]==0 && !visited[e.v]){
                    q.add(e.v);
                    visited[e.v] = true;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for(int j=1;j<len;j++){
                int next = Integer.parseInt(st.nextToken());
                graph[prev].add(new Node(next));
                prev = next;
            }
        }

        TopologySort sort = new TopologySort(graph, N);
        sort.sort();
        if(sort.sorted.size() != N){
            System.out.println(0);
        }
        else {
            for (int i = 0; i < sort.sorted.size(); i++) {
                System.out.println(sort.sorted.get(i));
            }
        }

    }
}
