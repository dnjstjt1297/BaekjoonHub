import java.util.*;
import java.io.*;


public class Main {
    static final int INF = 1000000007;
    static int n, m;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = INF;
                if (i == j) dist[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i = 1; i <=n; i++){
            int cnt = 0;
            Set<Integer> set = new HashSet<>();
            for(int j = 1; j <=n; j++){
                if(dist[j][i] != INF) set.add(j);
                if(dist[i][j] != INF) set.add(j);
            }
            System.out.println(n-set.size());
        }
    }
}