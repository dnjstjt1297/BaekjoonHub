import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = s;
            arr[i][1] = e;
        }


        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        int[] lis = findLis(arr);
        boolean[] visited = new boolean[500001];
        for(int i=0;i<N;i++){
            visited[lis[i]] = true;
        }

        System.out.println(cnt);
        for(int i=0;i<arr.length;i++){
            if(!visited[arr[i][0]]) System.out.println(arr[i][0]);
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
    public static int[] findLis(int arr[][]){
        int[] lis = new int[arr.length];
        int[] recodes = new int[arr.length];
        int recode =0;

        lis[0] = arr[0][1];
        int j = 0;
        int i = 1;
        while(i<arr.length){
            if(lis[j]<arr[i][1]){
                lis[j+1] = arr[i][1];
                recode++;
                recodes[i] = recode;
                j++;
            }
            else{
                int idx = binarySearch(lis, 0, j, arr[i][1]);
                lis[idx] = arr[i][1];
                recodes[i] = idx;
            }
            i++;
        }

        cnt = arr.length-recode-1;

        int[] result = new int[arr.length];
        int tmp = 0;
        for(int k=0;k<arr.length;k++){
            if(recodes[k] == recode){
                tmp = k;
            }
        }

        for(int k = tmp; k>=0;k--){
            if(recodes[k] == recode){
                result[recode] = arr[k][0];
                recode--;
            }
        }

        return result;
    }
}