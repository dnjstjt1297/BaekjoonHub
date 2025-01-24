import java.util.*;
import java.io.*;

class Edge{
    int w;
    int v;
    int cost;
    public Edge(int v, int w, int cost) {
        this.w = w;
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[M];

        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(v, w, cost);
        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.cost - e2.cost;
            }
        });

        int answer = kruskal(edges, N, M);
        System.out.println(answer);

    }

    public static int kruskal(Edge[] edges, int N, int M){
        int[] parents = new int[N+1];
        for(int i=1; i<=N; i++) parents[i] = i;

        int maxCost = 0;
        int totalCost = 0;
        for(int i=0; i<M; i++){
            if(find(parents,edges[i].v)!=find(parents,edges[i].w)){
                totalCost += edges[i].cost;
                union(parents,edges[i].v,edges[i].w);
                maxCost = Math.max(maxCost,edges[i].cost);
            }
        }
        totalCost -= maxCost;
        return totalCost;
    }

    public static void union(int[] parents, int a, int b){
        int pa = find(parents, a);
        int pb = find(parents, b);

        if(pa > pb) parents[pa] = pb;
        else parents[pb] = pa;
    }

    public static int find(int[] parents, int n){
        if(parents[n] == n) return n;
        int w = find(parents, parents[n]);
        return w;
    }

}