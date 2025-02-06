
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] meetings = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meetings, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o1[1];
            }
            return o1[1] - o2[1];
        });

        int answer = 0;
        int time = 0;
        for(int[] meeting : meetings) {
            if(time<=meeting[0]){
                answer++;
                time = meeting[1];
            }
        }

        System.out.println(answer);
    }

}
