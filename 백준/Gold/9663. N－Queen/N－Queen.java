import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dfs(0);
        System.out.println(cnt);
    }
    public static void dfs(int depth){
        if(depth == N){
            cnt++;
            return;
        }

        for(int i = 0; i < N; i++){
            arr[depth] = i;
            if(check(depth)) dfs(depth+1);
        }
    }

    public static boolean check(int col){
        for(int i = 0; i < col; i++){
            if(arr[i] == arr[col]) return false;
            if(col-i == Math.abs(arr[col]-arr[i])) return false;
        }
        return true;
    }
}