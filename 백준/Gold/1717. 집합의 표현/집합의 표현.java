import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 0; i<=n;i++) parent[i] = i;
        for(int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(oper==0) union(a,b);
            else if(oper==1){
                int pa = find(a);
                int pb = find(b);
                if(pa==pb) System.out.println("YES");
                else System.out.println("NO");
            }
        }


    }

    public static int find(int n){
        if(parent[n] == n) return n;
        parent[n] = find(parent[n]);
        return parent[n];
    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa<pb) parent[pb] = pa;
        else parent[pa] = pb;
    }
}