

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        solve(N,1,2,3);
        System.out.println(cnt);
        System.out.println(sb);
    }


    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();
    public static void solve(int n, int one, int two, int three) {
        if(n==1) {
            cnt++;
            sb.append(one+" "+three+"\n");
            return;
        }
        solve(n-1, one, three, two);
        cnt++;
        sb.append(one+" "+three+"\n");
        solve(n-1, two, one, three);
    }
}
