import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int node;
    long cost;
    public Node(int node, long cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(o.cost,this.cost);
    }
}

public class Main {

    static int N, M, K;
    static Node[] node;
    static List<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        node = new Node[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) node[i] = new Node(i, Long.parseLong(st.nextToken()));
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v].add(node[w]);
            graph[w].add(node[v]);
        }
        visited = new boolean[N+1];

        List<long[]> groupList = new ArrayList<>();
        for(int i = 1; i <=N; i++){
            if(visited[i]) continue;
            groupList.add(prim(node[i]));
        }

        long[][] groups = new long[groupList.size()+1][2];
        for(int i = 1; i <= groupList.size(); i++){
            groups[i][0] = groupList.get(i-1)[0];
            groups[i][1] = groupList.get(i-1)[1];
        }
        int L = groups.length;

        long[][] dp = new long[L][K];
        long result = 0;

        for(int i = 1; i <L; i++){
            for(int j = 1; j < K; j++){
                if(j<groups[i][0]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-(int)groups[i][0]]+groups[i][1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }

    public static long[] prim(Node root){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(root);
        long cost = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visited[cur.node]) continue;
            visited[cur.node] = true;
            cost += cur.cost;
            cnt++;
            for( Node next : graph[cur.node]){
                if(visited[next.node]) continue;
                pq.add(next);
            }
        }

        return new long[]{cnt, cost};
    }


}