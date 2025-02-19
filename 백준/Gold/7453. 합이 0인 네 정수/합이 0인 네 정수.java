import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = sumArrs(A,B,N);
        int[] CD = sumArrs(C,D,N);
        Arrays.sort(CD);

        long result = 0;
        for(int i = 0; i < N*N; i++) {
            int lower = lowerBound(CD,-AB[i]);
            int upper = upperBound(CD,-AB[i]);
            result+=(upper-lower);
        }
        System.out.println(result);
    }
    public static int[] sumArrs(int[] A, int[] B, int N){
        int[] result = new int[N*N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result[i*N+j] += A[i]+B[j];
            }
        }
        return result;
    }
    public static int upperBound(int[] arr, int find) {
        int left = 0;
        int right = arr.length ;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int lowerBound(int[] arr, int find) {
        int left = 0;
        int right = arr.length ;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}