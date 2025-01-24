import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) seq[i] = Integer.parseInt(st.nextToken());

        int start = 0, end = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while (start < N) {
            if (end == N) {
                if (sum >= S) answer = Math.min(answer, end - start);
                sum -= seq[start++];
            } else if (sum < S) sum += seq[end++];
            else {
                answer = Math.min(answer, end - start);
                sum -= seq[start++];
            }
        }
        if(answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);
    }

}