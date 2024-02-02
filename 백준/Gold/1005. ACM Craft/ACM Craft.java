import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] timeList = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                timeList[i] = Integer.parseInt(st.nextToken());
            }

            int[][] edges = new int[K][2];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
                edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
            }

            int W = Integer.parseInt(br.readLine()) - 1;

            int[] maxTime = new int[N];
            boolean[] visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                maxTime[i] = -1;
                visited[i] = false;
            }

            sb.append(findMaxTime(W, timeList, edges, maxTime, visited)).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static int findMaxTime(int node, int[] timeList, int[][] edges, int[] maxTime, boolean[] visited) {
        if (maxTime[node] != -1) return maxTime[node];

        visited[node] = true;
        int max = timeList[node];

        for (int[] edge : edges) {
            if (edge[1] == node && !visited[edge[0]]) {
                max = Math.max(max, timeList[node] + findMaxTime(edge[0], timeList, edges, maxTime, visited));
            }
        }

        visited[node] = false;
        maxTime[node] = max;
        return max;
    }
}
