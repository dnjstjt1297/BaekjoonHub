import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        lis[0] = arr[0];
        int size = 1;
        for(int i = 1; i<N;i++){
            if(lis[size-1] < arr[i]){
                lis[size]=arr[i];
                size++;
                continue;
            }

            int pos = binarySearch(lis, 0, size, arr[i]);
            lis[pos] = arr[i];
        }

        System.out.println(size);
    }

    public static int binarySearch(int[] arr, int left, int right , int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}