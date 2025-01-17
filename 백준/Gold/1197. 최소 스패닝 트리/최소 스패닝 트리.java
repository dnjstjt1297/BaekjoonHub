import java.util.*;
import java.io.*;

class Edge{
    int v;
    int w;
    int cost;
    public Edge(int v, int w, int cost){
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0;i<=N;i++) parent[i] = i;

        Edge[] edges = new Edge[M];
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(v,w,cost);
        }
        System.out.println(kruskal(edges,N,M));
    }

    public static int kruskal(Edge[] edges, int N, int M){
        int result = 0;

        Arrays.sort(edges,new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.cost - e2.cost;
            }
        });


        int cnt = 0;
        for(int i =0;i<M;i++){
            int pv = find(edges[i].v);
            int pw = find(edges[i].w);

            if(pv!=pw){
                result+= edges[i].cost;
                union(pv,pw);
                cnt++;
            }
            if(cnt == N-1) break;
        }
        return result;
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
    }

    public static int find(int n){
        if(parent[n] == n) return n;
        parent[n] = find(parent[n]);
        return parent[n];
    }
}