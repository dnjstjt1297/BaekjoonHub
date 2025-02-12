

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Set<String> set = Stream.of(arr).collect(Collectors.toSet());
        String[] newArr = set.toArray(new String[set.size()]);

        quickSort(newArr,0,newArr.length-1);
        for(String s : newArr) System.out.println(s);
    }

    public static void quickSort(String[] arr, int left, int right) {
        if(left >= right) return;
        int pivot = left;
        int lo = left+1;
        int hi = right;

        while(lo <= hi) {
            while(lo <= right && compare(arr[lo],arr[pivot])<=0) lo++;
            while(hi > left  && compare(arr[hi],arr[pivot])>=0) hi--;

            if(lo > hi) swap(arr, hi, pivot);
            else swap(arr, lo, hi);
        }
        quickSort(arr, left, hi - 1);
        quickSort(arr, hi + 1, right);
    }

    public static int compare(String arr1, String arr2) {
        if(arr1.length() == arr2.length()){
            for(int i = 0; i < arr1.length(); i++){
                if(arr1.charAt(i) == arr2.charAt(i)) continue;
                return arr1.charAt(i) - arr2.charAt(i);
            }
        }
        return arr1.length() - arr2.length();
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
