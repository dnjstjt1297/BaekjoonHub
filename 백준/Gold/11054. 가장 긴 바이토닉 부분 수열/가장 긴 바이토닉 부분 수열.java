import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(bitonick(arr,n));


    }
    public static int bitonick(int[] arr, int n){

        int result = 0;

        for(int i = 0; i<n;i++){

            ArrayList<Integer> first = toSubArray(arr,0, i-1, arr[i]);
            ArrayList<Integer> second= toSubArray(arr,i+1, n-1,arr[i]);
            Collections.reverse(second);
            int firstLis = lis(first);
            int secondLis = lis(second);
            result = Math.max(result, firstLis+secondLis+1);
        }
        return result;
    }


    public static ArrayList<Integer> toSubArray(int[] arr, int start, int end, int bound) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            if(arr[i] < bound) result.add(arr[i]);
        }
        return result;
    }

    public static int lis(ArrayList<Integer> arr){
        if(arr.size() == 0) return 0;

        ArrayList<Integer> lisArr = new ArrayList<>();
        lisArr.add(arr.get(0));

        int idx = 0;
        for(int i = 1; i<arr.size(); i++) {
            if(arr.get(i)>lisArr.get(idx)) {
                lisArr.add(arr.get(i));
                idx++;
            }
            else {
                int mid = binarysearch(lisArr, arr.get(i));
                lisArr.set(mid,arr.get(i));
            }
        }
        return idx+1;
    }

    public static int binarysearch(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size()-1;
        while(start<=end) {
            int mid = (start+end)/2;
            if(arr.get(mid)==target) {
                return mid;
            }
            else if(arr.get(mid)>target) {
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

}