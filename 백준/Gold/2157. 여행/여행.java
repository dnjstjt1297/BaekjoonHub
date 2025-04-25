import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int v;
    int cost;
    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
}

public class Main {
    static int n,m,k;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if(v<w) graph[v].add(new Node(w, cost));
        }

        int ans = 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                dp[i][j] = -1;
            }
        }
        dp[1][1] = 0;

        for(int i=2; i<=m;i++){
            for(int j=1; j<=n;j++){
                if(dp[i-1][j]!=-1){
                    for(Node node : graph[j]){
                        dp[i][node.v] = Math.max(dp[i][node.v], dp[i-1][j]+node.cost);
                        if(node.v==n){
                            ans = Math.max(ans, dp[i][node.v]);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }


}
