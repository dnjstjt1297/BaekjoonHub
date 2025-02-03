import java.util.*;
import java.io.*;

public class Main {

    static final int INF = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<int[]>[] graph = new List[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            distance[i] = INF;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        q.add(new int[]{start,0});
        distance[start] = 0;

        int answer = -1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == end) {
                answer = cur[1];
                break;
            }
            for(int[] child : graph[cur[0]]) {
                if(distance[child[0]] > cur[1] + child[1]) {
                    q.add(new int[]{child[0], cur[1]+child[1]});
                    distance[child[0]] = cur[1] + child[1];
                }
            }
        }

        System.out.println(answer);
    }
}