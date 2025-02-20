import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node{
    long sum;
    long x;
    long y;
    public Node(long sum, long x, long y) {
        this.sum = sum;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long[] result = new long[3];

        long min = Long.MAX_VALUE;
        for(int i = 0; i < N-2; i++) {
            int left = i+1;
            int right = N-1;
            while(left<right){
                long mix = Math.abs(arr[left] + arr[right]+ arr[i]);
                if(min>mix){
                    min = mix;
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }
                if(Math.abs(arr[left+1]+arr[right]+arr[i]) < Math.abs(arr[left]+arr[right-1]+arr[i])){
                    left++;
                }
                else right--;
            }
        }
        for(int i = 0; i < 3; i++) {
            System.out.print(result[i]+" ");
        }
    }
}