import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] parent;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int[][] arr = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b){
                int temp = a;
                a = b;
                b = temp;
            }
            arr[i][0] = a;
            arr[i][1] = b;
        }

        for(int i = 0; i < M; i++) {
            if(find(arr[i][0]) == find(arr[i][1])) {
                answer=i+1;
                break;
            }
            union(arr[i][0],arr[i][1]);
        }

        System.out.println(answer);
    }

    public static int find(int n){
        if(parent[n] != n) {
            parent[n] = find(parent[n]); // 경로 압축!
        }
        return parent[n];
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        parent[pa] = pb;
    }
}

