
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static long answer = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(arr,N,1,0,0);
        System.out.println(answer);
    }
    public static void dfs(int[][] arr, int N, long a, long b, int depth){
        if(depth >= N) return;
        answer = Math.min(answer,Math.abs(a*arr[depth][0]-(b+arr[depth][1])));
        dfs(arr,N,a*arr[depth][0],b+arr[depth][1],depth+1);
        dfs(arr,N,a,b,depth+1);
    }
}
