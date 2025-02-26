import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        permutation(new boolean[N+1], N, M, 1,0);
    }

    public static void permutation(boolean[] visited, int N, int M, int idx , int cnt){
        if(cnt == M){
            for(int i = 1; i <= N; i++){
                if(visited[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        if(idx > N) return;

        visited[idx] = true;
        permutation(visited, N,M,idx+1, cnt+1);
        visited[idx] = false;
        permutation(visited, N,M,idx+1, cnt);
    }
}