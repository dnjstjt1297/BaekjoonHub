import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1 && i<j){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[m];
        for(int i = 0; i<m;i++){
            arr[i] = find(Integer.parseInt(st.nextToken())-1);
        }

        int k = arr[0];
        for(int i = 1; i<m; i++){
            if(arr[i]!=k){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
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