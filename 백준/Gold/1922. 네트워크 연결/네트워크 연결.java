import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] edges;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(edges, (o1, o2) -> o1[2]-o2[2]);

        parent = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int result = kruskal();
        System.out.println(result);

    }
    public static int kruskal() {
        int result = 0;
        for(int i = 0; i<M; i++){
            if(find(edges[i][0]) != find(edges[i][1])){
                result+=edges[i][2];
                union(edges[i][0], edges[i][1]);
            }
        }
        return result;
    }

    public static int find(int n){
        if(parent[n] == n) return n;
        n = find(parent[n]);
        return n;
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        parent[pa] = pb;
    }
}