import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A;
    static int B,C;

    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        tmp = new int[N];
        for(int i =0; i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        br.close();

        long cnt = 0;
        for(int i =0; i<N; i++){
            if(A[i]<=B){
                cnt++;
            }
            else{
                cnt++;
                cnt += (A[i]-B)/C;
                if((A[i]-B)%C!=0){
                    cnt++;
                }
            }
        }

        bw.write(Long.toString(cnt));
        bw.close();
    }
}