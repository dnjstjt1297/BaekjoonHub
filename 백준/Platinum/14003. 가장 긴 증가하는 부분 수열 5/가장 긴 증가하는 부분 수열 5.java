import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = findLis(arr);


        System.out.println(cnt);
        for(int i=0;i<cnt;i++){
            System.out.print(lis[i]+" ");
        }

    }

    public static int binarySearch(int[] arr, int left, int right, int target){
        int mid;
        while(left < right){
            mid = (left + right)/2;
            if(target>arr[mid]){
                left = mid + 1;
            }
            else right = mid;
        }
        return right;
    }

    static int cnt=0;
    public static int[] findLis(int arr[]){
        int[] lis = new int[arr.length];
        int[] recodes = new int[arr.length];
        int recode =0;

        lis[0] = arr[0];
        int j = 0;
        int i = 1;
        while(i<arr.length){
            if(lis[j]<arr[i]){
                lis[j+1] = arr[i];
                recode++;
                recodes[i] = recode;
                j++;
            }
            else{
                int idx = binarySearch(lis, 0, j, arr[i]);
                lis[idx] = arr[i];
                recodes[i] = idx;
            }
            i++;
        }
        cnt = recode+1;

        int[] result = new int[arr.length];
        int tmp = 0;
        for(int k=0;k<arr.length;k++){
            if(recodes[k] == recode){
                tmp = k;
                break;
            }
        }

        for(int k = tmp; k>=0;k--){
            if(recodes[k] == recode){
                result[recode] = arr[k];
                recode--;
            }
        }

        return result;
    }
}