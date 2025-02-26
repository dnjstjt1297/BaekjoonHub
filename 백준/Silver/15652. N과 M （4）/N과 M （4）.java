import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        permutation(new ArrayList<>(), N, M, 1,0);
    }

    public static void permutation(ArrayList<Integer> arr, int N, int M, int idx, int cnt){
        if(cnt == M){
            for(int e: arr){
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i<=N; i++){
            ArrayList nArr = new ArrayList(arr);
            nArr.add(i);
            permutation(nArr, N, M, i, cnt+1);
        }

    }
}