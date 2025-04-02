import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] dist;;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        dist = new int[v+1][v+1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                dist[i][j] = 100000007;
            }
        }

        for(int i = 0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = c;
        }


        for(int k=1; k<=v; k++) {
            for(int j=1; j<=v; j++) {
                for(int i=1; i<=v; i++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int minCycle = Integer.MAX_VALUE;
        for(int i = 1; i<=v;i++){
            minCycle = Math.min(minCycle, dist[i][i]);
        }
        if(minCycle == 100000007) System.out.println(-1);
        else System.out.println(minCycle);
    }

}
