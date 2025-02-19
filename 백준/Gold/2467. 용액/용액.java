import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int totalMin = Integer.MAX_VALUE;

        int[] result = new int[2];
        int j = N-1;
        int i = 0;
        while(i<j) {
            int min = Integer.MAX_VALUE;
            while(j>i){
                int mix = Math.abs(arr[i]+arr[j]);

                if(min>mix) min = mix;
                else{
                    j++;
                    break;
                }
                j--;
            }
            if(j==i) j++;

            if(totalMin>=min){
                totalMin = min;
                result[0] = arr[i];
                result[1] = arr[j];
            }
            i++;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}