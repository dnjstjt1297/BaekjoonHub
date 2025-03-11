import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int ROOT = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[v].add(w);
            graph[w].add(v);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.offer(ROOT);
        visited[ROOT] = true;

        int[] parents = new int[N+1];

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : graph[cur]) {
                if(visited[next]) continue;
                parents[next] = cur;
                visited[next] = true;
                q.offer(next);
            }
        }

        for(int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }

    }
}