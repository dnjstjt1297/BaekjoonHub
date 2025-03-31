import java.util.*;
import java.io.*;

class Node{
    int v;
    int cost;
    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    static final int INF = 1000000007;
    static int n, m;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(w, cost));
            graph[w].add(new Node(v, cost));
        }

        System.out.println(dijkstra(1));
    }
    public static int dijkstra(int start) {
        int[] inDegree = new int[n + 1];
        Arrays.fill(inDegree, INF);
        inDegree[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>( new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.v == n) return cur.cost;

            for(Node next : graph[cur.v]) {
                if(inDegree[next.v]> inDegree[cur.v] + next.cost) {
                    inDegree[next.v] = inDegree[cur.v] + next.cost;
                    pq.add(new Node(next.v, inDegree[next.v]));
                }
            }
        }

        return -1;
    }
}
