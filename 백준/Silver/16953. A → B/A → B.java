import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new LinkedList<>();
        q.add(new long[] {N,1});

        while(!q.isEmpty()) {
            long[] cur = q.poll();
            if(cur[0]==M){
                System.out.println(cur[1]);
                return;
            }

            if(cur[0]*2<=M) q.add(new long[] {cur[0]*2,cur[1]+1});
            if(cur[0]*10+1<=M) q.add(new long[] {cur[0]*10+1,cur[1]+1});
        }
        System.out.println(-1);
    }
}