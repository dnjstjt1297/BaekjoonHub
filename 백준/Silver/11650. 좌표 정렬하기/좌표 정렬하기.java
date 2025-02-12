import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i =0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        mergeSort(arr,new int[n][2],0,n-1);
        for(int[] e : arr) System.out.println(e[0]+" "+e[1]);
    }

    public static void mergeSort(int[][] arr,int[][] temp, int start, int end){
        if(start >= end) return;

        int mid = (end + start)/2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp,mid + 1, end);

        int left = start;
        int right = mid + 1;
        int idx = left;

        while(left <= mid || right <= end){
            if(right>end || (left<=mid && compare(arr[left], arr[right])<0))
                temp[idx++] = arr[left++];
            else
                temp[idx++] = arr[right++];
        }

        for(int i = start; i <= end; i++)
            arr[i] = temp[i];

    }

    public static int compare(int[] arr1, int[] arr2) {
        if(arr1[0] == arr2[0]) return arr1[1] - arr2[1];
        return arr1[0] - arr2[0];
    }
}
